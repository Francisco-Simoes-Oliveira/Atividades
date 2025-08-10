#include <stdio.h>
#include <stdlib.h>

#include "execucao.h"
#include "lib.h"
#include "regis.h"

void execucao_loop(Memory *mem, uint32_t size, registrador *reg){
    if (mem == NULL){
        printf("Memoria vazia");
        exit(1);
    }
    uint32_t pc_anterior = reg->pc;
    uint8_t inst_r[5];
    uint16_t inst_i[4];

    int max_cycles = 10000;  // limite para evitar loop infinito
    int cycles = 0;
     
    while (reg->pc < size){
        pc_anterior = reg->pc;
        //uint16_t instruction = (mem->data[reg->pc + 1] << 8) | mem->data[reg->pc];
        uint16_t instruction = memory_read_word(mem, reg->pc);

        //printf("PC antes: %u, instrucao: 0x%04X\n", reg->pc, instruction);


        int format = extract_bits(instruction,15,1);
        //printf("PC antes: %u, instrucao: 0x%04X\n", reg->pc, instruction);
        if (format == 0)
        {
            decodi_r(instruction, inst_r);
          // printf("PC: %u | Instrucao: 0x%04X | Opcode R: %u\n", reg->pc, instruction, inst_r[1]);
            execut_r(reg, inst_r, mem);
        } else if (format == 1)
        {
            decodi_i(instruction, inst_i);
            //printf("PC: %u | Instrucao: 0x%04X | Opcode I: %u\n", reg->pc, instruction, inst_i[1]);
            execut_i(reg, inst_i);
        }
        
        if (reg->pc == pc_anterior)
        {
            reg->pc += 1;
        }
        //printf("PC antes: %u, instrucao: 0x%04X\n", reg->pc, instruction);

        cycles++;
        if (cycles >= max_cycles) {
        printf("Parando: atingiu limite de ciclos\n");
        break;
        }
    }

}

void decodi_r(uint16_t instruction, uint8_t inst_r[]){
    inst_r[0] = extract_bits(instruction,15,1); // Formato
    inst_r[1] = extract_bits(instruction,9,6);  // opCode   
    inst_r[2] = extract_bits(instruction,6,3);  // destino
    inst_r[3] = extract_bits(instruction,3,3);  // op1  
    inst_r[4] = extract_bits(instruction,0,3);  // op2  

    //return inst_r;
}

void execut_r(registrador *reg, uint8_t inst_r[], Memory *mem){

    switch(inst_r[1]){
        case 0: //ADD
           reg->r[inst_r[2]] = reg->r[inst_r[3]] + reg->r[inst_r[4]];
           //printf("ADD Valor de r: %u \n", reg->r[inst_r[2]]);
           break;    
        case 1: // SUB
            reg->r[inst_r[2]] = reg->r[inst_r[3]] - reg->r[inst_r[4]];
            //printf("SUB valor de r: %u \n", reg->r[inst_r[2]]);
            break;   
        case 2: // MUL
            reg->r[inst_r[2]] = reg->r[inst_r[3]] * reg->r[inst_r[4]];
            //printf("mul valor de r: %u \n", reg->r[inst_r[2]]);
            break;   
        case 3: // DIV
            reg->r[inst_r[2]] = reg->r[inst_r[3]] / reg->r[inst_r[4]];
            //printf("div valor de r: %u \n", reg->r[inst_r[2]]);
            break;        
        case 4: // cmp_equal Compara se operandos op1 = op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] == reg->r[inst_r[4]];
            //printf("cmp_equal \n");
            break;
        case 5: // Cmp_neq Compara se operandos op1 != op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] != reg->r[inst_r[4]];
             //printf("cmp_neq compara se %u != %u, resultado: %u\n",reg->r[inst_r[3]], reg->r[inst_r[4]], reg->r[inst_r[2]]);
            break;
        case 6: // Cmp_less Compara se op1 < op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] < reg->r[inst_r[4]];
            //printf("cmp_less \n");
            break;
        case 7: // Cmp_greater Compara se op1 > op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] > reg->r[inst_r[4]];
            //printf("cmp_greater \n");
            break;
        case 8: // Cmp_less_eq Compara se op1 <= op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] <= reg->r[inst_r[4]];
            //printf("cmp_less_eq \n");
            break;
        case 9: // Cmp_greater_eq Compara se op1 >= op2
            reg->r[inst_r[2]] = reg->r[inst_r[3]] >= reg->r[inst_r[4]];
            //printf("cmp_greater_eq \n");
            break;
        case 10: // and Operação AND entre registradores
            reg->r[inst_r[2]] = reg->r[inst_r[3]] & reg->r[inst_r[4]];
            //printf("and \n");
            break;
        case 11: // or Operação OR entre registradores
            reg->r[inst_r[2]] = reg->r[inst_r[3]] | reg->r[inst_r[4]];
            //printf("or \n");
            break;
        case 12: //Xor Operação XOR entre registradores
            reg->r[inst_r[2]] = reg->r[inst_r[3]] ^ reg->r[inst_r[4]];
            //printf("xor \n");
            break;
        case 13: // Shl Deslocar bits para a esquerda
            reg->r[inst_r[2]] = reg->r[inst_r[3]] << reg->r[inst_r[4]];
            //printf("shl \n");
            break;
        case 14: // Shr Deslocar bits para a direita
            reg->r[inst_r[2]] = reg->r[inst_r[3]] >> reg->r[inst_r[4]];
            //printf("shr \n");
            break;
        case 15: // Load Carregar da memória para o registrador
            reg->r[inst_r[2]] = memory_read_word(mem, reg->r[inst_r[3]]);
            //printf("Load de endereço %u: valor = %u (0x%04X)\n", reg->r[inst_r[3]], memory_read_word(mem, reg->r[inst_r[3]]), memory_read_word(mem, reg->r[inst_r[3]]));
            break;    
        case 16: // Store Salvar na memória o conteúdo de um registrador
            memory_write_word(mem, reg->r[inst_r[3]], reg->r[inst_r[4]]);
            //printf("store de endereço %u: valor = %u (0x%04X)\n", reg->r[inst_r[3]], reg->r[inst_r[4]], reg->r[inst_r[4]]);
            break;
        case 63: // Syscall
            ex_syscall(reg, mem);
            //printf("\nSyscall \n");
            break;
        
        default:
            printf("Opcode R não implementado: %u\n", inst_r[1]);
    }

    
}

void decodi_i(uint16_t instruction, uint16_t inst_i[]){
    inst_i[0] = extract_bits(instruction,15,1); // Formato
    inst_i[1] = extract_bits(instruction,13,2) ; // Opcode
    inst_i[2] = extract_bits(instruction,10,3);  // Registrador  
    inst_i[3] = extract_bits(instruction,0,10);   // Imediato
    
    //return inst_i;
}

void execut_i(registrador *reg, uint16_t inst_i[]){
    switch(inst_i[1]){
        case 0: // Jump Salto incondicional
            //printf("Jump para: %u\n", inst_i[3]);    
            reg->pc = inst_i[3];
            break;
        case 1: // Jump_cond Salto condicional
            if (reg->r[inst_i[2]] != 0)
            {
                reg->pc = inst_i[3];
                //printf("Jump_cond (r%d != 0) para %u\n", inst_i[2], inst_i[3]);
            }
            break;
        case 2: // Não usado
            break;
        case 3: // Mov Move um imediato para um registrador
            reg->r[inst_i[2]] = inst_i[3];
            //printf("Mov valor %u para registrador r[%u]\n", inst_i[3], inst_i[2]);
            break;
        
        default:
            printf("Opcode I não implementado: %u\n", inst_i[1]);
    }
}


void ex_syscall(registrador *reg, Memory *mem){

    switch(reg->r[0]){
        case 0: //exit
            printf("Fim");
            exit(0);
            break;
        case 1: // Print String
            uint32_t addr = reg->r[1];
            while(mem->data[addr] != 0){
                printf("%c", mem->data[addr]);
                addr++;
            }
            break;
        case 2: // print nova linha
            printf("\n");
            break;
        case 3: // print int
            printf("%d", reg->r[1]);
            break;
        default:
            printf("Valor invalido 2 \n");

    }     

}



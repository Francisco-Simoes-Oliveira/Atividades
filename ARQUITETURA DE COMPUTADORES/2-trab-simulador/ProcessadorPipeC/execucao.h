#ifndef EXECUCAO_H
#define EXECUCAO_H

#include <stdint.h>

#include "lib.h"
#include "regis.h"
#include "memory.h"

typedef struct
{
    
} r_istruc;



void execucao_loop(Memory *mem, uint32_t size, registrador *reg);

void decodi_r(uint16_t instruction, uint8_t inst_r[]);
void execut_r(registrador *reg, uint8_t inst_r[], Memory *mem);
void decodi_i(uint16_t instruction, uint16_t inst_i[]);
void execut_i(registrador *reg, uint16_t inst_i[]);

void ex_syscall(registrador *reg, Memory *mem);
#endif



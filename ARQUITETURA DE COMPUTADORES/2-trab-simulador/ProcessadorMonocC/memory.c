#include <stdint.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "memory.h"


Memory* memory_create(size_t initial_size) {
    Memory* mem = malloc(sizeof(Memory));
    mem->data = calloc(initial_size, sizeof(uint8_t)); // zera a memória
    mem->size = initial_size;
    return mem;
}

void memory_expand(Memory* mem, size_t new_size) {
    if (new_size <= mem->size) return; // nada a fazer

    mem->data = realloc(mem->data, new_size);
    // limpar a memória nova adicionada
    memset(mem->data + mem->size, 0, new_size - mem->size);
    mem->size = new_size;
}

// Escreve 1 byte
void memory_write_byte(Memory* mem, size_t address, uint16_t value) {
    if (address >= mem->size) {
        memory_expand(mem, address + 1);
    }
    mem->data[address] = value;
}

// Lê 1 byte
uint16_t memory_read_byte(Memory* mem, size_t address) {
    if (address >= mem->size) return 0;
    return mem->data[address];
}

// Escreve 4 bytes (um word)
void memory_write_word(Memory* mem, size_t address, uint32_t value) {
    if (address >= mem->size) {
        printf("Erro: acesso de memória fora dos limites\n");
        exit(1);
    }
    mem->data[address] = value;
   
    // if (address + 4 > mem->size) {
    //     memory_expand(mem, address + 4);
    // }
    // for (int i = 0; i < 4; i++) {
    //     mem->data[address + i] = (value >> (i * 8)) & 0xFF;
    // }
}

uint16_t memory_read_word(Memory *mem, uint32_t address) {
    if (address >= mem->size) {
        printf("Erro: acesso de memória fora dos limites\n");
        exit(1);
    }
    return mem->data[address];
}

// Lê 4 bytes como word
// uint32_t memory_read_word(Memory* mem, size_t address) {
//     if (address + 4 > mem->size) return 0;
//     uint32_t result = 0;
//     for (int i = 0; i < 4; i++) {
//         result |= mem->data[address + i] << (i * 8);
//     }
//     return result;
// }

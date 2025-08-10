#ifndef MEMORY_H
#define MEMORY_H    

#include "lib.h"


typedef struct memory
{
    uint16_t *data;
    size_t size;
} Memory;

Memory* memory_create(size_t initial_size);
void memory_expand(Memory* mem, size_t new_size);
void memory_write_byte(Memory* mem, size_t address, uint16_t value);
uint16_t memory_read_byte(Memory* mem, size_t address);
void memory_write_word(Memory* mem, size_t address, uint32_t value);
uint16_t memory_read_word(Memory* mem, uint32_t address);


#endif
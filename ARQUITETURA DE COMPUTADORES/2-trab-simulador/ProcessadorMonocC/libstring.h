#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>

char *extract_bits_str(uint16_t v, uint8_t bstart, uint8_t blength)
{
    uint16_t mask = (1 << blength) - 1;
    uint16_t bits = (v >> bstart) & mask;

    // Aloca string com espaço para bits + nulo
    char *result = malloc(blength + 1);
    if (!result)
        return NULL;

    for (int i = blength - 1; i >= 0; --i)
    {
        result[blength - 1 - i] = (bits & (1 << i)) ? '1' : '0';
    }
    result[blength] = '\0'; // caractere de fim de string

    return result;
}
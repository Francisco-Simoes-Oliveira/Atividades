#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <assert.h>

#include "lib.h"
#include "execucao.h"
#include "regis.h"
#include "memory.h"



int main (int argc, char **argv)
{
	if (argc != 2) {
		printf("usage: %s [bin_name]\n", argv[0]);
		exit(1);
	}

	FILE *fp;
	fp = fopen(argv[1], "rb");
	fseek(fp, 0, SEEK_END);
	uint32_t bsize;
	bsize = ftell(fp);
	fclose(fp);

	Memory *mem = memory_create(bsize);

	registrador reg;
	reg.pc = 1;

	load_binary_to_memory(argv[1], mem->data, mem->size);
	execucao_loop(mem, bsize, &reg);
	
	
	return 0;
}
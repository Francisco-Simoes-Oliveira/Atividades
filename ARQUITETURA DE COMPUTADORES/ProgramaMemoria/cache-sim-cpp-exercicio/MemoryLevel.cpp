#include <iostream>
#include <cstdint>

#include <my-lib/bit.h>
#include "MemoryLevel.h"

class abstract MemoryLevel
{
private:
    std::string nome;
    uint64 latency;

public:
    //Constructor
    MemoryLevel(std::string nome, uint64_t latency){
        this->nome = nome;
        this->latency = latency;
    };
    ~MemoryLevel(){};

    std::string getNome(){
        return this->nome;
    };
    uint64_t getLatency(){
        return this->latency;
    };
};

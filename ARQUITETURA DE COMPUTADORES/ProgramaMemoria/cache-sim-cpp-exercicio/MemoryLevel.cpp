#include <iostream>
#include <cstdint>

#include <my-lib/bit.h>
#include "MemoryLevel.h"

#include <string>
#include <cstdint>

class MemoryLevel {
private:
    std::string nome;
    uint64_t latency;

public:
    // Construtor
    MemoryLevel(std::string nome, uint64_t latency) {
        this->nome = nome;
        this->latency = latency;
    }

    // Destrutor
    virtual ~MemoryLevel() {}

    std::string getNome() {
        return this->nome;
    }

    uint64_t getLatency() {
        return this->latency;
    }
};

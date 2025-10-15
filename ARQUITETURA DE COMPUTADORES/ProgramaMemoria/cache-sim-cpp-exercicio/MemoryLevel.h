#pragma once
#include <string>
#include <cstdint>

class MemoryLevel
{
private:
    std::string nome;
    uint64_t latency;

public:
    // Construtor da classe
    MemoryLevel(std::string nome, uint64_t latency);

    // Destrutor da classe
    virtual ~MemoryLevel();

    // Métodos de acesso
    std::string getNome();
    uint64_t getLatency();
};
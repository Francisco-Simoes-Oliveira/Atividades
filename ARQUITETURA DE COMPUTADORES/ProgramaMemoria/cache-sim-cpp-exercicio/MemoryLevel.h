#ifdef MEMORY_LEVEL_H
#define MEMORY_LEVEL_H


#include <cstdint>
#include <string>

class MemoryLevel
{
private:
    std::string nome;
    uint64_t latency;
public:
    MemoryLevel(std::string nome, uint64_t latency);
    ~MemoryLevel();
    std::string getNome();
    uint64_t getLatency();      
};
#endif

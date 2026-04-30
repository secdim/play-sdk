#include "logger.h"
#include <iostream>

void Logger::log(const std::string& message) {
    std::cerr << "[LOG]: " << message << std::endl;
}

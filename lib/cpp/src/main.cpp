#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include "utils.h"
#include "math_utils.h"
#include "string_utils.h"
#include "logger.h"
#include "config.h"

void processNames(const std::vector<std::string>& names) {
    for (const auto& name : names) {
        char buffer[16];
        getName(buffer, name.c_str(), sizeof(buffer));
        std::string reversedName = StringUtils::reverseString(buffer);
        std::cout << "Original: " << buffer << " | Reversed: " << reversedName << std::endl;
    }
}

int main(int argc, char* argv[]) {
    std::vector<std::string> names;

    Config config;
    config.loadConfig();
    Logger::log("Program started.");

    if (argc > 1) {
        for (int i = 1; i < argc; ++i) {
            names.emplace_back(argv[i]);
        }
    } else {
        std::cout << "Usage: ./main <YOUR NAME>\n";
        return 0;
    }

    processNames(names);
    Logger::log("Processed name: " + std::string(names[0]));

    return 0;
}

#include "config.h"
#include <iostream>

void Config::loadConfig() {
    std::cout << "Loading configuration settings..." << std::endl;
}

std::string Config::getSetting(const std::string& key) {
    if (key == "app_name") {
        return "SecDim";
    }
    return "Unknown Setting";
}

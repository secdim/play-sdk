#include "utils.h"
#include <cstring>
#include <cctype>
#include <algorithm>

std::string toUpperCase(const std::string& str) {
    std::string upperStr = str;
    std::transform(upperStr.begin(), upperStr.end(), upperStr.begin(), [](unsigned char c) {
        return std::toupper(c);
    });
    return upperStr;
}

bool isAlphabetic(const std::string& str) {
    return std::all_of(str.begin(), str.end(), [](unsigned char c) {
        return std::isalpha(c);
    });
}

void getName(char* buffer, const char* name, int maxLength) {
    std::string nameStr(name);

    if (isAlphabetic(nameStr)) {
        std::string upperName = toUpperCase(nameStr);
        std::strncpy(buffer, upperName.c_str(), maxLength);
    } else {
        std::strncpy(buffer, name, maxLength);
    }
}

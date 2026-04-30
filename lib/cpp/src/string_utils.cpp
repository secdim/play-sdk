#include "string_utils.h"
#include <algorithm>

namespace StringUtils {
    std::string reverseString(const std::string& str) {
        std::string result;
        for (auto it = str.rbegin(); it != str.rend(); ++it) {
            result.push_back(*it);
        }
        return result;
    }

    std::string toUpperCase(const std::string& str) {
        std::string result = str;
        for (char &c : result) {
            c = (c >= 'a' && c <= 'z') ? c - 32 : c;
        }
        return result;
    }
}
#ifndef UTILS_H
#define UTILS_H

#include <string>

void getName(char* buffer, const char* name, int maxLength);

std::string toUpperCase(const std::string& str);
bool isAlphabetic(const std::string& str);

#endif // UTILS_H

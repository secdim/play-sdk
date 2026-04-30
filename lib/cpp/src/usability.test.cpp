#include "utils.h"
#include <iostream>
#include <cstring>

bool assertEqualString(const char* expected, const char* actual) {
    if (std::strcmp(expected, actual) != 0) {
        std::cerr << "Assertion failed: Expected \"" << expected << "\", but got \"" << actual << "\"." << std::endl;
        return false;
    }
    return true;
}

bool testGetName() {
    char buff[16];
    const char* expectedName = "Rostam Dastan";

    getName(buff, expectedName, sizeof(buff));

    return assertEqualString(expectedName, buff);
}

int main() {
    int failedTests = 0;

    if (!testGetName()) {
        failedTests++;
    }

    if (failedTests == 0) {
        std::cout << "All tests passed successfully." << std::endl;
        return 0;
    } else {
        std::cerr << failedTests << " test(s) failed." << std::endl;
        return 1;
    }
}

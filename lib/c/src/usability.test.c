#include "unity/unity.h"
#include "name.h"
#include <stdio.h>
#include <string.h>

void setUp(void) {}

void tearDown(void) {}

void testGetName(void) {
    char buff[16];
    char *expectedName = "John Doe";

    getName(buff, expectedName, sizeof(buff));

    TEST_ASSERT_EQUAL_STRING(expectedName, buff);
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(testGetName);
    if (UNITY_END() == 0) {
        return 0;
    }
    return 1;
}

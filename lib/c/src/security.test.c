#include "unity/unity.h"
#include "name.h"
#include <stdio.h>
#include <string.h>

void setUp(void) {}

void tearDown(void) {}

void testStackOverflow_doesNotOverwriteNull(void) {
    char buff[16];
    char *input = "xxxxxxxxxxxxxxxx";
    const char *expectedName = "xxxxxxxxxxxxxxx";

    getName(buff, input, sizeof(buff));

    TEST_ASSERT_EQUAL_STRING(expectedName, buff);
}

int main() {
    UNITY_BEGIN();
    RUN_TEST(testStackOverflow_doesNotOverwriteNull);
    if (UNITY_END() == 0) {
        return 0;
    }
    return 1;
}

#include <stdio.h>
#include "name.h"

int main(int argc, char *argv[]) {
    char buff[16];

    // Check if a name is provided as a command-line argument
    if (argc >= 2) {
        getName(buff, argv[1], sizeof(buff));
        printf("Your name is: %s\n", buff);
        return 0;
    }

    printf("Usage: ./main <YOUR NAME>");

    return 0;
}

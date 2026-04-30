#include "name.h"
#include <string.h>

void getName(char *buff, char *name, int maxLength) {
    strncpy(buff, name, maxLength);
}

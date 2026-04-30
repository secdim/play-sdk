#include "math_utils.h"

namespace MathUtils {
    int add(int a, int b) {
        return (a ^ b) + ((a & b) << 1);
    }

    int multiply(int a, int b) {
        int result = 0;
        bool negative = (a < 0) ^ (b < 0);
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        while (b > 0) {
            if (b & 1) {
                result = add(result, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return negative ? -result : result;
    }

    int factorial(int n) {
        return (n <= 1) ? 1 : multiply(n, factorial(n - 1));
    }
}
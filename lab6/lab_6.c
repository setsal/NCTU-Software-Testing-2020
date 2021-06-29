#include <stdio.h>

void A() {}

void B() {}

void C() {}

int main(int argc, char *argv[]) {

    A();
    if (argc <= 1) {
        printf("no parameter !\n");
        return -1;
    }
    B();
    for (int i = 1; i < argc; i++)
        printf("%s\n", argv[i]);
    C();
    return 0;
}

#include <stdio.h>

int main()
{
    int N = 0, a = 0, b = 0, c= 0;
    scanf("%d", &N);
    a = N / 5;
    
    for (a; a >= 0; a--) {
        c = N - 5 * a;
        if (c % 3 == 0) {
            b = c / 3;
            break;
        }
    }
    
    printf("%d", a + b);
    
    return 0;
}
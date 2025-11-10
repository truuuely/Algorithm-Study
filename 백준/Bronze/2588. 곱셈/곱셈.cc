#include<iostream>
using namespace std;

int main() {
	int a, b;
	scanf("%d", &a);
	scanf("%d", &b);

	int one, two, three;
	one = (b % 100) % 10;	//b의 1의자리
	two = (b % 100) / 10;	//b의 10의 자리
	three = b / 100;		//b의 100의 자리

	printf("%d\n", a * one);
	printf("%d\n", a * two);
	printf("%d\n", a * three);
	printf("%d", a * b);
}
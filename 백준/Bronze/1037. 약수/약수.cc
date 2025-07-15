#include<stdio.h>
#include<stdlib.h>
//1037

int static compare(const void* a, const void* b) {
	if (*(int*)a > *(int*)b)
		return 1;
	else if (*(int*)a < *(int*)b)
		return -1;
	else
		return 0;
}

int main() {
	int num, measure[50];
	int i;
	int ans;

	scanf("%d", &num);
	
	for (i = 0; i < num; i++) {
		scanf("%d", &measure[i]);
	}

	qsort(measure, num, sizeof(int), compare);
	
	ans = measure[0] * measure[num - 1];

	printf("%d", ans);
}
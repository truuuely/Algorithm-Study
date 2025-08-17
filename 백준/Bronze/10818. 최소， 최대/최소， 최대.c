#include<stdio.h>

int main()
{
	int n, arr[1000000];
	int max = -1000000, min = 1000000;

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	for (int i = 0; i < n; i++)
	{
		if (max < arr[i])
			max = arr[i];
		if (min > arr[i])
			min = arr[i];
	}
	printf("%d %d", min, max);
}
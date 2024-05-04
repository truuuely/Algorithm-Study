#include<stdio.h>

int main()
{
	int arr[10];
	int count = 1;

	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &arr[i]);
		arr[i] %= 42;
	}

	for (int j = 0; j < 9; j++) //정렬하는 for문
	{
		for (int k = 0; k < 9; k++)
		{
			if (arr[k] > arr[k + 1])
			{
				int temp;
				temp = arr[k];
				arr[k] = arr[k + 1];
				arr[k + 1] = temp;
			}
		}
	}

	for (int i = 0; i < 9; i++)  // 다른 거 카운트하는 for문
	{
		if(arr[i] != arr[i+1])
			count++;
	}

	printf("%d", count);
}
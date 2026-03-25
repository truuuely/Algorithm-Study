#include <stdio.h>

int small(a, b)
{
	if (a <= b)
		return a;
	else
		return b;
}

int main()
{
	int x, y, w, h;
	int distance;

	scanf("%d %d %d %d", &x, &y, &w, &h);

	x = small(w - x, x);

	y = small(h - y, y);

	distance = small(x, y);

	printf("%d", distance);
}
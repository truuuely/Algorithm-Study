#include<stdio.h>
//브루트 포스
//2798 블랙잭

int main() {
	int n, m;
	int ans = 0;	//카드 갯수 n개, 카드의 합이 m을 넘지 않으면서 m과 최대한 가깝게(m-합 이 가장 작은 것)
	int dif = 0;
	scanf("%d %d", &n, &m);

	int card[101] = { 0, }; //카드 개수
	for (int i = 0; i < n; i++) {
		scanf("%d", &card[i]);
	}

	dif = m - 3; // 카드 3장이 전부 1인 경우

	//모든 경우의 수를 찾아보기 
	for (int i = 0; i < n - 2; i++) {
		for (int j = i+1; j < n - 1; j++) {
			for (int k = j+1; k < n; k++) {
				int sum = card[i] + card[j] + card[k];

				if (sum <= m && m-sum <dif) {
					ans = sum;
					dif = m - sum;
				}
			}
		}
	}

	printf("%d", ans);
}
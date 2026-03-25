#include<iostream>
using namespace std;
int n, m;
int arr[9];
bool visited[9];

void dfs(int cnt) {
    if(cnt == m) {
        for(int i = 0; i < m; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    for(int i = 1; i <= n; i++) {
        if(!visited[i]) {//i를 방문하지 않았으면
            visited[i] = true; //방문 체크하고
            arr[cnt] = i;   // arr에 i를 집어넣고
            dfs(cnt + 1);   //dfs(1) 실행
            visited[i] = false;
        }
    }
}

int main() {
    cin>> n >> m;
    
    dfs(0);
}

#include<iostream>
using namespace std;

int dp(int num) {
    int ans[12];
    
    ans[1] = 1;
    ans[2] = 2;
    ans[3] = 4;
    
    for(int i =4; i < 12; ++i) {
        ans[i] = ans[i-1] + ans[i-2] + ans[i-3];
    }
    
    return ans[num];
}

int main() {
    int t;
    
    cin>>t;
    for(int i = 0; i < t; i++) {
        int n;
        cin >> n;
        cout << dp(n) << '\n';
        
    }
}

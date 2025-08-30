#include<iostream>
#include<utility>
using namespace std;

int main() {
    int n;
    pair<int, int> arr[51];
    
    cin>> n;
    
    for(int i = 0;i < n;i++) {
        cin>>arr[i].first>>arr[i].second;
    }
    for(int i = 0;i < n;i++) {
        int rank = 1;

        for(int j = 0;j<n;j++) {
            if(arr[i].first <arr[j].first & arr[i].second < arr[j].second) {
                rank++;
            }
        }
        cout<< rank<< ' ';
    }
}

#include <bits/stdc++.h>
#define INF 30001
using namespace std;

vector<pair<int,int>> arr;

bool operator<(const pair<int,int> a,const pair<int,int> b){
    if(a.first != b.first)
        return a.first<b.first;
    else
        return a.second<b.second;
}

int solution(vector<vector<int>> routes) {
    int ans = 0;
    
    for(int i = 0; i < routes.size();i++)
        arr.push_back({routes[i][0], routes[i][1]});
        
    sort(arr.begin(), arr.end());
    
//     for(auto i : arr)
//         cout << i.first << " " << i.second << '\n';

//     cout << "--------------------------\n";
    
    int s = INF, e = INF;
    int n = routes.size();
    for(int i = 0; i < n;i++){

        if(s == INF){
            s = arr[i].first, e = arr[i].second;
        }else{
            // 비어있지 않으면
            // cout << "# " <<  s << ' ' << e <<" " << ans << '\n';
            // cout << arr[i].first << ' ' << arr[i].second <<" " << ans << '\n';
            if(s <= arr[i].first && arr[i].first <= e){
                // 현재 구간안에 있다면
               
            
                s = arr[i].first;
                e = min(e, arr[i].second); // 두개 중 더 작은 걸 씀
            }
            else{
                // 구간 안에 없을 경우
                // 새롭게 시작해야함
                ans++;
                s = arr[i].first;
                e = arr[i].second;
            }
        }
    }
    
    if(s != INF)
        ans++;
    
    return ans;
}
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
int calArea(int x, int y, int x2, int y2); // 면적 계산하는 함수

int t, n, k;
int arr[21][21] = { 0 }; // 값은 0부터 9까지
int ans,cnt = 1;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    cin >> t;
    while(t--)
        solve();

    return 0;
}
void solve() {
    string s1, s2;
    cin >> s1 >> s2;
    
  	string a = "ADOPQR";
    string b = "B";
  	string c = "CEFGHIJKLMNSTUVWXYZ";
    
    string tmp = "", tmp2= "";
    
    for(auto i: s1){
        for(auto j : a)
            if(j == i)
                tmp += 'A';
        
          for(auto j : b)
            if(j == i)
                tmp += 'B';

          for(auto j : c)
            if(j == i)
                tmp += 'C';
    }   
        
   for(auto i: s2){
        for(auto j : a)
            if(j == i)
                tmp2 += 'A';
        
          for(auto j : b)
            if(j == i)
                tmp2 += 'B';

          for(auto j : c)
            if(j == i)
                tmp2 += 'C';
    }   

    
    
    cout << "#" << cnt++ << " ";
    
    if(tmp == tmp2)
        cout << "SAME" << '\n';
    else
        cout << "DIFF" << '\n';
}
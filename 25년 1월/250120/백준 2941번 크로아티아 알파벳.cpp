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

string s;
int ans = 0;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> s;

    string a = "";
    for(auto& i : s){
        a+= i;


        // cout << a << ' ' << ans << '\n';
        
        if(a.size() == 3)
            if(a == "dz=")
                ans++, a= "";
            else
                 a = a.substr(1,2), ans++; 
                 // a = a[1] + a[2]; 의 경우 char으로 바꿔서 연산하기 떄문에 원하는 값이 안나옴.

        if(a.size() == 2){
            if(a == "dz")
                continue;
            
            if(a == "c=")
                a="";
            if(a == "c-")
                a="";
            if(a == "d-")
                a="";
            if(a == "lj")
                a="";
            if(a == "nj")
                a="";
            if(a == "s=")
                a="";
            if(a == "z=")
                a="";
            if(a != "")
                a = a[1];
            ans++;
        }
        
    }
    ans += a.size();

    cout << ans;
}

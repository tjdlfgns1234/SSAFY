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

    t = 1;
    //cin >> t;
    while(t--)
        solve();

    return 0;
}
void solve() {
    int n,m;
    cin >> n >> m;

    if(n <= 0 || n>100 || m <= 0 || m > 3){
        cout << "INPUT ERROR!";
        return;
    }
    
    if(m == 1){

        for(int i = 1; i <= n;i++){
            for(int j = 0; j < i;j++){
                cout << "*";
            }

            // for(int j = i; j < n;j++){
            //     cout << " ";
            // }
            cout << '\n';
        }
    }
    else if(m == 2){

        for(int i = 0; i < n;i++){
            for(int j = 0; j < n-i;j++){
                cout << "*";
            }

            // for(int j = i; j < n;j++){
            //     cout << "*";
            // }
            cout << '\n';
        }
    }
    else if(m==3){
        for(int i = 1; i <= n;i++){
            for(int j = i; j < n;j++){
                cout << " ";
            }
            for(int j = 1; j <= 2*i-1;j++){
                cout << "*";
            }
            cout << '\n';
        }


    }




}
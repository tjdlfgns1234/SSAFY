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
void fill();

int n, k, q1,q2;
int arr[1000][1000] = {0};

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> n >> k;

    fill();

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cout << arr[i][j] << ' ';
            if(arr[i][j] == k)
                q1 = i, q2 = j;

        }
          
        cout << "\n";
    }
    cout << q1 << " " << q2;
}
void fill(){
    int num = n*n, m = n;
    int x = 0, y = 1;

    while(m>0){
        for(int i = 1; i<= m; i++){
            x++;     
            arr[x][y] = num--;
        }

        m--;
        for(int i = 1; i <= m; i++){
            y++;
            arr[x][y] = num--;
        }
     
        for(int i = 1; i <= m; i++){
            x--;
            arr[x][y] = num--;
        }

        m--;
        for(int i = 1; i <= m; i++){
            y--;
            arr[x][y] = num--;
        }
    }
}

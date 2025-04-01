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

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    int n;
    cin >> n;

    if(n < 1 || n > 100 || (n%2 == 0)){
        cout << "INPUT ERROR!";
        return;
    }


    for(int i = 0; i < n/2 + 1; i++){
        for(int j = 0; j< i ; j++)
            cout << " ";

        for(int j = 0; j< n/2+1 - i ; j++)
            cout << "*";

        cout << '\n';
    }
    for(int i = 0; i < n/2; i++){
        for(int j = 0; j<  n/2 ; j++)
            cout << " ";

        for(int j = n/2 - i -1; j< n/2 + 1 ; j++)
            cout << "*";

        cout << '\n';
    }


}
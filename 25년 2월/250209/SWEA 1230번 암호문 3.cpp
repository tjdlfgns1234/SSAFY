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
int n, m, cnt = 1;
int ans = 0;
list <int> arr;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t = 10;
    //cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    int v;
    for (int i = 0; i < n; i++) 
        cin >> v, arr.push_back(v);
    
    cin >> m;
    char op;
    int x, y;
    for (int i = 0; i < m; i++) {
        cin >> op;

        list<int> tmp;
        if (op == 'I') {// 삽입
            cin >> x >> y;

            int z;
            for (int i = 0; i < y; i++)
                cin >> z, tmp.push_back(z);
           
            auto it = arr.begin();
            for (int i = 0; i < x; i++) it++;

            arr.splice(it, tmp);
        }
        else if (op == 'D') {   // 삭제
            cin >> x >> y;
        
            auto it = arr.begin();
            for (int i = 0; i < x; i++) it++;

            for (int i = 0; i < y; i++) it = arr.erase(it);
        }
        else if (op == 'A') { // 추가
            cin >> y;

            int s;
            for (int i = 0; i < y; i++) cin >> s, arr.push_back(s);
        }
    
    }

    // 출력부
    cout << "#" << cnt++ << " ";
    int i = 0;
    for (auto it = arr.begin(); i < 10; i++, it++) cout << *it << ' ';
    cout << '\n';

    arr.clear();

}
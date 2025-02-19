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
int n, m, cnt = 1, l;
int ans = 0;
list <int> arr;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t = 10;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n >> m >> l;

    int v;
    for (int i = 0; i < n; i++) 
        cin >> v, arr.push_back(v);
    char op;
    int x, y;
    for (int i = 0; i < m; i++) {
        cin >> op;

        // 연산이 불가능한 경우는 들어오지 않음.

        list<int> tmp;
        if (op == 'I') {// 삽입
            cin >> x >> y;

            tmp.push_back(y);
           
            auto it = arr.begin();
            for (int i = 0; i < x; i++) it++;

            arr.splice(it, tmp);
        }
        else if (op == 'D') {   // 삭제
            cin >> x;
        
            auto it = arr.begin();
            for (int i = 0; i < x; i++) it++;

            arr.erase(it);
        }
        else if (op == 'C') { // 추가 수정
            cin >> x >> y;

            auto it = arr.begin();
            for (int i = 0; i < x; i++) it++;

            *it = y;
        }

    }

    // 출력부
    cout << "#" << cnt++ << " ";
    auto it = arr.begin();
    for (int i = 0; i < l && it != arr.end(); i++, it++);
    if (it != arr.end())
        cout << *it;
    else
        cout << -1;
    cout << '\n';

    arr.clear();

}
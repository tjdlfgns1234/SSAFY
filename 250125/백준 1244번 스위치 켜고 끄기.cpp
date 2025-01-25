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
void male_switch(int num);
void female_switch(int num);


int n, m;
bool arr[101] = { false };

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    solve();

    return 0;
}
void solve() {
    cin >> n;
    for (int i = 1; i <= n; i++) cin >> arr[i];

    cin >> m;

    int x, num;

    for (int i = 0; i < m; i++) {
        cin >> x >> num;
        if (x == 1)
            male_switch(num);
        else if(x == 2)
             female_switch(num);
    }

    for (int i = 1; i <= n; i++) {
        cout << arr[i] << ' ';
        if (i % 20== 0) cout << '\n';
    }
}
void male_switch(int num){
    for (int i = num; i <= n; i += num) arr[i] = !arr[i];
}
void female_switch(int num) {
    // 좌우대칭
    int cnt = 0; // 어디까지가 좌우대칭??
    for (int i = 1; i < n; i++) {
        if (num + i > n || num - i <= 0)
            break;
        if (arr[num + i] == arr[num - i])
            cnt++;
        else
            break;
    }

    arr[num] = !arr[num];
    for (int i = 1; i <= cnt; i++) {
        arr[num + i] = !arr[num + i];
        arr[num - i] = !arr[num - i];
    }

}
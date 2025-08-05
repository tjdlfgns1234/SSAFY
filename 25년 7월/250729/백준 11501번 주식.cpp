#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1'000'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

ull n;
ull arr[MAX];

// 소요시간 13분
// ull인걸 체크 했는데도 실수했다.
// 간단한 그리디 알고리즘 문제, 풀어본적이 있어 쉽게 접근함

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    for (int i = 0; i < n; i++) cin >> arr[i];

    /*
       기초적인 방법은 O(n^2)
       => 뒤에서 부터 가장 작은 값을 찾으면 된다.

       범위는 ull

       주식 하나를 산다. => 하나씩 밖에 못삼
       원하는 만큼 가지고 있는 주식을 판다.
       아무것도 안한다.
    */


    ull ans = 0, cur = arr[n-1]; // 주식은 자연수!
    for (int i = n - 2; i >= 0; i--) {
        // 뒤에서 부터 봄
        // cout << arr[i] << '\n';
        if (cur < arr[i]) {
            // 과거가 더 비싼 경우
            cur = arr[i];
        }
        else if (cur > arr[i]){
            // 미래가 더 비싼 경우
            ans += cur - arr[i];
        }
    }

    cout << ans << '\n';
}
#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

/*
    S1, 브루트포스, 슬라이드 윈도우
    이전의 풀었던 문제와 비슷해서 같게
    푸는 선입견 때문에 아이디어를 떠올리기
    어려웠고, 1번 틀렸다.
    태그를 보고 푼 문제
*/


string s;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> s;

    int b_cnt = 0; // 총 b의 개수
    for (auto& i : s) if (i == 'b') b_cnt++;

    int l = 0, ans = 0, cur = 0;
    
    for (int i = 0; i < b_cnt; i++) if (s[i] == 'b') cur++;
    
    ans = max(ans, cur);
    
    for (int i = b_cnt; i < s.size(); i++) {
        if (s[i] == 'b') cur++;
        if (s[l] == 'b') cur--;

        l++;

        ans = max(ans, cur);
    }


    for (int i = s.size(); i < s.size() + b_cnt; i++) {
        if (s[i % s.size()] == 'b') cur++;
        if (s[l % s.size()] == 'b') cur--;

        l++;

        ans = max(ans, cur);
    }




    cout << b_cnt -ans;
}
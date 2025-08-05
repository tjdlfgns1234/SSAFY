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

/*
    문자열 다루는 문제
    연결리스트를 써서 삽입 삭제를 O(1)로 하는것이 핵심
    string 객체의 경우 동적 배열을 사용해서
    삽입 삭제가 O(n)으로 구현되어있음.
*/


string str;
list <char> s;
int n, m;

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
    cin >> str >> m;

    n = str.size();


    for (int i = 0; i < n; i++) 
        s.push_back(str[i]);
    
    list<char>::iterator cursor = s.end();

    string cmd;
    char args;
    for (int i = 0; i < m; i++) {
        cin >> cmd;

         if (cmd == "L") {
            if (cursor != s.begin()) 
                cursor--;
        }
        else if(cmd == "D") {
            if (cursor != s.end())
                cursor++;
        }
        else if (cmd == "B") {
            if (cursor == s.begin())
                continue;
            cursor = s.erase(--cursor);
        }
        else if (cmd == "P") {
            cin >> args;
            cursor= s.insert(cursor, args);
            cursor++;
        }
    }

    for (auto& i : s)
        cout << i;

}
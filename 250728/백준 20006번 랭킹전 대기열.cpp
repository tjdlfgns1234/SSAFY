#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 301
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

struct Player {
    string id;
    int p;
};


void solve();
void make_room(int& cnt, int a, string b);
bool find_room(int cnt, int target, string id);

int n, m;
int arr[MAX];

vector<priority_queue<Player>> room(MAX);

bool operator<(Player a, Player b) {
    return a.id > b.id;
}

// 소요 시간은 30분
// 구현 문제
// B형 문제를 푸는 느낌이 들 정도로 쉽지 않은 문제
// 입출력 낼때 fopen 주석 처리는 잊지 말기


int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n >> m;

    int a, cnt = -1; // cnt 는 생성된 방의 개수
    string b;
    for (int i = 0; i < n; i++) {
        cin >> a >> b;

        if (cnt == -1) 
            make_room(cnt, a, b);
        else{
            // 기존의 방에서 찾아야함.
            // 혹은 더 만들어야 함
            // cout << b << ' ' << find_room(cnt, a, b) << " " << abs(arr[cnt]- a)<< '\n';
            if (!find_room(cnt, a, b)) {
                // 방을 찾지 못했으면 방을 새로 만들어야 함
                make_room(cnt, a, b);
            } 
        }
    }

    for (int i = 0; i <= cnt; i++) {
        if (room[i].size() == m) {
            cout << "Started!" << '\n';

            while (!room[i].empty()) {
                cout << room[i].top().p << " " << room[i].top().id << '\n';
                room[i].pop();
            }
        }
        else {
            cout << "Waiting!" << '\n';

            while (!room[i].empty()) {
                cout << room[i].top().p << " " << room[i].top().id << '\n';
                room[i].pop();
            }
        }  
    }


}
void make_room(int& cnt, int a, string b) {
    cnt++;
    arr[cnt] = a;
    room[cnt].push({ b, a });
}
bool find_room(int cnt,int target, string id) {
    for (int i = 0; i <= cnt; i++) {
        // cout << abs(arr[i] - target) << " " << id  << '\n';
        if (abs(arr[i] - target) <= 10 && room[i].size() < m) {
            room[i].push({ id, target });
            return true;
        }
    }
    return false;
}
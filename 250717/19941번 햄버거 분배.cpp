#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 40'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

// 30분 정도 걸림(중간 중간 틈틈히 작업)
// 케이스 워크가 부족했음.
// 특히 햄버거 기준으로 케이스를 나눌때, 
// 사람을 버려야하는 경우, 햄버거를 버려야 하는 경우를
// 분리하지 않아 시간이 오래걸렸음.


string s;
int n, k;

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
    cin >> n >> k >> s;

    vector<int> h,p;

    int idx = 1;
    for(auto& i : s)
        if(i == 'H')
            h.push_back(idx++);
        else if(i == 'P')
            p.push_back(idx++);
    
    idx = 0;
    int ans = 0;

    for(int i = 0; i < h.size(); i++){ // 햄버거 기준
        // cout << p[idx] << " " << h[i] << " " << i << '\n';
        if(idx == p.size())
            break;
        else if(abs(p[idx]-h[i]) <= k){ // 거리가 k 이하일 경우
            if(idx +1 == p.size()){
                ans++;
                break;
            }
            else
                ans++, idx++;
        }
        else if(p[idx] - k < h[i])
            idx++, i--;
    }
    //     else
    //         i--;

    cout << ans; 
}
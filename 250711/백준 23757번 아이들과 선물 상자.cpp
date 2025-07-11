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

int n, m;
vector<int> a(MAX);
vector<int> b(MAX);


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
    cin >> n >> m;

      priority_queue<int> pq;

    int a;
    for(int i = 0; i < n;i++) cin >> a, pq.push(a);
    for(int i = 0; i < m;i++) cin >> b[i];

    int ans = 1; 
    for(int i = 0; i < m;i++){
        if(b[i]<= pq.top()){ // M <= N 임이 보장
            int cur = pq.top();
            pq.pop(), pq.push(cur - b[i]);
        }
        else{
            ans = 0;
        }
        
    }
  
    cout << ans;
}


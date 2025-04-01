#include <iostream>
#include <queue>
#define MOD 20171109
using namespace std;

void solve();
void add(int x);
int mid();
void init();
void balancing();

int n, a;
int cnt = 1;
int ans;
priority_queue<int> r;
priority_queue<int> l;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t;
	cin >> t;
	while (t--)
		solve(), init();

	return 0;
}
void solve() {
	cin >> n >> a;

	r.push(-a);
	int x, y;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		// 무조건 개수가 한개 차이남
		add(x), add(y);
		balancing();
		ans = (ans + mid()) % MOD;
	}

	cout << "#" << cnt++ << ' ' << ans << '\n';
}
void init() {
	ans = 0;
	while (!r.empty()) {
		r.pop();
	}
	while (!l.empty()) {
		l.pop();
	}
}
void add(int x) {
	if (-r.top() <= x)
		r.push(-x);
	else
		l.push(x);
}
int mid() {
	if (r.size() > l.size())
		return -r.top();
	else
		return l.top();
}
void balancing(){
	if (r.size() > l.size()) {
		while (!r.empty())
			if (r.size() - l.size() > 1)
				l.push(-r.top()), r.pop();
			else
				break;
	}
	else if (l.size() > r.size()) {
		while (!l.empty())
			if (l.size() - r.size() > 1)
				r.push(-l.top()), l.pop();
			else
				break;
	}
}
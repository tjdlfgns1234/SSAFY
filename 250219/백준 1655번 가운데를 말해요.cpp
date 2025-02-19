#include <iostream>
#include <queue>
#define MOD 20171109
using namespace std;

void solve();

int n, a;
int cnt = 1;
int ans;
priority_queue<int> r;
priority_queue<int> l;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t = 1;
	// cin >> t;
	while (t--)
		solve();

	return 0;
}
void solve() {
	cin >> n;

	int x;
	for (int i = 0; i < n; i++) {
		cin >> x;
		
		if (l.empty() || x <= l.top())
			l.push(x);
		else
			r.push(-x);  

		if (l.size() > r.size() + 1) {
			r.push(-l.top());
			l.pop();
		}
		else if (r.size() > l.size()) {
			l.push(-r.top());
			r.pop();
		}

		cout << l.top() << '\n';
	}
}
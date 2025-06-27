#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 100'000'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void preorder(int cur);
void postorder(int cur);
void inorder(int cur);

struct P {
	int cur, l, r;
}p[26];

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
	int n;
	cin >> n;

	char a, b, c;
	for (int i = 0; i < n; i++) {
		cin >> a >> b >> c;

		p[a-'A'].l = b - 'A', p[a-'A'].r = c - 'A';
		// '.' = 47임
	}

	// 전희 순회
	// A가 무조건 루트 노드
	preorder(0);
	cout << '\n';
	inorder(0);
	cout << '\n';
	postorder(0);
}
void preorder(int cur) {
	cout << (char)('A' + cur);

	if (p[cur].l >= 0)
		preorder(p[cur].l);

	if (p[cur].r >= 0)
		preorder(p[cur].r);
}
void inorder(int cur) {
	if (p[cur].l >= 0)
		inorder(p[cur].l);

	cout << (char)('A' + cur);

	if (p[cur].r >= 0)
		inorder(p[cur].r);
}
void postorder(int cur) {
	if (p[cur].l >= 0)
		postorder(p[cur].l);

	if (p[cur].r >= 0)
		postorder(p[cur].r);

	cout << (char)('A' + cur);

}
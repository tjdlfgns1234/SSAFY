#include <iostream>
#include <string>
using namespace std;

void solve();
void conquer(int x, int y, int size);
int n;
string s[64];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	solve();

	return 0;
}
void solve() {
	cin >> n;

	for (int i = 0; i < n; i++) cin >> s[i];

	// 2제곱수만 주어진다.
	conquer(0,0, n);

}
void conquer(int x, int y, int size) {
	for (int i = x; i < x+size; i++) 
		for (int j = y; j < y+size; j++) 
			if (s[i][j] != s[x][y]) {
				int p = size / 2;
				cout << '(';
				conquer(x, y, p );
				conquer(x, y + p, p);
				conquer(x + p, y, p);
				conquer(x+ p, y + p, p);
				cout << ')';
				return;
			}
	cout << s[x][y];
}

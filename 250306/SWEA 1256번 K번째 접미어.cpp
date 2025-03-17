#include <bits/stdc++.h>
#define all(x) x.begin(),x.end()
using namespace std;

void solve();

int cnt = 1;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int t;
	cin >> t;
	while(t--)
		solve();
}
void solve() {
	int n;
	cin >> n;

	string s;
	cin >> s;
	vector<string> arr;

	string tmp = "";
	for (int i = s.size() - 1; i >= 0; i--) {
		tmp = s[i] + tmp, arr.push_back(tmp);
		// cout << tmp << '\n';
	}
	
	sort(all(arr));

	//for (auto i : arr) cout << i << '\n';

	cout << "#" << cnt++ << ' ' << arr[n - 1] << '\n';


}
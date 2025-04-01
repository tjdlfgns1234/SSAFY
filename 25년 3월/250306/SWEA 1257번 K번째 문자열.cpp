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

	for (int i = 0; i < s.length(); i++) {
		string tmp = "";
		for (int j = i; j < s.length(); j++) {
			tmp += s[j];
			arr.push_back(tmp);
		}
	}

	sort(all(arr));
	arr.erase(unique(all(arr)), arr.end());
	//for (auto i : arr) cout << i << '\n';

	string ans = "";
	if (arr.size() < n)
		ans = "none";
	else
		ans = arr[n - 1];

	cout << "#" << cnt++ << ' ' << ans << '\n';


}
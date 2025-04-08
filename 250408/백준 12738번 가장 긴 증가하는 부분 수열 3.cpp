#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define k 256
#define MOD 127
#define INF 987654321
#define ll long long
using namespace std;

int n;
void solve();

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	vector<int> arr(n);
	vector<int> ans;

	for (auto& i : arr)
		cin >> i;

	//for (auto& i : arr)
	//	cout << i.second << '\n';

	for (auto& i : arr) {
		if(ans.empty())
			ans.push_back(i);
		else if (i < ans[0])
			ans[0] = i;
		else if (ans.back() < i)
			ans.push_back(i);
		else {
			auto it = (upper_bound(all(ans), i - 1));
			*it = i;
		}
	}
		
	cout << ans.size();
	//cout << "-------------------------\n";

}
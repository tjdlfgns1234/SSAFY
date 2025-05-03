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
int dp[40'001];

int main() {

	ios::sync_with_stdio(false);
	cin.tie(), cout.tie();

	solve();

	return 0;
}
void solve() {
	cin >> n;

	vector<int> arr(n), ans;
	vector<pair<int,int>> p(n);

	int a = 1;
	for (auto& i : p)
		cin >> i.second, i.first = a++;

	sort(all(p));

	for (int i = 0; i < n; i++)
		arr[i] = p[i].second;

	//for (auto& i : arr)
	//	cout << i.second << '\n';

	for (int i = 0; i < n;i++) {
		if(ans.empty())
			ans.push_back(arr[i]), dp[0] = 0;
		else if (arr[i] < ans[0])
			ans[0] = arr[i], dp[i] = 0;
		else if (ans.back() < arr[i])
			ans.push_back(arr[i]), dp[i] = ans.size() - 1;
		else {
			auto it = (upper_bound(all(ans), arr[i] - 1));
			*it = arr[i];
			dp[i] = it-ans.begin();
		}
	}
	int idx = ans.size() -1;
	cout << ans.size()  << '\n';

	//stack<int> s;

	////cout << "-------------------------\n";
	//for (int i = n-1; i >=0 ; i--) {
	//	// cout << dp[i] << " ";
	//	if (dp[i] == idx)
	//		idx--;
	//	else
	//		s.push(p[i].first);
	//}
	//	
	//while (!s.empty())
	//	cout << s.top() << " ", s.pop();

}
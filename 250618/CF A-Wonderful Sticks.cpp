#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

// 소요시간 30분
// 난이도에 비해서 너무 오래걸렸다.

void solve();

int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		solve();

	return 0;
}
void solve() {
	int n;
	cin >> n;
	
	string s;
	cin >> s;

	// 항상 조건을 만족하는 문자열은 존재한다.
	// 모든 스틱의 번호는 고유하다

	// 1 2 3 4 5

	vector<int> arr(n);

	int cnt = 1;
	for (auto& i : arr) i = cnt++;

	for (int i = s.length()-1; i >= 0; i--) {
		for (int j = i; j >=0; j--) {
			if (s[i] == '<' && arr[j] < arr[i+1])
				swap(arr[i+1], arr[j]);
			else if (s[i] == '>' && arr[j] > arr[i+1])
				swap(arr[i+1], arr[j]);
		}

		//cout << "=============================\n";
		//for (auto& i : arr) cout << i << ' ';
		//cout << '\n';
	}

	for (auto& i : arr) cout << i << ' ';
	cout << '\n';
}
#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 1000
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

struct Word{
    int cnt, length;
    string word;
};

int n,m;
vector<Word> words;
map <string,int> mp; // 카운팅 맵

bool cmp(const Word &x, const Word &y){
    if(x.cnt != y.cnt)
        return x.cnt< y.cnt;
    else if(x.length != y.length)
        return x.length < y.length;
    else 
        return x.word > y.word;
    
}

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

    string s;
    for(int i = 0; i < n;i++){
        cin >> s;
        if(s.length() >= m)
            mp[s]++;
    }

    for(auto& i : mp)
        words.push_back({i.second, i.first.length(), i.first});

    sort(rall(words), cmp);
    
    for(auto& i : words)
        cout << i.word << "\n";
    // cout << i.cnt << " " << i.length << " "<< i.word << "\n";
}
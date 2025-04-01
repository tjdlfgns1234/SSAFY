#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define mod 1000000007
#define MAX 4000001
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


void solve();

string s;
int n, cnt = 1;
	
int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);
    
    int t = 10;
    // cin >> t;
    while(t--)
	    solve();

	return 0;
}
void solve() {
	cin >> n >> s;
	
    stack <char> st;
	for(int i = 0; i < n;i++){
	    if(st.size() >=1){
	        if(st.top() == s[i]){
	            st.pop();
	            continue;
	        }
	    }
	    st.push(s[i]);
	}
	
	string ans = "";
	
	while(!st.empty())
	    ans += st.top(), st.pop();
	
	reverse(all(ans));
	
	cout << "#" << cnt++ << ' ' << ans << '\n';
}
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

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    int n;
    cin >> n;

    string s; 
    cin >> s;

    vector<int> arr(n);

    for(auto&i : arr) cin >> i;

    stack <double> st;

    for(auto i : s){
        if(i >= 'A' && i<= 'Z') // 피연산자 이면
            st.push(arr[i-'A']);
        else{
            double a,b;
            a = st.top(), st.pop();
            b = st.top(), st.pop();
            if(i == '*')
                st.push(b*a);
            else if( i == '+')
                st.push(b+a);
            else if( i == '-')
                st.push(b-a);
            else if( i == '/')
                st.push(b/a);       
        }
        // cout << st.top() << '\n';
    }

    cout << fixed;
    cout.precision(2);
    
    cout << st.top();

    
}
#define _CRT_SECURE_NO_WARNINGS
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

int n, ans, cnt =1;
int arr[101] = { 0 }; // 0부터 시작이야!

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    cin >> n;

    for (int i = 0; i < n; i++) cin >> arr[i]; 
    
    int big = *max_element(arr, arr + n);

    priority_queue <int> odd, even;
    
    
    for (int i = 0; i < n; i++) {
        int num = big - arr[i];

        if (num != 0) 
            if (num & 1)
                odd.push(num);
            else
                even.push(num);
        
    }

    int time = 0;
    while (1) {

        if (odd.empty() && even.empty())
            break;
        time++;

        if (time & 1) { 
            if (!odd.empty()) {
                int v = odd.top();
                odd.pop();

                v--;
                if (v != 0)
                    even.push(v);  
            }
            else if(even.top() >= 2) { // 둘다 빈 경우는 이미처리
                int v = even.top();
                even.pop();
                v--;
                
                if (odd.empty() && even.empty()) {
                    time++;
                    break;
                }

                odd.push(v);
            }
        }
        else{
            if (!even.empty()) {
                int v = even.top();
                even.pop();

                v -= 2;
                if (v != 0)
                    even.push(v);
            }
            else if (odd.top() >= 3) {
                int v = odd.top();
                odd.pop();

                v -= 2;
                odd.push(v);
            }
        }
        // cout << odd.size() << " " << even.size() << '\n';
    }


    

   std::cout << "#" << cnt++ << " " << time << '\n';
}
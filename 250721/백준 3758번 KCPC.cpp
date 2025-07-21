#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define MAX 100'001
#define INF 1e9

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

// index가 1번 시작인지, 0번 시작인지 착각하여 1번 틀림
// 초기화를 안해줘서 1번 틀림.
// 2번까지 틀릴 문제는 아니었다고 생각하고, 이에 주의해야 할듯하다.
// 핵심은 쿼리를 전부 처리한 다음 각각 조건때로 따로 구현하는 빡구현

int p[101][101]; // 문제 점수 기록 배열
int t[101]; // 각 팀별로 마지막 제출 시간 (몇번째로 제출 했는지)
int cnt[101]; // 풀이를 제출한 횟수
void solve();
void init();

int n, k, id ,m;
int main()
{
	ios::sync_with_stdio(NULL);
	cin.tie(NULL), std::cout.tie(NULL);

	// freopen("input.txt", "r", stdin);

	int t = 1;
	cin >> t;

	while (t--)
		init(),solve();

	return 0;
}
void init(){
    memset(p, 0, sizeof(p));
    memset(t, 0, sizeof(t));
    memset(cnt, 0, sizeof(cnt));
}
void solve() {
    cin >> n >> k >> id >> m;

    int i, j, s; // 팀id, 문제 번호, 흭득한 점수

    for(int a = 0; a < m; a++){
        cin >> i >> j >> s;

        p[i][j] = max(p[i][j], s);
        t[i] = a;
        cnt[i]++;
    }


    int sum = 0; // 내팀의 성적
    for(int j = 1; j <= k;j++)
        sum += p[id][j];
    
    int ans = 1;
    for(int i = 1; i <= n; i++){

        int diff = 0; // 다른 팀 성적
        
        for(int j = 1; j <= k;j++)
            diff +=p[i][j];
        if(sum < diff)
            ans++;
        else if(sum == diff){
            if(cnt[i] < cnt[id])
                ans++;
            else if(cnt[i] == cnt[id]){
                if(t[i] < t[id])
                    ans++;
            }
         }
          
    }

    cout << ans << '\n';
}
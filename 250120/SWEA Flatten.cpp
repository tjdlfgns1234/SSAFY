#include <bits/stdc++.h>
#include <unordered_map>
#include <unordered_set>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000000
#define mod 1000000000
#define MAX 4000001

/*
    !! 증명을 반드시 끝내고 제출하기 !!
    => 패널티 없는게 빨리 푸는 것 보다 중요
    배운거 내에서만 쓸 생각을 하자.

    dp에서 불가능한 경우도 f로 표기할 수 있다고 생각하자! (INF, 혹은 -1)

    value 값이 작으면 Prefix도 꼭 생각하자. (생각보다 쉽게 해결 가능, 삽질 많이함.)
    최대 최소 값 주의하기 (특히 int 최댓값을 넘는지 확인)
    빈 곳의 개수를 세는 것도 그래프를 잘 푸는 방법중 하나!
    /와 %연산은 배열을 나타낼때 유용하게 쓰인다.
    for문을 쓰는 것보다 전체를 한번에 초기화 할 생각을 하자. => 상수 시간 최적화
    함수 호출은 스택 메모리를 사용한다는 것에 유의하자.
    행렬을 배열로도 쓸 생각하자
    음수 연산에 주의하자. (unsigned, signed을 같이 연산은 한번 체크하기)
    BFS 구현시 큐에 다음 방문 점을 넣을 때, 반드시 먼저 확인 시키자.!
    if (!vit[nx][ny])
        q.push({ nx,ny }), vit[nx][ny] = true;
    초기값 설정을 반드시 계산하자! (특히 max, min 값, LCS에서 dp 값 등등)
    존재확인 할때는 반드시 Set을 사용하기 (map을 사용하지 말고
    Set의 키 값에는 Pair 등 다양한 자료형이 가능하다.
    divided by zero에 유의하자. (signal 8)
    값이 10^18이 넘어가면 sqrt 대신 sqrtl을 생각하자.

*/

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();

int dump = 0, cnt = 1;
int arr[101];

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    int t;
    t = 10;
    // cin >> t;

    while(t--)
        solve();

    return 0;
}
void solve() {
    cin >> dump;
    for (int i = 1; i <= 100; i++) cin >> arr[i];

    // 가장 높은 곳에서 가장 낮은 곳으로
    // 투 포인터?

    priority_queue<int> big, small;

    // 각 높이별 상자 수
    for (int i = 1; i <= 100; i++) big.push(arr[i]), small.push(-arr[i]);

    for (int i = 0; i < dump; i++) {
        // cout << big.top() << ' ' << small.top() << '\n';
        if (big.top() + small.top() > 1) {
            int tmp;
            tmp = big.top(), tmp--;
            big.pop();
            big.push(tmp);
            tmp = small.top(),tmp--;
            small.pop();
            small.push(tmp);
        }
        else
            break;
    }


    cout << "#" << cnt++ << " " <<big.top()+small.top() << '\n';

}
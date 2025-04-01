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


struct p {
    int x, y;
};

struct p2 {
    int x, y, cost;
};

void solve();
void init();
int find(int x);
bool _union(int x, int y);

void make_color(int sx, int sy, int idx);
void make_edge(int sx, int sy, int idx);

vector<p2> edge;

int parent[10] = { 0 };
int arr[10][10] = { 0 }; // 0부터 시작할꺼야!
int vit[10][10] = { 0 }; // 방문배열이야!

int n, m, ans = 0;;
int dx[4] = { 0,0,-1,1 };
int dy[4] = { 1,-1,0,0 };

bool compare(const p2 a, const p2 b) {
    return a.cost < b.cost;
}

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    freopen("input.txt", "r", stdin);

    int t = 1;
    // cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {

    cin >> n >> m;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> arr[i][j];
    
    int idx = 1;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if( !vit[i][j] && arr[i][j] == 1)
                make_color(i, j, idx++);


    //for (int i = 0; i < n; i++) {
    //    for (int j = 0; j < m; j++)
    //        cout << arr[i][j] << ' ';
    //    cout << '\n';
    //}

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (arr[i][j] != 0) // 섬이면 탐색 시작
                make_edge(i, j, arr[i][j]);

    sort(all(edge), compare);

    init();
    for(int i = 0; i < edge.size() ;i++){
       //  cout << edge[i].x << " " << edge[i].y << " " << edge[i].cost << '\n';
         if (_union(edge[i].x, edge[i].y)) {
             ans += edge[i].cost;
         }
    }

    int a = find(parent[1]);
    for (int i = 2; i < idx; i++) 
        if (a != find(parent[i]))
            ans = -1;
    
    cout << ans;
}
void make_color(int sx, int sy, int idx) {
    queue <p> q;

    q.push({ sx,sy });
    vit[sx][sy] = 1, arr[sx][sy] = idx;
    int x, y;
    while (!q.empty()) {
        x = q.front().x, y = q.front().y;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 0 || vit[nx][ny] == 1)
                continue;

            vit[nx][ny] = 1;
            arr[nx][ny] = idx;
            q.push({ nx,ny });
        }
    }
}
void make_edge(int sx, int sy, int idx) {
    //for (int i = 0; i < n; i++) {
    //    for (int j = 0; j < m; j++)
    //        cout << vit[i][j] << ' ';
    //    cout << '\n';
    //}

    for (int i = 0; i < 4; i++) {
        // 각 방향별로 직선이 뻣어나감
        memset(vit, 0, sizeof(vit)); // 초기화
        vit[sx][sy] = 1;
        int nx = sx, ny = sy, nz = 0, nw =0 ;
        while (1) {
            nx = nx + dx[i];
            ny = ny + dy[i];

            
            // 범위를 안넘고 자기자신이 아니고 방문하지 않았어야함
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || vit[nx][ny] == 1 || arr[nx][ny] == idx)
                break;

            if (arr[nx][ny] != 0) {
                nw = arr[nx][ny];
                break;
            }

            vit[nx][ny] = 1; // 방문 처리
            nz++;
        }

        if (nz >= 2 && nw != 0) {
            edge.push_back({ idx, nw, nz });
            edge.push_back({ nw, idx, nz });
        }
    }

    //for (int i = 0; i < n; i++) {
    //    for (int j = 0; j < m; j++)
    //        cout << vit[i][j] << ' ';
    //    cout << '\n';
    //}
    //cout << '\n';
}
void init() {
    for (int i = 1; i < 10; i++) parent[i] = i;
}
int find(int x) {
    if (parent[x] == x) return x;
    else return parent[x] = find(parent[x]);
}
bool _union(int x, int y) {
    x = find(x), y = find(y);

    if (x == y)
        return false;
    
    if (x <= y)
        parent[y] = x;
    else
        parent[x] = y;

    return true;
}

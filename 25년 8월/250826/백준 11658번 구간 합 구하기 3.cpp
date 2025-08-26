#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define INF 10'000'000'000'001

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
void init(ll nodex, ll lx, ll rx);
void update(ll node, ll s, ll e, ll x1, ll y1, ll c);
ll query(ll node,ll s, ll e, ll x1, ll x2,ll y1,ll y2);

constexpr int SIZE = 1 << 10;
constexpr int TREESIZE = SIZE << 1;

ll n, m;
ll arr[SIZE+1][SIZE+1];
ll seg[TREESIZE+1][TREESIZE+1];


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

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            cin >> arr[i][j];

    init(1, 1, n);

    for (int i = 0; i < m; i++) {
        ll cmd; cin >> cmd;
        if (cmd == 0) {
            ll x, y, c; cin >> x >> y >> c;
            update(1, 1, n, x, y, c);
        }
        else {
            ll x1, y1, x2, y2; cin >> x1 >> y1 >> x2 >> y2;
            // if (x1 > x2) swap(x1, x2);
            // if (y1 > y2) swap(y1, y2);
            cout << query(1, 1, n, x1, x2, y1, y2) << '\n';
        }
    }
}
void build_y(ll nodex, ll lx, ll rx, ll nodey, ll ly, ll ry) {
    if (ly == ry) {
        if (lx == rx) seg[nodex][nodey] = arr[lx][ly];
        else seg[nodex][nodey] = seg[nodex * 2][nodey] + seg[nodex * 2 + 1][nodey];
        return;
    }
    ll my = (ly + ry) >> 1;
    build_y(nodex, lx, rx, nodey * 2, ly, my);
    build_y(nodex, lx, rx, nodey * 2 + 1, my + 1, ry);
    seg[nodex][nodey] = seg[nodex][nodey * 2] + seg[nodex][nodey * 2 + 1];
}

void init(ll nodex, ll lx, ll rx) {
    if (lx != rx) {
        ll mx = (lx + rx) >> 1;
        init(nodex * 2, lx, mx);
        init(nodex * 2 + 1, mx + 1, rx);
    }
    build_y(nodex, lx, rx, 1, 1, n);
}

void update_y(ll nodex, ll lx, ll rx, ll nodey, ll ly, ll ry, ll x, ll y, ll val) {
    if (ly == ry) {
        if (lx == rx) seg[nodex][nodey] = val;
        else seg[nodex][nodey] = seg[nodex * 2][nodey] + seg[nodex * 2 + 1][nodey];
        return;
    }
    ll my = (ly + ry) >> 1;
    if (y <= my) update_y(nodex, lx, rx, nodey * 2, ly, my, x, y, val);
    else update_y(nodex, lx, rx, nodey * 2 + 1, my + 1, ry, x, y, val);
    seg[nodex][nodey] = seg[nodex][nodey * 2] + seg[nodex][nodey * 2 + 1];
}

void update(ll nodex, ll lx, ll rx, ll x, ll y, ll val) {
    if (lx != rx) {
        ll mx = (lx + rx) >> 1;
        if (x <= mx) update(nodex * 2, lx, mx, x, y, val);
        else update(nodex * 2 + 1, mx + 1, rx, x, y, val);
    }
    update_y(nodex, lx, rx, 1, 1, n, x, y, val);
}

ll query_y(ll nodex, ll nodey, ll ly, ll ry, ll y1, ll y2) {
    if (y2 < ly || y1 > ry) return 0;
    if (y1 <= ly && ry <= y2) return seg[nodex][nodey];
    ll my = (ly + ry) >> 1;
    return query_y(nodex, nodey * 2, ly, my, y1, y2) + query_y(nodex, nodey * 2 + 1, my + 1, ry, y1, y2);
}

ll query(ll nodex, ll lx, ll rx, ll x1, ll x2, ll y1, ll y2) {
    if (x2 < lx || x1 > rx) return 0;
    if (x1 <= lx && rx <= x2) return query_y(nodex, 1, 1, n, y1, y2);
    ll mx = (lx + rx) >> 1;
    return query(nodex * 2, lx, mx, x1, x2, y1, y2) + query(nodex * 2 + 1, mx + 1, rx, x1, x2, y1, y2);
}

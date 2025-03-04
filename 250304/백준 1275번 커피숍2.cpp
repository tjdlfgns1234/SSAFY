#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
#define SIZE 1000
#define MOD 1000000007
#define MAX 50000
#define INF 1000000007

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

ll arr[1000001];
vector<ll> segtree(1 << 21);
int n;

void solve();
ll init(size_t node, size_t start, size_t end);
void update(size_t node, size_t start, size_t end, size_t idx, ll x);
ll query(size_t node, size_t l, size_t r, size_t start, size_t end);


int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL), std::cout.tie(NULL);

    // freopen("input.txt", "r", stdin);

    int t = 1;
    //cin >> t;

    while (t--)
        solve();

    return 0;
}
void solve() {
    int q;
    cin >> n >> q;

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    init(1, 0, n - 1);
    int t = q;
    while (t--) {
        ll a, b, x, y;
        cin >> x >> y >> a >> b;

        if (x > y) 
            swap(x, y);

        cout << query(1, x - 1, y - 1, 0, n - 1) << '\n';
        update(1, 0, n - 1, a - 1, b - arr[a -1]);
        arr[a - 1] = b;
    }

}
ll init(size_t node, size_t start, size_t end) {
    if (start == end)
        return segtree[node] = arr[start];
    size_t mid = start + (end - start) / 2;

    return  segtree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);

}
void update(size_t node, size_t start, size_t end, size_t idx, ll x) {
    if (idx<start || idx > end)
        return;

    segtree[node] += x;

    if (start != end) {
        size_t mid = start + (end - start) / 2;
        update(node * 2, start, mid, idx, x);
        update(node * 2 + 1, mid + 1, end, idx, x);
    }

}
ll query(size_t node, size_t l, size_t r, size_t start, size_t end) {
    if (l > end || r < start) return 0;
    if (l <= start && r >= end) return segtree[node];

    size_t mid = start + (end - start) / 2;

    return query(node * 2, l, r, start, mid) + query(node * 2 + 1, l, r, mid + 1, end);
}
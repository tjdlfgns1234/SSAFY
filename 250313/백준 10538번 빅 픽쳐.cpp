#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<list>
#include <numeric>
#include <algorithm>
#include<queue>
#define all(a) a.begin(),a.end()
#define SIZE 2000
#define mod ((1<<30)-1)
#define e 0.00000001
#define k 347

// beware of min & max value;
// 빈 곳의 개수를 세는 것도 그래프를 잘 푸는 방법중 하나!
// /와 %연산은 배열을 나타낼때 유용하게 쓰인다.
// 배운거 내에서만 쓸 생각을 하자. 
// 평소 연습했던 대로!
// 행렬을 배열로도 쓸 생각하자
// 급하기 풀지 말자

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

void solve();
int getHash(int* arr, int size, int mul);
int Multi(int num, int mul);
int calNext(int pre, int sub, int mul, int add, int shift);


int tmphash[SIZE][SIZE]; // 임시 해시
int tahash[SIZE][SIZE];  // 선생님 그림 해시
int my[SIZE][SIZE]; // 은기의 그림
int ta[SIZE][SIZE]; // 선생님의 그림

int main()
{
	ios::sync_with_stdio(NULL);
	std::cout.tie(NULL), cin.tie(NULL);

	solve();

	return 0;
}
void solve() {
	int t = 1;
	// cin >> t;
	int cnt = 0;
	while (t--) {
		int h, w, n, m;
		cin >> h >> w >> n >> m;
		int ans = 0;

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {   // 은기의 그림 입력
				char x = 0;
				cin >> x;
				if (x == 'o')
					my[i][j] = 1;
				else
					my[i][j] = 0;
			}


		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {   // 선생님 그림 입력
				char x;
				cin >> x;
				if (x == 'o')
					ta[i][j] = 1;
				else
					ta[i][j] = 0;
			}

		// 라빈 카프

		for (int i = 0; i < h; i++)
			tmphash[0][i] = getHash(my[i], w, 5); // 가로랑 세로는 다른  hash 값 사용
		int key = getHash(tmphash[0], h, 6);

		int mulC = Multi(w, 5);
		int mulR = Multi(h, 6);

		for (int i = 0; i < n; i++) {
			tmphash[0][i] = getHash(ta[i], w, 5);
			for (int j = 1; j < m - w + 1; j++)
				tmphash[j][i] = calNext(tmphash[j - 1][i], ta[i][j - 1], mulC, ta[i][j + w - 1], 5);
		}
		for (int i = 0; i < m - w + 1; i++) {
			tahash[0][i] = getHash(tmphash[i], h, 6);
			for (int j = 1; j < n - h + 1; j++)
				tahash[j][i] = calNext(tahash[j - 1][i], tmphash[i][j - 1], mulR, tmphash[i][j + h - 1], 6);
		}


		for (int i = 0; i < n - h + 1; i++)
			for (int j = 0; j < m - w + 1; j++) {
				//cout << tahash[i][j] << ' ' << key << '\n';
				if (tahash[i][j] == key)
					ans++;
			}

		// cout << "#" << ++cnt << " " << ans << '\n';
		cout << ans;
	}
}
int getHash(int* arr, int size, int mul) {
	ull hash = 0;
	for (int i = 0; i < size; i++)
		hash = (hash << mul) + hash + arr[i];
	return (int)(hash & mod);
}
int Multi(int num, int mul) {
	ull ret = 1;
	for (int i = 1; i < num; i++)
		ret = (ret << mul) + ret;

	return (int)(ret & mod);
}
int calNext(int pre, int sub, int mul, int add, int shift) {
	ull hash = pre - (sub * mul);
	hash = (hash << shift) + hash + add;
	return (int)(hash & mod);
}



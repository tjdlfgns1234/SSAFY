#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<list>
#include <numeric>
#include <algorithm>
#include<queue>
#define MAX 200'000
using namespace std;

struct Class {
	int s, e;
};

void solve();

int n, k;
Class arr[MAX+1] = { 0 };

bool operator< (const Class& a, const Class& b) {
	return a.s < b.s;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// freopen("input.txt", "r", stdin);

	solve();
}
void solve() {
	cin >> n;

	int s, e;
	for (int i = 0; i < n; i++)
		cin >> s >> e, arr[i].s = s, arr[i].e = e;

	sort(arr, arr + n);
	// 모든 강의를 해야함. 따라서 시작순으로 정렬해야됨.


	priority_queue<int> pq;

	int ans = 0, curre = 0;
	for (int i = 0; i < n; i++) {
		pq.push(-arr[i].e);
		if (-pq.top() <= arr[i].s) // 현재 있는 강의실에서 수업 가능해?
			pq.pop();
	}
	
	cout << pq.size();
}
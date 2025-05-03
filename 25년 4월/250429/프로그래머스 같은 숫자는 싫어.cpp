#include <bits/stdc++.h>
#define all(x) x.begin(),x.end()
using namespace std;

vector<int> solution(vector<int> arr) 
{
    arr.erase(unique(all(arr)),arr.end());
    return arr;
}
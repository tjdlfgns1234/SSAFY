#include<bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    bool answer = true;

    int st = 0;
    
    for(auto& i : s){
        if(i == '(')
            st++;
        else if(st >=1)
            st--;
        else{
            answer = false;
            break;
        }
        
    }
    
    if(st != 0)
        answer = false;
    
    return answer;
}
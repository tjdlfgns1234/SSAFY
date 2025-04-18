class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //공격 인덱스
        int idx = 0;
        
        //전체 시간
        int time = 1;
        
        //시전 성공 횟수
        int sTime = 0;
        
        //현제 체력
        int hp = health;
        
        //bandage 파싱
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        while(idx < attacks.length){
            //몬스터 공격 받기
            if(attacks[idx][0] == time){
                hp -= attacks[idx][1];
                idx++;
                sTime = 0;
                    
                //캐릭터 죽었느지 확인
                if(hp <= 0) {
                    return -1;
                }
            }else{
                //회복
                hp += x;
                sTime++;

                //추가 회복
                if(t == sTime){
                    hp += y;
                    sTime = 0;
                }

                //회복량 넘었는지 확인
                if(hp > health){
                    hp = health;
                }
            }
                //시간 증가 
                time++;
        }
        return hp;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class BOJ_강의실_배정{
    static class ClassRoom{
        int start, end;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        ClassRoom[] rooms = new ClassRoom[n];

        for(int i = 0; i < n; i++){
            ClassRoom room = new ClassRoom();
            room.start = sc.nextInt();
            room.end = sc.nextInt();
            rooms[i] = room;
        }
        
        Arrays.sort(rooms, (o1,o2)->(Integer.compare(o1.start, o2.start)));

        //종료 시간
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 1;
        pq.add(rooms[0].end);
        for(int i = 1; i < n; i++){
            //강의실 존재
            if(pq.peek() <= rooms[i].start){
                pq.poll();
                pq.add(rooms[i].end);
            }else{
                pq.add(rooms[i].end);
                count++;
            }
        }

        System.out.println(count);
    }
    
}
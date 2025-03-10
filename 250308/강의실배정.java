import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.WeakHashMap;

public class 강의실배정 {

    static class pair{
        int s;
        int e;
        public pair(int s , int e){
            this.s=s;
            this.e=e;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws Exception {
        int N = Integer.parseInt(br.readLine());
        pair[] arr = new pair[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new pair(s,e);
        }

        //시작 시간과 끝 시간을 비교해주기 위한 sort
        Arrays.sort(arr , (o , o1)->o.s-o1.s);

        //PQ를 이용해서 가장 작은 끝나는 시간을 가진 강의실을 뽑아낸다.
        PriorityQueue<pair> pq =new PriorityQueue<>((o , o1)->o.e-o1.e);
        pq.add(arr[0]);


        for(int i=1;i<N;i++){
            pair Pend = pq.poll();
            pair p = arr[i];
            if(Pend.e<=p.s){
                pq.add(new pair(p.s,p.e)); // 다시 넣을 때 S는 사실 중요하지 않다.(end 시간만 비교)
            }
            else{
                //새로운 강의실 추가
                pq.add(p);
                pq.add(Pend);
            }
        }

        System.out.println(pq.size());

    }

}

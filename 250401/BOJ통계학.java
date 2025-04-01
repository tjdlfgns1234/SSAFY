import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ통계학 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], 0);
        }

        Arrays.sort(arr);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //빈도 체크
            map.put(arr[i], map.get(arr[i])+1);

            if(max < arr[i]){
                max = arr[i];
            }

            if(min > arr[i]){
                min = arr[i];
            }
        }

        //산술 평균
        System.out.println((int) Math.round(((float) sum) / n));

        //중앙값
        System.out.println(arr[n/2]);
        

        //최빈값
        int maxCount = 0;
        for(int key: map.keySet()){
            if(maxCount < map.get(key)){
                maxCount = map.get(key);
            }
        }
        
        List<Integer> choibin = new ArrayList<>();
        for(int key :map.keySet()){
            if(map.get(key) == maxCount){
                choibin.add(key);
            }
        }
        choibin.sort((o1,o2)->{
            return o1.compareTo(o2);
        });
        
        if(choibin.size() > 1){
            System.out.println(choibin.get(1));
        }else{
            System.out.println(choibin.get(0));
        }

        //범위
        System.out.println(max-min);

    }
}

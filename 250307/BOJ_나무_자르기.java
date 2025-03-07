import java.util.Scanner;


public class BOJ_나무_자르기 {
    static boolean check = false;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int max = 0;

    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] tree = new int[n];

    for(int i = 0 ; i < tree.length; i++){
        tree[i] = sc.nextInt();
    }

    for(int t : tree ){
        if(max < t){
            max = t;
        }
    }

    int result = -1;
    int low = 0;
    int high = max;
    int mid;

    while(low <= high){

        mid = (low +high)/2;
        long sum = 0;

        for(int t : tree){
            if(t > mid){
                sum += (t - mid);
            }
            
        }
        
        if(sum >= k){
            result = mid;
            low = mid + 1;
        }else{
            high = mid- 1;
        }
    }

    System.out.println(result);

}
}

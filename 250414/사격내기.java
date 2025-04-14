import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사격내기 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();
    static int Max=512;

    //"난 너희 둘 중 한 명만 맞힌 표적은 다 맞혔는데,
    // 너희 둘 다 못 맞히거나 둘 다 맞힌 것은 전부 안 맞혔어."

    // 1점 / 2점 / 4점 / 8점 / 16점 / 32점
    // / 64점 / 128점 / 256점 / 512점

    static List<Integer> lA = new ArrayList<>();
    static List<Integer> lB = new ArrayList<>();
    static int[] arr = {512,256,128,64,32,16,8,4,2,1};

    public static void main(String[] args)throws Exception {
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<arr.length;i++){
            int tempN = N;
            for(int j=i;j<arr.length;j++){
                if(tempN-arr[j]>=0) {
                    tempN -= arr[j];
                    lA.add(arr[j]);
                }
            }
            if(tempN!=0){
                lA = new ArrayList<>();
            }
            else{
                break;
            }
        }

        for(int i=0;i<arr.length;i++){
            int tempN = M;
            for(int j=i;j<arr.length;j++){
                if(tempN-arr[j]>=0) {
                    tempN -= arr[j];
                    lB.add(arr[j]);
                }
            }
            if(tempN!=0){
                lB = new ArrayList<>();
            }
            else{
                break;
            }
        }

        int sum=0;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            boolean iCA=false;
            for(int j=0;j<lA.size();j++){
                if(lA.get(j).equals(temp)){
                    iCA=true;
                    break;
                }
            }
            boolean iCB=false;
            for(int j=0;j<lB.size();j++){
                if(lB.get(j).equals(temp)){
                    iCB=true;
                    break;
                }
            }

            if( (iCB&&!iCA) || (!iCB&&iCA) ){
                sum+=temp;
            }
        }



        System.out.println(sum);
    }

}



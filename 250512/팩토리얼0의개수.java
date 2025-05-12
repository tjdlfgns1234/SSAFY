import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팩토리얼0의개수 {




    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)throws Exception {
        int N = Integer.parseInt(br.readLine());
        int five=0;

        while (N!=0){
            if(N%125==0){
                five+=3;
            }
            else if(N%25==0){
                five+=2;
            }
            else if(N%5==0){
                five++;
            }
            N--;
        }
        System.out.println(five);
    }

}


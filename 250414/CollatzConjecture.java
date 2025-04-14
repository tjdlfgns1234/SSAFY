import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CollatzConjecture {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args)throws Exception {
        int N = Integer.parseInt(br.readLine());

        while (true){
            sb.append(N+"\n");
            if(N==1){
                break;
            }
            if(N%2==0){
                N/=2;
            }
            else{
                N=3*N+1;
            }

        }

        System.out.println(sb);
    }

}



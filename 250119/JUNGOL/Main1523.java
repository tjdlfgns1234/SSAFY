import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1523 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n < 1 || n > 100 || m < 1 || m > 3) {
            System.out.println("INPUT ERROR!");
            return;
        }

        switch (m) {
            case 1:
                typeOne(n);
                break;
            case 2:
                typeTwo(n);
                break;
            case 3:
                typeThree(n);
                break;
        }
    }

    public static void typeOne(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<=i; ++j) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }

    public static void typeTwo(int n) {
        for (int i=n; i>0; --i) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<i; ++j) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }

    public static void typeThree(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j=n-1-i; j>0; --j) {
                sb.append(" ");
            }
            for (int k=0; k<2*i+1; ++k) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}

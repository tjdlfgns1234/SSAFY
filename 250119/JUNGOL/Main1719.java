import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n < 1 || n > 100 || n % 2 == 0 || m < 1 || m > 4) {
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
            case 4:
                typeFour(n);
                break;
        }
    }

    public static void typeOne(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i <= n/2) {
                for (int j = 0; j <= i; ++j) {
                    sb.append("*");
                }
            }
            else {
                for (int j = i; j < n; ++j) {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }

    public static void typeTwo(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i <= n/2) {
                for (int j = n/2-1; j >=i; --j) {
                    sb.append(" ");
                }
                for (int k=0; k<=i; ++k) {
                    sb.append("*");
                }
            }
            else {
                for (int j = n/2; j < i; ++j) {
                    sb.append(" ");
                }
                for (int k=i; k<n; ++k) {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }

    public static void typeThree(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i <= n/2) {
                for (int j=0; j<i; ++j) {
                    sb.append(" ");
                }
                for (int k=0; k<n-i*2; ++k) {
                    sb.append("*");
                }
            }
            else {
                for (int j=i+1; j<n; ++j) {
                    sb.append(" ");
                }
                for (int k=n; k>n - (n-(n-i-1)*2); --k) {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }

    public static void typeFour(int n) {
        for (int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i <= n/2) {
                for (int j=0; j<i; ++j) {
                    sb.append(" ");
                }
                for (int k=i; k<=n/2; ++k) {
                    sb.append("*");
                }
            }
            else {
                for (int j=0; j<n/2; ++j) {
                    sb.append(" ");
                }
                for (int k=n/2; k<=i; ++k) {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
        String s = br.readLine();

        for (String string : strings) {
            s = s.replaceAll(string, "1");
        }

//        System.out.println(s);

        System.out.println(s.length());
    }
}

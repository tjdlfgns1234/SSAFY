import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
public static void BOJ암호_만들기(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int l = Integer.parseInt(line[0]);
    int c = Integer.parseInt(line[1]);

    char[] arr = new char[c];
    line = br.readLine().split(" ");
    for(int i = 0; i < c; i++){
        arr[i] = line[i].charAt(0);
    }

    Arrays.sort(arr);
    comb(arr, new char[l], 0, 0);
}
static void comb(char[] arr, char[] sel, int idx, int depth){
    if(sel.length == depth){
        int a = 0;
        int s = 0;

        for(int i = 0; i < sel.length; i++){
            if(sel[i] == 'a' || sel[i] == 'e' || sel[i] == 'i' || sel[i] == 'o' || sel[i] == 'u'){
                a++;
            }else{
                s++;
            }     
        }
        if(a >= 1 && s>=2){
            StringBuilder sb = new StringBuilder();
            sb.append(sel);
            System.out.println(sb);
        }
        
        return;
    }
    if(arr.length == idx) return;

    sel[depth] = arr[idx];
    comb(arr, sel, idx+1, depth+1);
    
    comb(arr, sel, idx+1, depth);
}
}
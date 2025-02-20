import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("noj.am/BAEKJOON/solving/11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().trim().split(" ");
        int[] users = new int[N];
        for (int i = 0; i < N; i++) {
            users[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(users);
        int totalTime = 0;
        int waitSum = 0;
        for (int i = 0; i < N; i++) {
            waitSum += users[i];
            totalTime += waitSum;
        }
        System.out.println(totalTime);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ최단경로 {
    static class Node{
        int idx;
        int weight;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int start = Integer.parseInt(br.readLine()) -1;

        List<Node>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0])-1;
            int v = Integer.parseInt(line[1])-1;
            int w = Integer.parseInt(line[2]);
            Node node = new Node();
            node.idx = v;
            node.weight = w;
            graph[u].add(node);
        }

        //setting
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] check = new boolean[n];

        dist[start] = 0;
        Node node = new Node();
        node.idx = start;
        node.weight = 0;
        pq.offer(node);

        while(!pq.isEmpty()){
            Node cNode = pq.poll();
            int cidx = cNode.idx;
            if(check[cidx]) continue;
            check[cidx] = true;

            for(int i = 0; i < graph[cidx].size(); i++){
                Node next = graph[cidx].get(i);
                if(dist[next.idx] > (dist[cidx] + next.weight)){
                    dist[next.idx] = (dist[cidx] + next.weight);
                    
                    Node newNode = new Node();
                    newNode.idx = next.idx;
                    newNode.weight = dist[next.idx];
                    pq.offer(newNode);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

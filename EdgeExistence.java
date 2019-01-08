/**
 * Created by MalhotR1 on 04/09/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EdgeExistence {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] in = br.readLine().trim().split(" ");
            int N = Integer.parseInt(in[0]);
            int M = Integer.parseInt(in[1]);
            int[][] adj = new int[N+1][N+1];

            for (int i=0; i<M; i++) {
                in = br.readLine().trim().split(" ");
                int A = Integer.parseInt(in[0]);
                int B = Integer.parseInt(in[1]);
                adj[A][B] = 1;
            }

            int Q = Integer.parseInt(br.readLine().trim());
            for (int i=0; i<Q; i++) {
                in = br.readLine().trim().split(" ");
                int A = Integer.parseInt(in[0]);
                int B = Integer.parseInt(in[1]);
                if (adj[A][B] == 1) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

}

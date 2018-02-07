/**
 * Created by MalhotR1 on 02/07/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MirrorImage {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().trim().split(" ");
            int N = Integer.parseInt(in[0]);
            int Q = Integer.parseInt(in[1]);
            int[] parent = new int[N-1];
            int[] child = new int[N-1];
            String[] lr = new String[N-1];
            for (int i = 0; i < N-1; i++) {
                in = br.readLine().trim().split(" ");
                parent[i] = Integer.parseInt(in[0]);
                child[i] = Integer.parseInt(in[1]);
                lr[i] = in[2];
            }
            for (int i = 0; i < Q; i++) {
                int node = Integer.parseInt(br.readLine().trim());
                if (node == 1) {
                    System.out.println(1);
                    continue;
                }
                ArrayList<String> path = new ArrayList<>();

                while (node != 1) {
                    for (int j = 0; j < N-1; j++) {
                        if (child[j] == node) {
                            node = parent[j];
                            if (lr[j].equals("R")) path.add("L");
                            else path.add("R");
                            break;
                        }
                    }
                }

                node = 1;
                boolean found = false;
                Collections.reverse(path);
                for (String str : path) {
                    found = false;
                    for (int j = 0; j < N-1; j++) {
                        if (parent[j] == node && lr[j].equals(str)) {
                            node = child[j];
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println(-1);
                        break;
                    }
                }
                if (found) System.out.println(node);
            }
        }
    }

}

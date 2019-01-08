/**
 * Created by MalhotR1 on 02/08/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Comrades2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                int N = Integer.parseInt(br.readLine().trim());
                String[] in = br.readLine().trim().split(" ");

                int root = -1;
                HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
                for (int i = 0; i < in.length; i++) {
                    int v = Integer.parseInt(in[i]);
                    if (v == 0) root = i+1;
                    else {
                        ArrayList<Integer> al;
                        if (hm.containsKey(v)) {
                            al = hm.get(v);
                        } else {
                            al = new ArrayList<>();
                            hm.put(v, al);
                        }
                        al.add(i+1);
                    }
                }

                int[] height = new int[hm.size()];
                Queue<Integer> queue = new LinkedList<>();
                ArrayList<Integer> nodes = new ArrayList<>();
                queue.add(root);
                for (int i = 0; i < height.length; i++) {
                    while (!queue.isEmpty()) {
                        root = queue.poll();
                        ArrayList<Integer> al = hm.get(root);
                        nodes.addAll(al);
                        height[i] += al.size();
                    }
                    queue.addAll(nodes);
                    nodes.clear();
                }

                int sum = 0;
                long fists = 0;
                int handshakes = 0;
                for (int i = height.length - 1; i >= 0 ; i--) {
                    fists += calnc2(height[i]);
                    if (i != height.length - 1) {
                        handshakes += height[i] * sum;
                    }
                    sum += height[i];
                }

                handshakes += sum;
                System.out.println(handshakes + " " + fists);
            }
        }
    }

    private static long calnc2(int i) {
        long res = 0;
        if (i % 2 == 0) {
            res = (i/2)*(i-1);
        } else {
            res = ((i - 1) / 2) * i;
        }
        return res;
    }

}

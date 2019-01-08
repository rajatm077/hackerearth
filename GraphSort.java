/**
 * Created by MalhotR1 on 04/09/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class GraphSort {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().trim().split(" ");

            int N = Integer.parseInt(in[0]);
            Node[] nodes = new Node[N];
            int M = Integer.parseInt(in[1]);
            int k = Integer.parseInt(in[2]);
            in = br.readLine().trim().split(" ");
            for (int i = 0; i < in.length; i++) {
                nodes[i] = new Node(i+1, Integer.parseInt(in[i]));
            }

            for (int m = 0; m < M; m++) {
                in = br.readLine().trim().split(" ");
                int A = Integer.parseInt(in[0]) - 1;
                int B = Integer.parseInt(in[1]) - 1;
                if (nodes[A].list == null) nodes[A].list = new ArrayList<>();
                nodes[A].list.add(nodes[B]);
                if (nodes[B].list == null) nodes[B].list = new ArrayList<>();
                nodes[B].list.add(nodes[A]);

            }

            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].list.size() < k) System.out.println(1);

                else {
                    Collections.sort(nodes[i].list, (n1, n2) -> {
                        if (n1.val == n2.val) return n1.index - n2.index;
                        else return n2.val - n1.val;
                    });

                    System.out.println(nodes[i].list.get(k-1).index);
                }

            }

        }
    }

}

class Node {
    int index;
    int val;
    ArrayList<Node> list;

    public Node() {
        index = -1;
        val = 0;
        list = new ArrayList<>();
    }

    public Node(int index, int weight) {
        this.index = index;
        this.val = weight;

    }
 }

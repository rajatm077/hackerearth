/**
 * Created by MalhotR1 on 03/28/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchEngine {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            TrieC root = new TrieC();
            for (int t = 0; t < N; t++) {
                int total = 0;
                String[] in = br.readLine().trim().split(" ");
                int W = Integer.parseInt(in[1]);
                AddStringToTrie(root, in[0], W);
            }
            for (int i = 0; i < K; i++) {
                String key = br.readLine().trim();
                int w = isStringPresent(root, key);
                System.out.println(w);

            }
        }
    }
    private static int isStringPresent(TrieC root, String search) {
        if (root == null) return 0;
        boolean flag = true;
        char[] arr = search.toCharArray();
        for (char c : arr) {
            int index = (int) c - 97;
            if (root.next[index] != null) root = root.next[index];
            else {
                flag = false;
                break;
            }
        }
        if (!flag) return -1;
        else {
            //return findAllMatches(root, Integer.MIN_VALUE);
            return root.w;
        }

    }

    private static int findAllMatches(TrieC root, int weight) {
        if (root.isEnd && root.w > weight) weight = root.w;
        TrieC[] nodes = root.next;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                weight = Math.max(weight, findAllMatches(nodes[i], weight));
            }
        }
        return weight;
    }

    private static void AddStringToTrie(TrieC root, String item, int w) {
        char[] str = item.toLowerCase().toCharArray();
        for (char c : str) {
            int index = (int) c - 97;
            if (root.next[index] == null) {
                root.next[index] = new TrieC();
                root.next[index].key = c;
            }
            root = root.next[index];
            if(root.w<w)
                root.w = w;
        }
        root.isEnd = true;
    }
}


class TrieC {
    TrieC[] next = new TrieC[26];
    char key;
    boolean isEnd;
    int w = 0;
}




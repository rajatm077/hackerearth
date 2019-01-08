/**
 * Created by MalhotR1 on 04/09/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Monkintherealestate {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                HashSet<Integer> hs = new HashSet<>();
                int E = Integer.parseInt(br.readLine().trim());
                for (int e = 0; e < E; e++) {
                    String[] in = br.readLine().trim().split(" ");
                    hs.add(Integer.parseInt(in[0]));
                    hs.add(Integer.parseInt(in[1]));
                }
                System.out.println(hs.size());
            }
        }
    }

}

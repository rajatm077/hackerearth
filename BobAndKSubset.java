/**
 * Created by MalhotR1 on 05/26/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BobAndKSubset {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
            long[] arr = new long[n];
            in = br.readLine().split(" ");
            if (k == 1) System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Long.parseLong(in[i]);
            }

            HashSet<Long> hs = new HashSet<>();
            for (int count = 1; count < k; count++) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = i+count; j < arr.length; j++) {
                        arr[i] |= arr[j];
                        hs.add(arr[i]);
                    }
                }
            }


        }
    }

}

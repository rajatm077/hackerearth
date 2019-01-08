package JanEasy19;/**
 * Created by MalhotR1 on 01/06/2019.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenSegmentDisplay {
    public static void main(String[] args) throws IOException {
        int[] display = {6,2,5,5,4,5,6,3,7,6};
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                char[] N = br.readLine().trim().toCharArray();
                long totalSticks = 0;
                for (int i = 0; i < N.length; i++) {
                    int index = N[i] - 48;
                    totalSticks += display[index];
                }
                StringBuilder res = new StringBuilder();
                if ((totalSticks & 1) == 1) {
                    res.append(7);
                    totalSticks -= 3;
                }
                while (totalSticks > 0) {
                    res.append(1);
                    totalSticks -= 2;
                }
                System.out.println(res);
            }
        }
    }
}

/**
 * Created by MalhotR1 on 05/26/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cipher {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] in = br.readLine().trim().toCharArray();
            int k = Integer.parseInt(br.readLine().trim());
//            System.out.println(Integer.valueOf(in[0]));
            for (int i = 0; i < in.length; i++) {
                if (in[i] >= 'A' && in[i] <= 'Z') {
                    in[i] = (char)(((in[i] - 'A') + k) % 26 + 'A');
                } else if (in[i] >= 'a' && in[i] <= 'z') {
                    in[i] = (char)(((in[i] - 'a') + k) % 26 + 'a');
                } else if (in[i] >= '0' && in[i] <= '9') {
                    in[i] = (char)(((in[i] - '0') + k) % 10 + '0');
                }
            }

            System.out.println(String.valueOf(in));
        }
    }

}

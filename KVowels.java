/**
 * Created by MalhotR1 on 04/14/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KVowels {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                String[] in = br.readLine().trim().split(" ");
                int N = Integer.parseInt(in[0]);
                int k = Integer.parseInt(in[1]);
                char[] dv = new char[k];
                char[] key = br.readLine().trim().toLowerCase().toCharArray();
                int maxL = Integer.MIN_VALUE;
                int dvi = 0;
                int temp = 0;
                boolean anyVowel = false;

                for (int i = 0; i < key.length; i++) {
                    if (key[i] == 'a' || key[i] == 'e' || key[i] == 'i'
                            || key[i] == 'o' || key[i] == 'u') {

                        if (!anyVowel) anyVowel = true;
                        if (dvi == 0) dv[dvi++] = key[i];
                        else {
                            boolean isThere = false;
                            for (int j = 0; j < dvi; j++) {
                                if (dv[j] == key[i]) {
                                    isThere = true;
                                    break;
                                }
                            }
                            if (!isThere) {
                                if (dvi == k) {
                                    if (temp > maxL) maxL = temp;
                                    temp = 0;
                                    dvi = 0;
                                }
                                dv[dvi++] = key[i];
                            }
                        }
                    }
                    temp++;
                }
                if (!anyVowel) System.out.println(0);
                else System.out.println(maxL);

            }
        }
    }

}

/**
 * Created by MalhotR1 on 04/09/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkattheGraphFactory {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] in = br.readLine().trim().split(" ");
            int sum = 0;
            int total = 2*N - 2;
            for (int i = 0; i < N; i++) {
                sum += Integer.parseInt(in[i]);
            }

            if (total == sum) System.out.println("Yes");
            else System.out.println("No");

        }
    }

}

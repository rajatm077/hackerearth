package JanEasy19;/**
 * Created by MalhotR1 on 01/06/2019.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MediumSumSetProblem {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());
            TreeSet<Long> nset = new TreeSet<>();
            String[] in = br.readLine().trim().split(" ");
            for (String s : in) {
                nset.add(Long.parseLong(s));
            }

            N = Integer.parseInt(br.readLine().trim());
            TreeSet<Long> cset = new TreeSet<>();
            in = br.readLine().trim().split(" ");
            for (String s : in) cset.add(Long.parseLong(s));

            Set<Long> bset = new TreeSet<>();
            long start = cset.first() - nset.first();
            long end = cset.last() - nset.last();

            for (long i = start; i <= end; i++) {
                boolean exists = true;
                for (Long e : nset) {
                    long sum = i + e;
                    if (!cset.contains(sum)) {
                        exists = false;
                        break;
                    }
                }
                if (exists) {
                    bset.add(i);
                }
            }
            for (Long e: bset) System.out.print(e + " ");
        }
        System.out.println();
    }

}

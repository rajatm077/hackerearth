/**
 * Created by MalhotR1 on 05/20/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Winner {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                String[] ques_sc = br.readLine().trim().split(" ");
                String[] ques_dec = br.readLine().trim().split(" ");
                String[] ft = br.readLine().trim().split(" ");
                String[] ct = br.readLine().trim().split(" ");
                long[] scores = new long[4];
                long[] dec = new long[4];
                long[] ftime = new long[4];
                long[] ctime = new long[4];
                long ftt = 0;
                long ctt = 0;
                for (int i = 0; i < 4; i++) {
                    scores[i] = Long.parseLong(ques_sc[i]);
                    dec[i] = Long.parseLong(ques_dec[i]);
                    ftime[i] = Long.parseLong(ft[i]); ftt = Math.max(ftt, ftime[i]);
                    ctime[i] = Long.parseLong(ct[i]); ctt = Math.max(ctt, ctime[i]);
                }

                long fscore = 0;
                long cscore = 0;
                for (int i = 0; i < 4; i++) {
                    long fded = scores[i] - (ftime[i] * dec[i]);
                    if (fded < scores[i] / 2) fded = scores[i] / 2;
                    fscore += fded;

                    long cded = scores[i] - (ctime[i] * dec[i]);
                    if (cded < scores[i] / 2) cded = scores[i] / 2;
                    cscore += cded;

                }

                if (fscore > cscore) System.out.println("Flash");
                else if (cscore > fscore) System.out.println("Cisco");
                else {
                    if (ftt < ctt) System.out.println("Flash");
                    else if (ctt < ftt) System.out.println("Cisco");
                    else System.out.println("Tie");
                }
            }
        }
    }
}

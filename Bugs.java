    /**
     * Created by MalhotR1 on 05/20/2018.
     */

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.PriorityQueue;

    public class Bugs {
        public static void main(String[] args) throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                long N = Long.parseLong(br.readLine().trim());
                ArrayList<Long> al = new ArrayList<Long>();
                for (int i = 0; i < N; i++) {
                    String[] in = br.readLine().trim().split(" ");
                    int q = Integer.parseInt(in[0]);
                    if (q == 1) {
                        long data = Long.parseLong(in[1]);
                        al.add(data);
                    } else {
                        if (al.size() < 3) System.out.println("Not enough enemies");
                        else {
                            int index = al.size() - al.size() / 3;
                            Collections.sort(al);
                            System.out.println(al.get(index));


                        }
                    }
                }
            }
        }
    }

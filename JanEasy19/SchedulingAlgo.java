package JanEasy19;/**
 * Created by MalhotR1 on 01/06/2019.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SchedulingAlgo {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            for (int t = 0; t < T; t++) {
                String[] in = br.readLine().trim().split(" ");
                int N = Integer.parseInt(in[0]);
                int L = Integer.parseInt(in[1]);

                if (N == 1) {
                    System.out.println(br.readLine().trim());
                    continue;
                }

                ArrayList<Deque<Integer>> RQ = new ArrayList<>();
                for (int n = 0; n < N; n++) {
                    in = br.readLine().trim().split(" ");
                    Deque<Integer> queue = new LinkedList<>();
                    for (String s : in) {
                        queue.add(Integer.parseInt(s));
                    }
                    RQ.add(queue);
                }

                for (int i = 0; i < N*L; i++) {
                    int min = Integer.MAX_VALUE;
                    int index = -1;
                    for (int j = 0; j < N; j++) {
                        Deque<Integer> queue = RQ.get(j);
                        if (queue.size() > 0) {
                            if (min > queue.peek()) {
                                min = queue.peek();
                                index = j;
                            } else if (min == queue.peek()){
                                int temp1 = queue.poll();
                                int temp2 = RQ.get(index).poll();
                                if (queue.peek() < RQ.get(index).peek())
                                    index = j;

                                queue.addFirst(temp1);
                                RQ.get(index).addFirst(temp2);
                            }
                        }
                    }

                    System.out.print(RQ.get(index).poll() + " ");
                }
                System.out.println();
            }
        }
    }

}

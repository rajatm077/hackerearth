/**
 * Created by MalhotR1 on 04/14/2018.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpAOpe {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] in = br.readLine().trim().split(" ");
            int N = Integer.parseInt(in[0]);
            int K = Integer.parseInt(in[1]);
            in = br.readLine().trim().split(" ");
            long[] arr = new long[N];
            for (int i = 0; i < in.length; i++) {
                arr[i] = Long.parseLong(in[0]);
            }

            ArrayList<Long> minheap = builMinHeap(arr);
            ArrayList<Long> maxheap = builMaxHeap(arr);


            for (int k = 0; k < K; k++) {
                int T = Integer.parseInt(br.readLine());
                for (int t = 0; t < T; t++) {
                    minheap = builMinHeap(arr);
                    maxheap = builMaxHeap(arr);
                    long diff = maxheap.get(0) - minheap.get(0);

                    maxheap.set(0, diff);
                    minheap.set(0, diff);
                    minheap = insertMinHeap(0, minheap);
                    maxheap = insertMaxHeap(0, maxheap);
                    long sum = 0;
                    for (int i = 0; i < minheap.size(); i++) {
                        sum += minheap.get(i);
                    }

                }
            }

            
        }
    }

    private static ArrayList<Long> insertMaxHeap(int index, ArrayList<Long> maxheap) {
        int left = 2*index + 1;
        int right = left + 1;
        int crrindex = index;
        int largest = crrindex;
        while (left < maxheap.size()) {
            if (maxheap.get(left) > maxheap.get(largest)) {
                largest = left;
            } else if (right < maxheap.size() && maxheap.get(right) > maxheap.get(largest)) {
                largest = right;
            }

            if (largest == crrindex) break;
            else {
                long temp = maxheap.get(largest);
                maxheap.set(crrindex, maxheap.get(largest));
                maxheap.set(largest, temp);
                crrindex = largest;
                left = 2*crrindex + 1;
                right = left + 1;
            }

        }
        return maxheap;
    }

    private static ArrayList<Long> insertMinHeap(int index, ArrayList<Long> minheap) {
        int left = 2*index + 1;
        int right = left + 1;
        int crrindex = index;
        int smallest = crrindex;
        while (left < minheap.size()) {
            if (minheap.get(left) < minheap.get(smallest)) {
                smallest = left;
            } else if (right < minheap.size() && minheap.get(right) < minheap.get(smallest)) {
                smallest = right;
            }

            if (smallest == crrindex) break;
            else {
                long temp = minheap.get(smallest);
                minheap.set(crrindex, minheap.get(smallest));
                minheap.set(smallest, temp);
                crrindex = smallest;
                left = 2*crrindex + 1;
                right = left + 1;
            }

        }

        return minheap;
    }

    private static ArrayList<Long> builMaxHeap(long[] arr) {
        ArrayList<Long> maxheap = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            maxheap.set(i, arr[i]);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            maxheap = insertMaxHeap(i, maxheap);
        }
        return maxheap;

    }

    private static ArrayList<Long> builMinHeap(long[] arr) {
        ArrayList<Long> minheap = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            minheap.set(i, arr[i]);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            minheap = insertMinHeap(i, minheap);
        }
        return minheap;

    }

}

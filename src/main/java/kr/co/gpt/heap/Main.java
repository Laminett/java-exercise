package kr.co.gpt.heap;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int maxCount = 10;
        int[] nums = IntStream.range(1, 1000000).toArray();

        System.out.println("===minHeap===");
        long start = System.currentTimeMillis();
        for (int num : nums) {
            minHeap.offer(num);
        }
        for (int i=0; i<maxCount; i++) {
            System.out.println(minHeap.poll());
        }
        long end = System.currentTimeMillis();
        System.out.println("minHeap running time: " + (end-start));

        System.out.println("===maxHeap===");
        start = System.currentTimeMillis();
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > maxCount) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(maxHeap);
        result.sort(Comparator.reverseOrder());
        for (int val: result) {
            System.out.println(val);
        }
        end = System.currentTimeMillis();
        System.out.println("maxHeap running time: " + (end-start));
    }
}

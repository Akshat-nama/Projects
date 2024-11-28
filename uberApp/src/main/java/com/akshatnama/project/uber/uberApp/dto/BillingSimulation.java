package com.akshatnama.project.uber.uberApp.dto;

import java.util.PriorityQueue;

public class BillingSimulation {

    static int[] solve(int N, int M, int[] time) {
        // Priority Queue to simulate the min-heap for counters
        PriorityQueue<Counter> counters = new PriorityQueue<>((a, b) -> {
            if (a.freeTime == b.freeTime) {
                return Integer.compare(a.index, b.index); // Break ties by counter index
            }
            return Integer.compare(a.freeTime, b.freeTime);
        });

        // Initialize the counters (all free at time 0)
        for (int i = 0; i < N; i++) {
            counters.add(new Counter(0, i));
        }

        // Array to store the finishing times for each person
        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int arrivalTime = time[i];

            // Get the counter that becomes free the earliest
            Counter currentCounter = counters.poll();

            // Calculate the starting time for this person
            int startTime = Math.max(currentCounter.freeTime, arrivalTime);

            // Calculate the finishing time for this person
            int finishTime = startTime + 1;

            // Store the finishing time in the result array
            result[i] = finishTime;

            // Update the counter's free time and reinsert it into the heap
            currentCounter.freeTime = finishTime;
            counters.add(currentCounter);
        }

        return result;
    }

    // Class to represent a counter
    static class Counter {
        int freeTime;
        int index;

        Counter(int freeTime, int index) {
            this.freeTime = freeTime;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int N = 2; // Number of counters
        int M = 4; // Number of people
        int[] time = {0, 0, 0, 0}; // Arrival times of each person

        // Call solve and return the result
        int[] result = solve(N, M, time);

        for (int t : result) {
            System.out.println(t);
        }   

        // You can use the result in your program if needed
        // Example: Logging or passing it further, but no prints here
    }
}

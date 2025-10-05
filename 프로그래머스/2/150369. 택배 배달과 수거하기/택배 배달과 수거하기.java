import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        PriorityQueue<Integer> deliveryQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pickupQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < deliveries[i]; j++) {
                deliveryQueue.add(i + 1);
            }
            for (int j = 0; j < pickups[i]; j++) {
                pickupQueue.add(i + 1);
            }
        }

        while (!deliveryQueue.isEmpty() || !pickupQueue.isEmpty()) {
            int maxDist = -1;
            int truck = 0;
            while (!deliveryQueue.isEmpty() && truck != cap) {
                int dist = deliveryQueue.poll();
                truck += 1;
                maxDist = Math.max(maxDist, dist);
            }

            truck = 0;
            while (!pickupQueue.isEmpty() && truck != cap) {
                int dist = pickupQueue.poll();
                truck += 1;
                maxDist = Math.max(maxDist, dist);
            }

            answer += maxDist * 2L;
        }

        return answer;
    }
}
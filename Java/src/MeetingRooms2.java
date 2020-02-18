import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    class Interval {
        int s;
        int e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int getS() {
            return s;
        }

        public int getE() {
            return e;
        }
    }

    public Interval[] convert(int[][] arr) {
        return Arrays.stream(arr)
                .map(it -> new Interval(it[0], it[1]))
                .toArray(Interval[]::new);
    }


    public int minMeetingRooms(int[][] intervals) {
        Interval[] arr = convert(intervals);
        if (arr.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(
                        arr.length,
                        Comparator.comparingInt(a -> a));
        Arrays.sort(
                arr,
                Comparator.comparingInt(Interval::getS));

        pq.add(arr[0].getE());

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].getS() >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i].getE());
        }

        return pq.size();
    }
}

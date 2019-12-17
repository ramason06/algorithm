import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    //javaxf Pair 는 leetcode 컴파일러에서 안먹힘
    class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        List<Pair> ans = new ArrayList<>();

        int minn = intervals[0][0];
        int maxx = intervals[0][1];

        for(int i =0 ; i < intervals.length; i++) {
            if(i == intervals.length -1) {
                ans.add(new Pair(minn, maxx));
            } else if(maxx < intervals[i+1][0]) {
                ans.add(new Pair(minn, maxx));
                minn = intervals[i+1][0];
                maxx = intervals[i+1][1];
            } else if ( maxx < intervals[i+1][1] ) {
                maxx = intervals[i+1][1];
            }
        }

        int[][] arr = new int[ans.size()][2];

        for(int i =0 ; i < ans.size(); i++) {
            arr[i][0] = ans.get(i).getKey();
            arr[i][1] = ans.get(i).getValue();
        }

        return arr;
    }
}

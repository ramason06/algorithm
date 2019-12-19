import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        }));

        for(int i = 0; i < (intervals.length - 1); i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] arr =  {{7,10},{2,4}};
        Solution solution = new Solution();
        System.out.println(solution.canAttendMeetings(arr));
    }
}
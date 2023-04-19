package src.alo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MoveRightLeft {
    public int solution(int[] A) {
        Set<Integer> sets = Arrays.stream(A).boxed().collect(Collectors.toSet());
        ;

        List<Integer> list = sets.stream()
                .filter(it -> it > 0)
                .collect(Collectors.toList());

        Collections.sort(list);

        int sizz = list.size();
        if(sizz == 0) {
            return 1;
        }
        if(sizz == list.get(sizz - 1)) {
            return sizz + 1;
        }
        for(int i = 0; i <= list.get(list.size()-1); i++) {
            if(list.get(i) != i+1) {
                return i + 1;
            }
        }

        return 1;
    }
}

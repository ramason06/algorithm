package src.alo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryAdd {

    static List<Integer> binaryAdd(Integer[] a, Integer[] b) {
        List<Integer> aList = Arrays.asList(a);
        List<Integer> bList = Arrays.asList(b);

        Collections.reverse(aList);
        Collections.reverse(bList);

        List<Integer> ansList = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < Math.min(aList.size(), bList.size()); i++) {
            int sum = aList.get(i) + bList.get(i) + carry;
            int mod = sum % 2;
            carry = sum / 2;
            ansList.add(mod);
        }

        if (aList.size() > bList.size()) {
            for (int i = bList.size(); i < aList.size(); i++) {
                int sum = aList.get(i) + carry;
                int mod = sum % 2;
                carry = sum / 2;
                ansList.add(mod);
            }
        }

        if (carry != 0) {
            ansList.add(carry);
        }

        Collections.reverse(ansList);
        return ansList;
    }
}

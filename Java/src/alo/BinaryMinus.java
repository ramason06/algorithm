package src.alo;

import java.util.List;

public class BinaryMinus {
    void make2Comp(Integer[] b) {
        for(int i = 0; i < b.length; i++) {
            b[i] ^=1;
        }

        int carry = 1;
        for(int i = b.length-1; i >= 0; i--) {
            int sum = b[i] + carry;
            int mod = sum % 2;
            carry = sum / 2;
            b[i] = mod;
        }
    }

    void func() {
        Integer[] a = {1, 0, 1};
        Integer[] b = {1, 0, 0};

        make2Comp(b);
        List<Integer> ans = BinaryAdd.binaryAdd(a, b);
        ans.remove(0);
        System.out.println(ans);
    }
}

package src;

public class Read4 {
    private int read4(char[] buf) {
        return 3;
    }
    private char[] buffer = {'a','b','c'};
    private int pos = 0;
    private int size = 0;

    public int read(char[] buf, int n) {
        for (int i=0; i<n; i++) {
            if (hasNext(buf, i)) {
                return i;
            }
        }
        return n;
    }

    private boolean hasNext(char[] buf, int idx) {
        if (pos == size) {
            size = read4(buffer);
            pos = 0;
            if (size == 0) {
                return true;
            }
        }
        buf[idx] = buffer[pos];
        pos++;
        return false;
    }
}

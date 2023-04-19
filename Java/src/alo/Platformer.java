package src.alo;

public class Platformer {
    int n;
    int position;
    int[] floor;

    public Platformer(int n, int position) {
        this.n = n;
        this.floor = new int[n];
        this.position = position;
        this.floor[position] = 1;
    }

    public void jumpLeft() {
        int next = position - 1;
        int move = 0;
        while(next > -1) {
            //hole
            if(floor[next] == 0) {
                move++;
            }
            if(move == 2) {
                position = next;
                floor[position] = 1;
                break;
            }
            next--;
        }
    }

    public void jumpRight() {
        int next = position + 1;
        int move = 0;
        while(next < n) {
            //hole
            if(floor[next] == 0) {
                move++;
            }
            if(move == 2) {
                position = next;
                floor[position] = 1;
                break;
            }
            next++;
        }}

    public int position() {
        return position;
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(10, 6);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}
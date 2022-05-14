
public class CounterTwo {

    private int value;
    private boolean flag[];
    private int turn;
    // volatile boolean flag[];
    // volatile int turn;

    public CounterTwo() {
        this.value = 0;
        this.flag = new boolean[2];
        this.turn = 0;
    }

    public CounterTwo(int value) {
        this.value = value;
    }

    public synchronized boolean getFlag(int index) {
        return flag[index];
    }

    public synchronized int getTurn() {
        return turn;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setTurn(int turn) {
        this.turn = turn;
    }

    public synchronized void setFlag(boolean flag, int index) {
        this.flag[index] = flag;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}


public class CounterThree {

    private int value;
    private boolean flag[];
    private int turn;

    public CounterThree() {
        this.value = 0;
        this.flag = new boolean[2];
        this.turn = 0;
    }

    public CounterThree(int value) {
        this.value = value;
    }

    public boolean getFlag(int index) {
        return flag[index];
    }

    public int getTurn() {
        return turn;
    }

    public int getValue() {
        return value;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setFlag(boolean flag, int index) {
        this.flag[index] = flag;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class Counter {

    int value;
    boolean flag[];
    int turn;

    public Counter() {
        this.value = 0;
        this.flag = new boolean[2];
        this.turn = 0;
    }

    public Counter(int value) {
        this.value = value;
    }
}

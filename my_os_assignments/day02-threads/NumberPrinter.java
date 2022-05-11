
public class NumberPrinter implements Runnable {

    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number == 50) {
            System.out.println("wait");
        }
        System.out.println(this.number);
    }

}

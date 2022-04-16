
import java.util.Scanner;

public class Q4_RotatingGame {

	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner scanner = new Scanner(System.in);
		String line1 = scanner.nextLine();
		String line2 = scanner.nextLine();
		// store elements in array
		String[] tokens = line1.split(" ");
		int arrayLength = Integer.parseInt(tokens[0]);
		int bRotations = Integer.parseInt(line2);
		int actualRotations = (bRotations % arrayLength);

		for (int i = arrayLength - actualRotations + 1; i < tokens.length; i++) {
			System.out.print(tokens[i] + " ");
		}
		for (int i = 1; i < arrayLength - actualRotations + 1; i++) {
			System.out.print(tokens[i] + " ");
		}

		scanner.close();
	}
}

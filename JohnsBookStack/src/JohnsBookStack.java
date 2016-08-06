import java.util.Arrays;
import java.util.Scanner;

public class JohnsBookStack {

	private Scanner scanner = new Scanner(System.in);

	private void doRun() {
		int books = scanner.nextInt();
		int[] stack = new int[books];
		for (int i = 0; i < books; i++) {
			stack[i] = scanner.nextInt();
		}

		long moves = 0L;
		for (int idx = 1; idx < books; idx++) {
			if (stack[idx] <= stack[idx - 1]) {
				long nm = 1L;
				long p = 1L;
				for (int i = 0; stack[i] < stack[idx]; i++) {
					if (i == 0 || stack[i] != stack[i - 1]) {
						p = nm;
						nm *= 2;
					} else {
						nm += p;
					}
				}

				moves += nm;
			}

			Arrays.sort(stack, 0, idx + 1);
		}

		System.out.println(moves);
	}

	public void run() {
		int cases = scanner.nextInt();
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new JohnsBookStack().run();
	}

}

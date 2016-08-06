import java.util.Scanner;

public class Main {

	private Scanner scanner = new Scanner(System.in);

	public void doCase(int n, int d, int[] s) {
		int[][] table = new int[n][n + 1];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = ((Math.abs(j - i) <= d) ? 1 : 0);
			}
			
			table[i][n] = s[i];
		}

		int c = 0;
		
	}

	public void run() {
		int cases = scanner.nextInt();

		for (int i = 0; i < cases; i++) {
			int n = scanner.nextInt();
			int d = scanner.nextInt();
			
			int[] s = new int[n];
			for (int j = 0; j < n; j++) {
				s[j] = scanner.nextInt();
			}
			
			doCase(n, d, s);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

}

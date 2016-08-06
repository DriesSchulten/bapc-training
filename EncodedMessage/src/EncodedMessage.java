import java.util.Scanner;


public class EncodedMessage {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void doRun() {
		String text = scanner.nextLine();
		
		int sqrt = (int) Math.sqrt(text.length() + 0.0D);
		
		for (int i = 0; i < sqrt; i++) {
			for (int j = 0; j < sqrt; j++) {
				System.out.print(text.charAt((sqrt - i - 1) + (j * sqrt)));
			}
		}
		System.out.println();
	}
	
	public void run() {
		int cases = scanner.nextInt();
		
		// Skip
		scanner.nextLine();
		
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new EncodedMessage().run();
	}

}

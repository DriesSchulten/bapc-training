import java.util.Scanner;


public class HowMuch {
	
	private Scanner scanner = new Scanner(System.in);
	
	private void doRun() {
		long price = scanner.nextLong();
		
		int parts = scanner.nextInt();
		for (int i = 0; i < parts; i++) {
			int count = scanner.nextInt();
			price += (count * scanner.nextLong()); 
		}
		
		System.out.println(price);
	}
	
	public void run() {
		int cases = scanner.nextInt();
		
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new HowMuch().run();
	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IdentificationCodes {
	
	private Scanner scanner = new Scanner(System.in);
	
	private void doRun() {
		long id = scanner.nextLong();
		
		long cur = 2L;
		
		List<Long> usedNumbers = new ArrayList<>();
		usedNumbers.add(cur);
		while (id != cur) {
			
		}
	}
	
	public void run() {
		int cases = scanner.nextInt();
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new IdentificationCodes().run();
	}

}

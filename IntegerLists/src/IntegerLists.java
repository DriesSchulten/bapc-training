import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class IntegerLists {
	
	private Scanner scanner = new Scanner(System.in);
	
	private void doRun() {
		String program = scanner.nextLine();
		List<String> list = new ArrayList<>();
		
		scanner.nextInt();
		scanner.nextLine();
		
		String input = scanner.nextLine();
		if (input.length() > 2) {
			input = input.substring(1, input.length() - 1);
			list.addAll(Arrays.asList(input.split(",")));
		}
		
		int idx = 0;
		boolean front = true;
		
		for (int i = 0; i < program.length(); i++) {
			char op = program.charAt(i);
			
			if (op == 'R') {
				if (front) {
					idx = list.size() - 1;
				} else {
					idx = 0;
				}
				front = !front;
			} else if (op == 'D') {
				if (list.isEmpty()) {
					System.out.println("error");
					return;
				} else {
					list.remove(idx);
					if (!front) {
						idx--;
					}
				}
			}
		}
		
		System.out.println(list);
	}
	
	public void run() {
		int cases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new IntegerLists().run();
	}
	
}

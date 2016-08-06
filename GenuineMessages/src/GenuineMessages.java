import java.util.HashMap;
import java.util.Scanner;


public class GenuineMessages {
	
	private static final String OK = "OK";
	private static final String FAKE = "FAKE";
	
	private Scanner scanner = new Scanner(System.in);
	
	private HashMap<Character, Integer> map;
	
	public void doRun() {
		int cases = scanner.nextInt();
		
		// Skip
		scanner.nextLine();
		
		for (int i = 0; i < cases; i++) {
			String word = scanner.nextLine();
			map = new HashMap<>();
			checkWord(word);
		}
	}

	private void checkWord(String word) {
		Character next = null;
		for (int j = 0; j < word.length(); j++) {
			char c = word.charAt(j);
			
			if (next != null && !next.equals(c)) {
				break;
			} else {
				next = null;
			}
			
			int count = 1;
			if (map.containsKey(c)) {
				count += map.get(c);
			}
			map.put(c, count);
			
			if (count % 3 == 0) {
				next = c;
			}
		}
		
		if (next != null) {
			System.out.println(FAKE);
		} else {
			System.out.println(OK);
		}
	}

	public static void main(String[] args) {
		new GenuineMessages().doRun();
	}
	
}

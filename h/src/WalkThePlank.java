import java.util.PriorityQueue;
import java.util.Scanner;


public class WalkThePlank {
	
	private Scanner scanner = new Scanner(System.in);
	
	static class Pirate implements Comparable<Pirate> {
		int[] time;
		int side = 0;
		long total;
		public Pirate(int[] time) {
			this.time =time;
		}
		
		@Override
		public int compareTo(Pirate o) {
			return Long.compare(total, o.total);
		}
	}
	
	public void run() {
		int cases = scanner.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int n = scanner.nextInt();
			int p = scanner.nextInt();
			
			doRun(n, p);
		}
		
	}

	private void doRun(int n, int p) {

		PriorityQueue<Pirate> go = new PriorityQueue<>();
		PriorityQueue<Pirate> back = new PriorityQueue<>();
		
		for (int j = 0; j < p; j++) {
			int times[] = new int[] {
				scanner.nextInt(),
				scanner.nextInt(),
				scanner.nextInt(),
				scanner.nextInt()
			};

			go.offer(new Pirate(times));
		}
		
		long total = 0;

		while (!go.isEmpty() || !back.isEmpty()) {
			Pirate pirateToGo = go.peek();
			Pirate pirateBack = back.peek();
			
			int side = 1;
			Pirate pirate = pirateBack;
			if (pirateBack == null || (pirateToGo != null && pirateBack.total < pirateToGo.total)) {
				pirate = pirateToGo;
				go.poll();
				
			} else {
				back.poll();
			}
			pirate.side = side;
			
			// Oversteek tijd
			long time = pirate.time[pirate.side * 2];
			total = Math.max(pirate.total, total) + time;
			pirate.total = total + pirate.time[pirate.side * 2 + 1];
			
			if (side == 1) {
				n--;
				
				if (n == 0) {
					System.out.println(total);
				} else if (n - back.size() > 0) {
					go.offer(pirate);
				}
			} else {
				back.offer(pirate);
			}
		}
	}

	public static void main(String[] args) {
		new WalkThePlank().run();
	}
	
}

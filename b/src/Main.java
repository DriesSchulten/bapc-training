import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	private Scanner scanner = new Scanner(System.in);
	
	class Pos implements Comparable<Pos>
	{
		int x;
		int y;
		int dist;

		public Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pos o) {
			return dist - o.dist;
		}
	}
	
	public int solveCase() {
		int h, w, d;
		
		h = scanner.nextInt();
		w = scanner.nextInt();
		d = scanner.nextInt();
		
		scanner.nextLine();
		
		char[][] maze = new char[h][w];
		int[][] dist = new int[h][w];
		
		int startX = 0, startY  = 0;
		
		for (int x = 0; x < h; x++) {
			String line = scanner.nextLine();
			
			for (int y = 0; y < w; y++) {
				char c = line.charAt(y);
				maze[x][y] = c;
				dist[x][y] = Integer.MAX_VALUE;
				
				if (c == 'S') {
					startX = x; 
					startY = y;
				}
			}
		}
		
		PriorityQueue<Pos> queue = new PriorityQueue<>();
		
		dist[startX][startY] = 0;
		
		Pos start = new Pos(startX, startY, 0);
		queue.add(start);
		
		while (!queue.isEmpty()) {
			Pos cur = queue.poll();
			
			// Rand van doolhof == einde
			if (cur.x == 0 || cur.x == h - 1  || cur.y == 0 || cur.y == w - 1) {
				return dist[cur.x][cur.y] + 1;
			}
			
			// Buren
			Pos[] neighbours = new Pos[4];
			neighbours[0] = new Pos(cur.x - 1, cur.y, cur.dist);
			neighbours[1] = new Pos(cur.x + 1, cur.y, cur.dist);
			neighbours[2] = new Pos(cur.x, cur.y - 1, cur.dist);
			neighbours[3] = new Pos(cur.x, cur.y + 1, cur.dist);
			
			for (int i = 0; i < 4; i++) {
				Pos n = neighbours[i];
				char p = maze[n.x][n.y];
				if (p != '#') {
					int cost = n.dist + 1;
					if (p == '@') {
						cost += d;
					}
					n.dist = cost;
		
					if (cost < dist[n.x][n.y]) {
						dist[n.x][n.y] = cost;
						queue.add(n);
					}
				}
			}
		}
		
		return -1;
	}
	
	public void run() {
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println(solveCase());
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

}

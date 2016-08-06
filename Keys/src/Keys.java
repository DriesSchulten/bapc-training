import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Keys {

	private Scanner scanner = new Scanner(System.in);

	private class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public List<Pos> next(int h, int w) {
			List<Pos> next = new ArrayList<>();
			if (x > 0) {
				next.add(new Pos(x - 1, y));
			}
			if (x < h - 1) {
				next.add(new Pos(x + 1, y));
			}
			if (y > 0) {
				next.add(new Pos(x, y - 1));
			}
			if (y < w - 1) {
				next.add(new Pos(x, y + 1));
			}

			return next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	public void doRun() {
		/*
		 * Read maze
		 */
		int h = scanner.nextInt();
		int w = scanner.nextInt();

		List<Character> doors = new ArrayList<>();
		List<Character> keys = new ArrayList<>();
		int maxDocuments = 0;

		char[][] maze = new char[h + 2][w + 2];
		for (int y = 0; y < w + 2; y++) {
			maze[0][y] = '.';
			maze[h + 1][y] = '.';
		}

		// Skip
		scanner.nextLine();

		for (int x = 0; x < h; x++) {
			String line = scanner.nextLine();

			maze[x + 1][0] = '.';
			maze[x + 1][w + 1] = '.';
			for (int y = 0; y < w; y++) {
				char c = line.charAt(y);
				maze[x + 1][y + 1] = c;

				if (c >= 'A' && c <= 'Z') {
					doors.add(c);
				} else if (c == '$') {
					maxDocuments++;
				}
			}
		}

		String currentKeys = scanner.nextLine();
		for (int i = 0; i < currentKeys.length(); i++) {
			keys.add(currentKeys.charAt(i));
		}

		/*
		 * Runner
		 */
		int documents = 0;

		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(0, 0));
		
		Set<Pos> visited = new HashSet<>();

		Map<Character, List<Pos>> locked = new HashMap<>();
		while (documents < maxDocuments && !queue.isEmpty()) {
			Pos pos = queue.poll();
			visited.add(pos);

			char c = maze[pos.x][pos.y];

			if (c != '*') {
				if (c == '$') {
					documents++;
				} else if (doors.contains(c)) {
					if (keys.contains(Character.toLowerCase(c))) {
						for (Pos n : pos.next(h + 2, w + 2)) {
							if (!visited.contains(n)) {
								queue.add(n);
							}
						}
					} else {
						List<Pos> l = locked.get(c);
						if (l == null) {
							l = new ArrayList<>();
							locked.put(c, l);
						}
						visited.remove(pos);
						l.add(pos);
					}
				} else if (c >= 'a' && c <= 'z') {
					keys.add(c);
					List<Pos> l = locked.get(Character.toUpperCase(c));
					if (l != null) {
						for (Pos n : l) {
							if (!visited.contains(n)) {
								queue.add(n);
							}
						}
					}
				} else {
					for (Pos n : pos.next(h + 2, w + 2)) {
						if (!visited.contains(n)) {
							queue.add(n);
						}
					}
				}
			}
		}

		System.out.println(documents);
	}

	public void run() {
		int cases = scanner.nextInt();
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new Keys().run();
	}

}

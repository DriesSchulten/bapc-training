import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AreaCoverage {

	private Scanner scanner = new Scanner(System.in);

	private class Area {
		long x1;
		long y1;
		long x2;
		long y2;

		public Area(long x1, long y1, long x2, long y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		boolean contains(long cX, long cY) {
			return x1 >= cX && cX <= x2 && y1 >= cY && cY <= y2;
		}
	}

	private void doRun() {
		int count = scanner.nextInt();
		
		long minX = 0L, maxX = 0L, minY = 0L, maxY = 0L;

		List<Area> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			long x1 = scanner.nextLong();
			long y1 = scanner.nextLong();
			long x2 = scanner.nextLong();
			long y2 = scanner.nextLong();
			
			minX = Math.min(minX, x1);
			minY = Math.min(minY, y1);
			maxX = Math.max(maxX, x2);
			maxY = Math.max(maxY, y2);
			
			list.add(new Area(x1, y1, x2, y2));
		}
		
		long counter = 0L;
		for (long x = minX; x <= maxX; x++) {
			for (long y = minY; y <= maxY; y++) {
				for (Area area : list) {
					if (area.contains(x, y)) {
						counter++;
						break;
					}
				}
			}
		}
		
		System.out.println(counter);
	}

	public void run() {
		int cases = scanner.nextInt();
		for (int i = 0; i < cases; i++) {
			doRun();
		}
	}

	public static void main(String[] args) {
		new AreaCoverage().run();
	}
}

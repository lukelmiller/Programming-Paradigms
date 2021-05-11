public class Assignment1 {
	public static void main(String[] args) {
		System.out.println("Counting to 1000 by hundreds...");
		for (int i=1; i<=1000; i++) {
			if ((i % 100) == 0) {
				System.out.printf("Count = %d\n", i);
			}
		}
		System.out.println("Hello world!");
	}
}

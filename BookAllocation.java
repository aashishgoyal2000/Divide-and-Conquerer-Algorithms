import java.util.*;

class BookAllocation {

	public static boolean ifAllocationPossible(int[] pages, int pagesIndex, int students, int lesserThan) {

		int studentUsed = 1;
		int pages_reading = 0;

		for (int i = 0; i < pages.length; i++) {
			if (pages_reading + pages[i] > lesserThan) {
				studentUsed++;
				pages_reading = pages[i];
				if (studentUsed > students) {
					return false;
				}
			}
			else {
				pages_reading += pages[i];
			}
		}
		return true;
	}

	public static int maximizeThemin(int[] pages, int books, int students) {
		
		int sum = 0;
		for (int i = 0; i < books; i++) {
			sum += pages[i];
		}
		int start = pages[books - 1];
		int end = sum;
		int ans = Integer.MAX_VALUE;
		while (start <= end) {
			
			int mid = (start + end) / 2;
			boolean result = ifAllocationPossible (pages, 0, students, mid);
			if (result) {
				ans = Math.min(ans, mid);
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int books = sc.nextInt();
		int students = sc.nextInt();
		int[] pages = new int[books];
		for (int i = 0; i < books; i++) {
			pages[i] = sc.nextInt();
		}
		System.out.println(maximizeThemin(pages, books, students));
	}
}
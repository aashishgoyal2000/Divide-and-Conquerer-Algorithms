import java.util.*;

class PairOfRoses {

	static int a = 0, b = 0, diff = 0;
	static boolean found = false;
	public static void findMinDiff(int[] arr, int element) {

		for (int i = 0; i < arr.length; i++) {
			int required = element - arr[i];
			if (required <= 0) continue;
			int ans = firstOccurrence(arr, arr.length, required, i + 1, arr.length - 1);
			if (ans != -1) {
				if (!found) {
					a = arr[i];
					b = arr[ans];
					diff = Math.abs(arr[i] - arr[ans]);
					found = true;
				}
				else if (Math.abs(arr[i] - arr[ans]) <= diff) {
					a = arr[i];
					b = arr[ans];
					diff = Math.abs(arr[i] - arr[ans]);
				}
			} 
		}
	}

	public static int firstOccurrence(int[] arr, int n, int key, int s, int e) {
		int ans = -1;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == key) {
				ans = mid;
				break;
				// e = mid - 1;
			}
			else if (arr[mid] > key) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		return ans;
	}
/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int pocketMoney = sc.nextInt();

		findMinDiff(arr, pocketMoney);
		System.out.println(a + " " + b);
	}
*/
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int n =sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int pocketMoney = sc.nextInt();
			found = false;
			a = 0;
			b = 0;
			diff = 0;
			findMinDiff(arr, pocketMoney);
			System.out.println("Deepak should buy roses whose prices are " + a + " and " + b + ".");
			t--;
		}

    }
}

/*
import java.util.*;
public class Main {
	static int a = 0, b = 0, diff = 0;
	static boolean found = false;
	public static void findMinDiff(int[] arr, int element) {

		for (int i = 0; i < arr.length; i++) {
			int required = element - arr[i];
			if (required <= 0) continue;
			int ans = firstOccurrence(arr, arr.length, required);
			if (ans != -1) {
				if (!found) {
					a = arr[i];
					b = arr[ans];
					diff = Math.abs(arr[i] - arr[ans]);
					found = true;
				}
				else if (Math.abs(arr[i] - arr[ans]) <= diff) {
					a = arr[i];
					b = arr[ans];
					diff = Math.abs(arr[i] - arr[ans]);
				}
			} 
		}
	}

	public static int firstOccurrence(int[] arr, int n, int key) {
		int s = 0; 
		int e = n - 1;
		int ans = -1;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == key) {
				ans = mid;
				break;
				// e = mid - 1;
			}
			else if (arr[mid] > key) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		return ans;
	}

}

*/
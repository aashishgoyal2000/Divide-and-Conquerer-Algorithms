// first and last occurence of an element in array

import java.util.Scanner;
class BinaryFirstAndLastOccurrence {
	
	public static int firstOccurrence(int[] arr, int n, int key) {
		int s = 0; 
		int e = n - 1;

		int ans = -1;
		// update in a direction that ans values  gets lower and lower

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == key) {
				ans = mid;
				e = mid - 1;
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

	public static int lastOccurence(int[] arr, int n, int key) {
		int s = 0; 
		int e = n - 1;

		int ans = -1;
		// update in a direction that ans values  gets lower and lower

		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == key) {
				ans = mid;
				s = mid + 1;
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1, 2, 5, 8, 8, 8, 8, 8, 10, 12, 15, 20};
		int key = sc.nextInt();

		System.out.println(firstOccurrence(arr, arr.length, key));
		System.out.println(lastOccurence(arr, arr.length, key));

	}
}
import java.util.Scanner;

class BinarySearchInRotatedArray {

	public static int find(int a[], int n, int key) {
		int s = 0; 
		int e = n - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (a[mid] == key) {
				return mid;
			}
			else if (a[s] <= a[mid]) {
				if (key >= a[s] && key <= a[mid]) {
					e = mid - 1;
				}
				else {
					s = mid + 1;
				}
			}
			else {
				if (key >= a[mid] && key <= a[e]) {
					s = mid + 1;
				}
				else {
					e = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int key = sc.nextInt();
		System.out.println(find(arr, n, key));
	}
}
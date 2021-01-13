import java.util.Scanner;

class AlphaScore {

	static long sum = 0;
	static long mod = 1000000007;

	public static void divide(long[] arr, int start, int end) {
		if (end <= start) return;

		int mid = (start + end) / 2;
		divide(arr, start, mid);
		divide(arr, mid + 1, end);

		merge(arr, start, mid, end);
	}

	public static void merge(long[] arr, int start, int mid, int end) {
		long[] temp = new long[end - start + 1];
		int i = start, j = mid + 1, k = 0;

		while (i <= mid && j <= end) {
			if (arr[i] > arr[j]) {
				temp[k] = arr[j];
				j++;
			}
			else {
				temp[k] = arr[i];
				sum = (sum + ((end - j + 1) * arr[i] % mod)) % mod;
				i++;
			}
			k++;
		}
		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		for (i = start; i <= end; i++) {
			arr[i] = temp[i - start];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		divide(arr, 0, arr.length - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.print(sum);
	}
}
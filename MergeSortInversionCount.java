import java.util.Scanner;
class MergeSortInversionCount {
	public static int merge(int[] arr, int start, int mid, int end) {

		int[] temp = new int[end - start + 1];
		
		int i = start, j = mid + 1, k = 0, cnt = 0;
		while (i <= mid && j <= end) {
			if (arr[i] > arr[j]) {
				temp[k] = arr[j];
				cnt += mid - i + 1;
				j++;
			}
			else {
				temp[k] = arr[i];
				i++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			k++;
			j++;
		}

		for (i = start; i <= end; i++) {
			arr[i] = temp[i - start];
		}
		return cnt;
	}

	public static int divide (int[] arr, int start, int end) {
		if (start >= end) {
			return 0;
		} 
		int mid = (start + end) / 2;
		int ans = 0;
		ans += divide(arr, start, mid);
		ans += divide(arr, mid + 1, end);

		ans += merge(arr, start, mid, end);

		return ans;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(divide(arr, 0, arr.length - 1));
			t--;
		}
	}
}
import java.util.Scanner;
class MaxSubArrayDandC {

	public static int divide(int[] arr, int start, int end) {

		if (start >= end) {
			return Integer.MIN_VALUE;
		}

		int mid = (start + end) / 2;

		int leftMax = 0, leftSum = 0;
		for (int i = mid; i >= 0; i--) {
			leftSum += arr[i];
			if (leftSum > leftMax) {
				leftMax = leftSum;
			}
		}
		int rightMax = 0;
		leftSum = 0;
		for (int i = mid + 1; i <= end; i++) {
			leftSum += arr[i];
			if (leftSum > rightMax) {
				rightMax = leftSum;
			}
		}

		int rightLeftSum = rightMax + leftMax;

		return Math.max (Math.max(divide(arr, start, mid), divide(arr, mid + 1, end)), rightLeftSum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(divide(arr, 0, n - 1));
	}
}
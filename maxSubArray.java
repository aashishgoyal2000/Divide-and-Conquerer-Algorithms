import java.lang.Math;
import java.util.Date;
// import java.io.*;
import java.lang.System;
class maxSubArray {
	public static int calSum(int[] arr, int low, int mid, int high) {
		int leftSum = arr[mid];
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		int rightSum = arr[mid + 1];
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}
	public static int divideConquere(int[] arr, int low, int high) {
		if (high <= low) {
			return arr[low];
		}
		int mid = (high + low)/2;
		int leftSum = divideConquere(arr, low, mid);
		int rightSum = divideConquere(arr, mid + 1, high);
		int cross = calSum(arr, low, mid, high);
		if (leftSum >= rightSum && leftSum >= cross) {
			return leftSum;
		} else if (rightSum >= cross && rightSum >= leftSum) {
			return rightSum;
		} else
		return cross;
	} 
	public static int bruteForce(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		int maxSum = sum;
		for (int i = 0; i < n; i++) {
			int sum2 = 0;
			for (int j = 0; j < i; j++) {
				sum2 += arr[j];
			}
			if (sum2 > maxSum) {
				maxSum = sum2;
			}
			int k = 0;
			for (int j = i; j < n; j++) {
				sum2 += arr[j];
				sum2 = sum2 - arr[k];
				k++;
				if (sum2 > maxSum) {
					maxSum = sum2;
				}
			}
		}
		return maxSum;
	}
	public static int effectiveLoop(int[] arr) {
		int n = arr.length;
		int sum = 0;
		int maxSum = arr[0];
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
			} else if(sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	public static void main(String[] args) {
		// while(true) {
			int n = 30;
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int a = (int)(Math.random() * n);
				int b = (int)(Math.random() * n);
				arr[i] = a - b;
			}
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			long t1 = System.nanoTime();
			
			int divide = divideConquere(arr, 0, n - 1);
			long t2 = System.nanoTime();

			int brute = bruteForce(arr);
			long t3 = System.nanoTime();

			int loop = effectiveLoop(arr);
			long t4 = System.nanoTime();
			
			System.out.println("\nDivide and Conquere Recurssive Solution : " + divide + " Time taken : " + (t2 - t1));
			System.out.println("Brute Force with complexity of n*n : " + brute + " Time taken : " + (t3 - t2));
			System.out.println("Effective Loop Method with complexity of n: " + loop + " Time taken : " + (t4 - t3));

		// 	if (divide != brute || divide != loop || brute != loop) {
		// 		break;
		// 	}

		// }
	}

}
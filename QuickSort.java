import java.util.Scanner;

class QuickSort {
	public static int sort (int[] arr, int lo, int hi){
		if (lo >= hi) return 0;
		int pivot = lo + (int)(Math.random() * (hi - lo));
		exch(arr, pivot, lo);
		int i = lo,j = hi + 1;
		while (true) {
			while (arr[++i] < (arr[lo]))
				if (i == hi) break;
			while (arr[--j] > (arr[lo]))
				if (j == lo) break;
			if (i >= j) break;
			exch(arr, i, j);
		}

		exch(arr, lo, j);
		return j;
	}

	public static void exch(int[] arr, int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void divide(int[] arr, int start, int end) {
		if (start >= end) return;

		int partition = sort(arr, start, end);

		divide (arr, start, partition - 1);
		divide (arr, partition + 1, end);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		divide(arr, 0, arr.length - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
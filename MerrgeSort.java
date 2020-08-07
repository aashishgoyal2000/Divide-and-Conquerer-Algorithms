class MerrgeSort {

	public static void conquerer(int[] arr, int start, int mid, int end) {
		// System.out.println();
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] left = new int[n1];
		int[] right = new int[n2 + 1];
		int k = 0;	
		for (int i = start; i <= mid; i++) {
			left[k] = arr[i];
			k++;
		}
		k = 0;
		for (int i = mid + 1; i <= end; i++) {
			right[k] = arr[i];
			k++;
		}
		int i = 0;
		int j = 0;
		k = start;
		while (i < n1 && j < n2) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while ( i < n1 ) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}

		System.out.print("Left Array : ");
		for (i = 0; i < n1; i++) {
			System.out.print(left[i] + " ");
		}
		System.out.print("\tRight Array : ");
		for (i = 0; i < n2; i++) {
			System.out.print(right[i] + " ");
		}
		System.out.println();
	}

	public static void divide(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}	
		int mid = start + (end - start) / 2;
		divide(arr, start, mid);
		divide(arr, mid + 1, end);
		conquerer( arr, start, mid, end);
	}

	public static void MergeSort(int[] arr) {
		divide(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = {4, 2, 9, 5, 8, 11, 3, 1, 15, 13, 10};
		MergeSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
import java.util.Scanner;
class PainterPartitionProblem {

	public static boolean checkForN(long[] arr, int painters, long mid) {

		long sum = 0;
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] <= mid) {
				sum += arr[i];
			}
			else {
				sum = arr[i];
				cnt++;
			}
			if (cnt >= painters) {
				return false;
			}
		}

		return true;


	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int painters = sc.nextInt();
		int boards = sc.nextInt();
		long[] arr = new long[boards];
		long s = Integer.MIN_VALUE;
		long e = 0;
		for (int i = 0; i < boards; i++) {
			arr[i] = sc.nextLong();
			s = Math.max(s, arr[i]);
			e += arr[i];
		}
		long ans = -1;

		while (s < e) {
			long mid = (s + e) / 2;
			boolean canPaint = checkForN(arr, painters, mid);
			if (canPaint) {
				ans = mid;
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		System.out.println(ans);

		
	}
}
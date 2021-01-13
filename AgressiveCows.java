import java.util.Scanner;
class AgressiveCows {
	static boolean canPlaceCows(int[] stalls, int n, int c, int min_sep) {
		int last_cow = stalls[0];
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (stalls[i] - last_cow >= min_sep) {
				last_cow = stalls[i];
				cnt++;
				if (cnt == c) {
					return true;
				}
			}
		}
		return false;
	}
	public static int findMinSeperation(int n, int stalls[], int cows) {
		int s = 0;
		int e = stalls[n - 1] - stalls[0];
		int ans = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			boolean cowRakhPaye = canPlaceCows(stalls, n, cows, mid);
			if (cowRakhPaye) {
				ans = mid;
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int numberOfStalls = sc.nextInt();
			int numberOfCows = sc.nextInt();
			int arr[] = new int[numberOfStalls];
			for (int i = 0; i < numberOfStalls; i++) {
				arr[i] = sc.nextInt();
			}
			int out = findMinSeperation(numberOfStalls, arr, numberOfCows);
			System.out.println(out);
			t--;
		}
	}
}
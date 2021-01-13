import java.util.Scanner;
class SquareRoot {

	public static float findSquareRoot(int n) {

		int s = 0;
		int e = n;
		
		float ans = -1;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (mid * mid == n) {
				return mid;
			}
			else if (mid * mid < n) {
				ans = mid;
				s = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}

		float inc = (float)0.1;
		int places = 2;
		for (int times = 1; times <= places; times++) {
			while (ans * ans <= n) {
				ans += inc;
			}
			ans = ans - inc;
			inc = inc / 10;
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findSquareRoot(n));
	}
}
import java.util.Scanner;
class CBScholarship {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		int i = 1;
		int j = n;
		int ans = -1;
		while (i <= j) {
			int mid = (j + i) / 2;
			int yCoupons = (n - mid) * y;
			// m = m / x;
			yCoupons += m;
			yCoupons = yCoupons / x;

			System.out.println(i + " " + mid + " " + j);

			if (yCoupons >= mid) {
				ans = mid;
				i = mid + 1;
			}
			else {
				j = mid - 1;
			}
			// m = m * x;
			// m -= (n - mid) * y;
		}
		System.out.println(ans);
	}
}
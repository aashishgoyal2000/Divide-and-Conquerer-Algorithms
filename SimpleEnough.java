import java.util.Scanner;
class SimpleEnough {

	public static String numberOfOnes(int n, int a, int b) {
		if (n == 1 || n == 0) {
			return n + "";
		}
		String temp = numberOfOnes(n / 2, a, b);
		return temp + "" + (n % 2) + "" + temp;
 	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		String out = numberOfOnes(n, a, b);
		int cnt = 0;
		for (int i = a; i < b; i++) {
			String temp = out.charAt(i) + "";
			if (out.charAt(i) == '1') {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
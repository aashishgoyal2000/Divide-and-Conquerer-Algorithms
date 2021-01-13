import java.util.Scanner;
class AreTheySame {

	public static boolean compare(String a, String b) {

		if (a.equals(b)) return true;

		if (a.length() % 2 == 0 && b.length() % 2 == 0) {
			String a1 = a.substring(0, a.length() / 2);
			String a2 = a.substring(a.length() / 2, a.length());
			String b1 = b.substring(0, b.length() / 2);
			String b2 = b.substring(b.length() / 2, b.length());
			return (compare(a1, b1) && compare(a2, b2)) || (compare(a1, b2) && compare(a2, b1));
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			
			String a = sc.next();
			String b = sc.next();
			
			boolean res = compare(a, b);

			if (res) System.out.println("YES");
			else System.out.println("NO");
			
			t--;

		}
	}
}
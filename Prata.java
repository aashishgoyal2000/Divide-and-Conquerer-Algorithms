import java.util.*;
class Prata {

	public static boolean checkIfPossible(int[] cooks, int cookNumber, int pratasRequired, int lessarThan) {
		if (pratasRequired <= 0) {
			return true;
		}
		if (cookNumber == cooks.length) {
			return false;
		}
		int sum = 0, r = 1, cnt = 0;
		for (int i = 1; i <= pratasRequired; i++) {
			if (sum + (i * cooks[cookNumber]) <= lessarThan) {
				sum += i * cooks[cookNumber];	
				cnt++;
			}
			else {
				break;
			}
		}
		return checkIfPossible(cooks, cookNumber + 1, pratasRequired - cnt, lessarThan);
	}

	public static int findMinTime(int[] cooks, int numberOfCooks, int pratasRequired) {
		int start = 0, end = 0, minRank = 8;
		for (int i = 0; i < numberOfCooks; i++) {
			minRank = Math.min(minRank, cooks[i]);
		}
		for (int i = 1; i <= pratasRequired; i++) {
			end += minRank * i;
		}
		// System.out.println(end);
		int ans = 0;

		while (start <= end) {
			int mid = (start + end) / 2;
			boolean isPossible = checkIfPossible(cooks, 0, pratasRequired, mid);
			if (isPossible) {
				end = mid - 1;
				ans = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// int t = 1;
		while (t > 0) {
			int pratasRequired = sc.nextInt();
			
			int numberOfCooks = sc.nextInt();
						
			int[] cooks = new int[numberOfCooks];
			for (int i = 0; i < numberOfCooks; i++) {
				cooks[i] = sc.nextInt();
			}
			System.out.println(findMinTime(cooks, numberOfCooks, pratasRequired));
			t--;
		}
	}
}
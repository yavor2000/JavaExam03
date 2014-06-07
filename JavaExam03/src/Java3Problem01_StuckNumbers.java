import java.util.Scanner;


public class Java3Problem01_StuckNumbers {

	static int kk; // klas
	static int n; // elements
	static int[] per;
	static int[] num;
	static boolean[] used;
	static int count = 0;

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			n = input.nextInt();
			num = new int[n];
			for (int i = 0; i < n; i++)
				num[i] = input.nextInt();
		}
		per = new int[n];
		kk = 4;
		used = new boolean[n];
		permute(0);

		if (count == 0)
			System.out.print("No");
	}

	private static void stuckNumbers(int a1, int a2, int a3, int a4) {
		String answ = "";
		if (a1 == a2 || a3==a4)
			return;
		//System.out.println(num[per[0]]+" "+num[per[1]]+" "+num[per[2]]+" "+num[per[3]]);
		if ((""+a1+""+a2).equals(""+a3+""+a4)) {
			answ = "" + a1 + "|" + a2 + "==" + a3 + "|" + a4;
			count++;
			System.out.println(answ);
		}
	}

	public static void permute(int i) {
		if (i >= kk) {
			stuckNumbers(num[per[0]], num[per[1]], num[per[2]], num[per[3]]);
			return;
		}
		for (int k = 0; k < n; k++) {
			if (!used[k]) {
				used[k] = true;
				per[i] = k;
				permute(i + 1);
				used[k] = false;
			}
		}
	}

}

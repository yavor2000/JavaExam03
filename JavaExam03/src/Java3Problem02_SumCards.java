import java.util.Scanner;


public class Java3Problem02_SumCards {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			String[] cards = input.nextLine()
					.replaceAll("[S,H,D,C]", "")
					.replaceAll("J", "12")
					.replaceAll("Q", "13")
					.replaceAll("K", "14")
					.replaceAll("A", "15").split(" ");
			int[] values = new int[cards.length];
			int sum=0;
			for (int i = 0; i < values.length; i++) {
				values[i]=Integer.parseInt(cards[i]);
				sum += values[i];
			}
			if (values.length==1) {
				System.out.println(values[0]);
				return;
			}
			int count=1;
			int element=values[0];
			for (int i = 1; i < values.length; i++) {
				if (values[i]==element)
					count++;
				else if (count>1) {
					sum += element*count;
					element = values[i];
					count=1;
				}
				else element=values[i];
				if ((i== values.length-1)&&count>1) {
					sum += element*count;
				}
			}
			System.out.println(sum);
		}
	}

}

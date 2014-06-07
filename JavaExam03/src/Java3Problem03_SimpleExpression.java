import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;


public class Java3Problem03_SimpleExpression {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("US", "US"));
		BigDecimal sum= new BigDecimal(0);
		try (Scanner input = new Scanner(System.in)) {
			String in = input.nextLine().replaceAll(" ", "").replaceAll("-", " -").replaceAll("\\+", " ");
			String[] data = in.split(" ");
			for (int i = 0; i < data.length; i++) {
				sum = sum.add(BigDecimal.valueOf(Double.parseDouble(data[i])));
			}
			System.out.println(sum.toPlainString());
		}
	}

}

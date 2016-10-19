package tasks.task_07;

import java.util.Scanner;

public class BalancedParentheses {

	public BalancedParentheses() {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		while (input.indexOf("()") != -1 || 
				input.indexOf("[]") != -1 ||
				input.indexOf("{}") != -1
				) {
			input = input.replaceAll("\\(\\)", "");
			input = input.replaceAll("\\[\\]", "");
			input = input.replaceAll("\\{\\}", "");
		}
		if (input.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}

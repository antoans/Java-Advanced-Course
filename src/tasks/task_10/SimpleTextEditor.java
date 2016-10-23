package tasks.task_10;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	public SimpleTextEditor() {
		
		String text = "";
		Stack<String> history = new Stack<>();
		
		//read input
		Scanner sc = new Scanner(System.in);
		int commandsCount = sc.nextInt();
		sc.nextLine();
		
		String[] commands = new String[commandsCount];
		for (int i = 0; i < commandsCount; i++) {
			commands[i] = sc.nextLine().trim();
		}
		sc.close();
		
//		•	1 someString - appends someString to the end of the text
//		•	2 count - erases the last count elements from the text
//		•	3 index - returns the element at position index from the text
//		•	4 - undoes the last not undone command of type 1 / 2 and returns the text to the state before that operation
		for (int i = 0; i < commands.length; i++) {
			String cmd;
			String val;
			String[] data = commands[i].split(" ");
			cmd = data[0];
			val = data.length > 1 ? data[1] : "";
			
			switch (cmd) {
			case "1":
				history.push(text);
				text += val;
				break;
			case "2":
				history.push(text);
				int deleteCount = Integer.parseInt(val);
				int endIndex = text.length() - deleteCount;
				text = text.substring(0, endIndex);
				break;
			case "3":
				int index = Integer.parseInt(val) - 1;
				System.out.println(text.charAt(index));
				break;
			case "4":
				if(!history.isEmpty()) {
					text = history.pop();
				}
				break;
			}
		}

	}
}

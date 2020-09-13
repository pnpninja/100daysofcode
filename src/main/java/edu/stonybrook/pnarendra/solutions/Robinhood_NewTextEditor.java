package edu.stonybrook.pnarendra.solutions;

import java.util.Stack;

public class Robinhood_NewTextEditor {
	public String textOperations(String[] operations) {
		StringBuilder sb = new StringBuilder();
		Stack<String> operrr = new Stack();
		Stack<String> inpStr = new Stack();

		String copy = "";

		for (String str : operations) {
			String[] split = str.split(" ");
			switch (split[0]) {
			case "Insert":
				operrr.push(split[0]);
				inpStr.push(split[1]);
				sb.append(split[1]);
				break;
			case "Delete":
				if (sb.length() != 0) {
					operrr.push(split[0]);
					inpStr.push(String.valueOf(sb.charAt(sb.length() - 1)));
					sb.deleteCharAt(sb.length() - 1);
				}
				break;
			case "Undo":
				if (!operrr.isEmpty()) {
					String lastOp = operrr.pop();
					String laststr = inpStr.pop();
					switch (lastOp) {
					case "Insert":
						sb.delete(sb.length() - laststr.length(), sb.length());
						break;
					case "Delete":
						sb.append(laststr);
						break;
					case "Paste":
						// sb.delete(sb.length() - copy.length(), sb.length());
						sb.delete(sb.length() - laststr.length(), sb.length());
						break;
					// one case is mising here. im sure
					// theres nothing for double undo
					}
				}
				break;
			case "Copy":
				int index = Integer.parseInt(split[1]);
				if (index < sb.length()) {
					copy = sb.substring(index, sb.length());
				} else {
					copy = "";
				}
				break;
			case "Paste":
				if (!copy.equals("")) {
					sb.append(copy);
					operrr.push(split[0]);
					inpStr.push(copy);
				}
				break;
			}
		}
		return sb.toString();

	}
}

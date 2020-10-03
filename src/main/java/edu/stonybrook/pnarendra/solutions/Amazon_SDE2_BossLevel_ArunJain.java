package edu.stonybrook.pnarendra.solutions;

public class Amazon_SDE2_BossLevel_ArunJain {
	
	public String modifyPrice(String input, int discount) {
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			if(!isPriceSymbol(input.charAt(i))){
				temp.append(input.charAt(i));
			}else {
				//Found price symbol - lets get price
				StringBuilder price = new StringBuilder();
				int j = i + 1;
				while( j < input.length() && (Character.isDigit(input.charAt(j)) || input.charAt(j) == ',' || input.charAt(j) == '.')) {
					j++;
				}
				price.append(input.substring(i, j));
				
				String tempPrice = price.toString().replace(",","");
				Double tempPrice2 = Double.parseDouble(tempPrice);
				// Discount it here
				tempPrice2 = tempPrice2 * (100 - discount)/100;
				temp.append(input.charAt(i));
				temp.append(tempPrice2);
				i = j - 1;
					
			}
			
		}
		return temp.toString();
	}
	
	private boolean isPriceSymbol(char charOrSymbol) {
		return charOrSymbol == '$';
	}

}

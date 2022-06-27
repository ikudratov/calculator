package uz.calculator;

public class MyConstructor {
	public boolean countOperands(String string) {
		int count = 0;
		for(int check = 0; check < string.length(); check++) {
			for(Operand operand: Operand.values()) {
				if(string.substring(check, check+1).equals(operand.getTranslation())){
					count++;
				}	
			}
		}
		if(count > 1) {
			return true;
		}
		return false;
	}
	
	public String defineOperand(String string) {
		for(int check = 1; check < string.length(); check++) {
			for(Operand operand: Operand.values()) {
				if(string.substring(check, check+1).equals(operand.getTranslation())){
					return operand.getTranslation();
				}
			}
		}
		return null;
	}
}

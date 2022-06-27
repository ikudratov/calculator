package uz.calculator;

public enum Operand {
	addition("+"), subtraction("-"), multiplication("*"), division("/");
	
	private String translation;

	Operand(String translation) {
		// TODO Auto-generated constructor stub
		this.translation = translation;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	public String toString() {
		return translation;
	}
}

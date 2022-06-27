package uz.calculator;

public class Calculator {

	public static MyConstructor myConstructor = new MyConstructor();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String string = "";
		for(int c = 0; c < args.length; c++) {
			string += args[c];
		}
		String removeSpaces = string.replaceAll(" ", "").toString();
		
		boolean bool = myConstructor.countOperands(removeSpaces);
		if(bool == false) {
			String defineOperand = myConstructor.defineOperand(removeSpaces);
			if(defineOperand!=null) {
				String[] makeSplit = removeSpaces.split("[" + defineOperand + "]");
				try {
					int first = Integer.parseInt(makeSplit[0]);
					int second = Integer.parseInt(makeSplit[1]);
					if(first <= 10 && second <= 10) {
						int result = 0;
						switch(defineOperand) {
							case "+":
								result = first + second;
								System.out.println(result+"");
							break;
							case "-":
								result = first - second;
								System.out.println(result+"");
							break;
							case "*":
								result = first * second;
								System.out.println(result);
							break;
							case "/":
								result = first / second;
								System.out.println(result);
							break;
							default:
								System.out.println("Xatolik ro'y berdi");
						}
					} else {
						System.out.println("Sonlar 10 dan katta bo'lmasligi lozim");
					}
				}catch(NumberFormatException e) {
					try {
						if(!makeSplit[0].matches("-?\\d+(\\.\\d+)?") || !makeSplit[1].matches("-?\\d+(\\.\\d+)?")) {
							System.out.println("Ошибка: Используются одновременно разные системы счисления ");
							System.exit(1);
						}
						int firstRoman = RomanNumber.romanToInteger(makeSplit[0]);
						int secondRoman = RomanNumber.romanToInteger(makeSplit[1]);
						if(firstRoman <= 10 && secondRoman <= 10) {
							int result = 0;
							switch(defineOperand) {
								case "+":
									result = firstRoman + secondRoman;
									System.out.println(new RomanNumber().intToRoman(result)+"");
								break;
								case "-":
									result = firstRoman - secondRoman;
									if(result>=0) {
										System.out.println(new RomanNumber().intToRoman(result)+"");
									}else {
										System.out.println("Ошибка: В римской системе нет отрицательных чисел");
									}
								break;
								case "*":
									result = firstRoman * secondRoman;
									System.out.println(new RomanNumber().intToRoman(result));
								break;
								case "/":
									result = (int)(firstRoman/secondRoman);
									System.out.println(new RomanNumber().intToRoman(result));
								break;
								default:
									System.out.println("Xatolik ro'y berdi");
							}
						} else {
							System.out.println("Sonlar 10 dan katta bo'lmasligi lozim");
						}
					}catch(NumberFormatException e1) {
						System.out.println("Введено неверно формат римские числа.");
					}
				}
			}
		}else {
			throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
		}
	}
}

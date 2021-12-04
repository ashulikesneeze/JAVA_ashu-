package Ashu_recap;

public class method4_arithmetic_operator {

	public static void main(String[] args) {
		int num1 = 11, num2 = 56;
		char op = '/';
		System.out.println("" + num1+op+num2+"="+arithmetic(num1,op,num2));
		System.out.println("" + num1+op+num2+"="+arithmetic2(num1,op,num2));
	}
	
	public static double arithmetic(int num1, char op, int num2) {
		switch(op) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/': return num1 / (double)num2;
		case '%': return num1 % num2;
		default: return 0; 
		}
	}
	public static double arithmetic2(int num1, char op, int num2) {
		double res = 0.0;
		switch(op) {
		case '+': res = num1 + num2;  break;
		case '-': res = num1 - num2;  break;
		case '*': res = num1 * num2;  break;
		case '/': res = num1 / (double)num2;  break;
		case '%': res = num1 % num2;
		}
		return res; 
	}
}

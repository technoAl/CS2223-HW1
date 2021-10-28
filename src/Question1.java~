import java.sql.SQLOutput;
import java.util.Stack;

public class Question1 {
	public static void main(String[] args){
		System.out.println(Stackulator.calculate("( 20 % 4 )"));
	}

	public static class Stackulator{
		
		public static double calculate(String input){

			Stack<String> ops = new Stack<String>();
			Stack<Double> vals = new Stack <Double>();

			int index = 0;
			while(index < input.length()) {
				String s = Character.toString(input.charAt(index));
				if (s.equals("(") || s.equals(" ")) {
					index++;
					continue;
				}
				if (s.equals("+")) {
					ops.push(s);
				} else if (s.equals("-")) {
					ops.push(s);
				} else if (s.equals("*")) {
					ops.push(s);
				} else if (s.equals("/")) {
					ops.push(s);
				} else if (s.equals("s") && input.substring(index, index + 4).equals("sqrt")) {
					ops.push("sqrt");
					index += 3;
				} else if(s.equals("^")){
					ops.push(s);
				} else if(s.equals("%")){
					ops.push(s);
				} else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
					String op = ops.pop();
					double v = vals.pop();
					if (op.equals("+")) {
						v = vals.pop() + v;
					} else if (op.equals("-")) {
						v = vals.pop() - v;
					} else if (op.equals("*")) {
						v = vals.pop() * v;
					} else if (op.equals("/")) {
						v = vals.pop() / v;
					} else if (op.equals("sqrt")) {
						v = Math.sqrt(v);
					} else if (op.equals("%")){
						v = vals.pop() % v;
					} else if (op.equals("^")) {
						v = Math.pow(vals.pop(), v);
					}
					vals.push(v);
				} else {// Token not operator or paren: push double value.
					boolean findEnd = false;
					int count = 1;
					while (input.charAt(index + count) == '.' || input.charAt(index + count) < 10) {
						findEnd = true;
						count++;
						index++;
					}
					if(findEnd){
						vals.push(Double.parseDouble(input.substring(index-1, index+count)));
						index++;
					} else {
						vals.push(Double.parseDouble(s));
					}
				}
				index++;
			}
			return vals.pop();
		}
	}
}

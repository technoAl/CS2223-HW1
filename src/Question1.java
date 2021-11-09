import java.util.Stack;

public class Question1 {
	public static void main(String[] args){
		// Functionality
		System.out.println(Stackulator.calculate("( ( 4 + 1 ) * 3)"));
		System.out.println(Stackulator.calculate("( ( 4 + 1 ) + 343 )"));
		System.out.println(Stackulator.calculate("( ( 4 * 3 ) / 3 ) + 30)"));
		System.out.println(Stackulator.calculate("(27 - (( ( 4 * 3 ) / 3 ) + 30))"));
		System.out.println(Stackulator.calculate("(sqrt( 2 ) + (51 - (( ( 4 * 3 ) / 3 ) + 30)) / 252))"));

		//Failure
		System.out.println(Stackulator.calculate("( 6 ^ 3 ) + ( 7 ^ 3 )"));

		//New Operations
		System.out.println(Stackulator.calculate("(37 % 11)"));
		System.out.println(Stackulator.calculate("( 20 % 4 ) + (5 % 2)"));
		System.out.println(Stackulator.calculate("( 5 ^ 2 )"));
		System.out.println(Stackulator.calculate("(( 6 ^ 3 ) + ( 7 ^ 3 ))"));
	}

	public static class Stackulator{
		
		public static double calculate(String input){

			MyStack<String> ops = new MyStack<String>();
			MyStack<Double> vals = new MyStack <Double>();

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
					while (input.charAt(index + count) == '.' || (Character.getNumericValue(input.charAt(index+count)) >= 0 &&Character.getNumericValue(input.charAt(index+count))  < 10)) {
						findEnd = true;
						count++;
					}
					if(findEnd){
						vals.push(Double.parseDouble(input.substring(index, index+count)));
						index +=count-1;
					} else {
						vals.push(Double.parseDouble(s));
					}

				}
				index++;
			}
			return vals.pop();
		}
	}

	public static class MyStack<T> {
		T[] arr;
		int capacity;
		int size;
		int tailPointer;

		public MyStack(int capacity){
			this.capacity = capacity;
			size = 0;
			tailPointer = 0;
			arr = (T[]) new Object[capacity];
		}

		public boolean push(T e){
			if(size >= capacity){
				return false;
			}

			arr[tailPointer] = e;
			tailPointer++;
			size++;
			return true;
		}

		public T pop(){
			if(size == 0){
				return null;
			}

			T val = arr[tailPointer - 1];
			tailPointer--;
			size--;
			arr[tailPointer - 1] = null; // might be unnecessary

			return val;
		}

	}
}

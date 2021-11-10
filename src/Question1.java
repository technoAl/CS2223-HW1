import java.util.Stack;

public class Question1 {
	public static void main(String[] args){
		// Functionality (These all work!)
		System.out.println(Stackulator.calculate("( ( 4 + 1 ) * 3)"));
		System.out.println(Stackulator.calculate("( ( 4 + 1 ) + 343 )"));
		System.out.println(Stackulator.calculate("( ( 4 * 3 ) / 3 ) + 30)"));
		System.out.println(Stackulator.calculate("(27 - (( ( 4 * 3 ) / 3 ) + 30))"));
		System.out.println(Stackulator.calculate("(sqrt( 2 ) + (51 - (( ( 4 * 3 ) / 3 ) + 30)) / 252))"));

		//Failure (Wrong result)
		System.out.println(Stackulator.calculate("( 6 ^ 3 ) + ( 7 ^ 3 )"));

		//New Operations (^ and % Operators)
		System.out.println(Stackulator.calculate("(37 % 11)"));
		System.out.println(Stackulator.calculate("( 20 % 4 ) + (5 % 2)"));
		System.out.println(Stackulator.calculate("( 5 ^ 2 )"));
		System.out.println(Stackulator.calculate("(( 6 ^ 3 ) + ( 7 ^ 3 ))"));
	}

	public static class Stackulator{
		
		public static double calculate(String input){
			// My Stack used to store operations and values
			MyStack<String> ops = new MyStack<String>(1000);
			MyStack<Double> vals = new MyStack <Double>(1000);

			// Uses an index variable to keep track of spot in string
			int index = 0;
			while(index < input.length()) {
				// Get Current Character
				String s = Character.toString(input.charAt(index));
				// If it's a space or an opening parenthesis then increment and move on
				if (s.equals("(") || s.equals(" ")) {
					index++;
					continue;
				}

				// Deal w/ various operations
				if (s.equals("+")) {
					ops.push(s);
				} else if (s.equals("-")) {
					ops.push(s);
				} else if (s.equals("*")) {
					ops.push(s);
				} else if (s.equals("/")) {
					ops.push(s);

				// Upon getting a sqrt, treat it as one operator and increment index properlyk
				} else if (s.equals("s") && input.substring(index, index + 4).equals("sqrt")) {
					ops.push("sqrt");
					index += 3;
				} else if(s.equals("^")){
					ops.push(s);
				} else if(s.equals("%")){
					ops.push(s);
				} else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
					// Get most recent operator & value
					String op = ops.pop();
					double v = vals.pop();

					// Apply operation
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
				} else {// Token not operator, push double value.
					boolean findEnd = false;

					// Used to loop through and convert the entire number
					// If the next character after a number is a decimal point or a number keep looking
					int count = 1;
					while (input.charAt(index + count) == '.' || (Character.getNumericValue(input.charAt(index+count)) >= 0 &&
							Character.getNumericValue(input.charAt(index+count))  < 10)) {
						findEnd = true;
						count++;
					}

					// If the number had more than one digit, convert the entire thing and push it
					if(findEnd){
						vals.push(Double.parseDouble(input.substring(index, index+count)));
						index +=count-1;

					// If the number is just one digit, push it normally
					} else {
						vals.push(Double.parseDouble(s));
					}

				}
				// Increment the index
				index++;
			}

			// Pop at the end
			return vals.pop();
		}
	}

	// My preferred implementation of Stack
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

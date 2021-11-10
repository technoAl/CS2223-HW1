public class Question3 {
	public static void main(String[] args) {
		// Tests for n = 100000

		long startTime = System.currentTimeMillis();
		long sum = linearFunction(100000);
		long endTime = System.currentTimeMillis();
		System.out.println("Millis of Linear Function: " + (endTime-startTime));

		startTime = System.currentTimeMillis();
		long sum2 = quadraticFunction(100000);
		endTime = System.currentTimeMillis();
		System.out.println("Millis of Quadratic Function: " + (endTime-startTime));

		startTime = System.currentTimeMillis();
		long sum3 = cubicFunction(100000);
		endTime = System.currentTimeMillis();
		System.out.println("Millis of Cubic Function: " + (endTime-startTime));
	}

	// Linear addition
	public static long linearFunction(int n){
		long ops = 0;
		for(int i = 0; i < n; i++){
			ops ++;
		}
		return ops;
	}

	// Addition in a double loop
	public static long quadraticFunction(int n){
		long ops = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				ops ++;
			}
		}
		return ops;
	}

	// Addition in a triple loop
	public static long cubicFunction(int n){
		long ops = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					ops++;
				}
			}
		}
		return ops;
	}

}

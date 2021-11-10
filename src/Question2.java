import java.util.Random;
import java.util.stream.IntStream;

public class Question2 {

	public static int linearSearchOps = 0;
	public static int binarySearchOps = 0;
	public static int ternarySearchOps = 0;
	public static int linearSearchSteps = 0;
	public static int binarySearchSteps = 0;
	public static int ternarySearchSteps = 0;

	public static void main(String[] args) {
		// Tests
		int[] results = runTest(0, 1000, 100, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 100 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 1000, 100, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 100 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 1000, 100, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 100 is %d ops & %d steps.\n", results[0], results[1]);
		results = runTest(0, 1000, 1000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 1000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 1000, 1000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 1000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 1000, 1000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 1000 is %d ops & %d steps.\n", results[0], results[1]);
		results = runTest(0, 1000, 10000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 10000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 1000, 10000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 10000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 1000, 10000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 10000 is %d ops & %d steps.\n", results[0], results[1]);
		results = runTest(0, 1000, 100000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 100000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 1000, 100000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 100000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 1000, 100000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 100000 is %d ops & %d steps.\n", results[0], results[1]);
		results = runTest(0, 1000, 1000000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 1000000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 1000, 1000000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 1000000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 1000, 1000000, 1000000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 1000000 is %d ops & %d steps.\n", results[0], results[1]);
	}

	/* Steps vs. Ops counters in my code
	   - I chose to measure both the operations and the steps in these algorithms because I wanted to show a more fair comparison between binary & ternary sort.
	   - Steps - "Iterations" For example, each time binary search split the array in half and moved on the next iteration is a step
	   - Ops - "Comparisons" For example, each time a compare occured in binary search (1 op to check if middle is target, another to compare greater or less than)
	   - I decided to do this because binary vs. ternary search is an interesting question
	   - Ternary search runs log_3(n) steps or iterations, which is less than that of binary search which is log_2(n)
	   - However to do this, Ternary search will require more operations/comparisons than binary search per iteration
	   - For this reason binary search is faster and preferred to ternary search, and only using a simple step counter would not show this fact
	   - Therefore, in the PDF there will be 2 graphs showing this phenomona, and how ternary search on average requires much more comparisons/operations

	 */

	// Linear Search Implementation
	public static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			linearSearchOps++;
			linearSearchSteps++;
			if (target == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	// Binary Search Implementation
	public static int binarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			binarySearchSteps++; // Each iteration, another step occurs
			int mid = (lo + hi) / 2;
			if (arr[mid] == target) {
				binarySearchOps++; // If this code is run, only one comparison occurred
				return mid;
			} else if (target < arr[mid]) {
				binarySearchOps+=2; // If this code is run, two comparisons occurred
				hi = mid - 1;
			} else {
				binarySearchOps+=2; // If this code is run, two comparisons occurred
				lo = mid + 1;
			}
		}
		return -1;
	}

	// Ternary Search Implementation (Variation of Binary Sort)
	public static int ternarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			ternarySearchSteps++; // Iterations/Steps
			int mid1 = lo + (hi - lo) / 3;
			int mid2 = lo + (hi - lo) * 2 / 3;

			if (arr[mid1] == target) {
				ternarySearchOps++; // One Comparison
				return mid1;
			} else if (arr[mid2] == target) {
				ternarySearchOps+=2; // Two Comparisons
				return mid2;
			} else if (target < arr[mid1]) {
				ternarySearchOps+=3; // Three Comparisons
				hi = mid1 - 1;
			} else if (target < arr[mid2]) {
				ternarySearchOps+=4; // Four Comparisons
				hi = mid2 - 1;
				lo = mid1+1;
			} else {
				ternarySearchOps+=4; // Four Comparisons
				lo = mid2+1;
			}
		}
		return -1;
	}

	// Generates an array of specified size
	public static int[] generate(int n, int maxIntSize) {
		return IntStream.generate(() -> new Random().nextInt(maxIntSize)).limit(n).toArray();
	}

	// Computes the average runtime ops & steps of any search w/ size n over any number of iterations
	public static int[] runTest(int searchType, int iterations, int n, int maxIntSize) {
		int sum = 0; // Sum of Ops
		int stepSum = 0; // Sum of Steps
		Random randy = new Random();
		int[] searchIn = generate(n, maxIntSize); // Generate a random array
		for(int i = 0; i < iterations; i++) { // Run this for any specified number of operations
			int targetInt = randy.nextInt(maxIntSize); // Generate a random value to search for
			if(searchType == 0){ // Linear Search
				linearSearchOps = 0;
				linearSearchSteps = 0;
				int sol = linearSearch(searchIn, targetInt);
				sum+=linearSearchOps;
				stepSum+=linearSearchSteps;
			} else if(searchType == 1){ // Binary Search
				binarySearchOps = 0;
				binarySearchSteps = 0;
				int sol = binarySearch(searchIn, targetInt);
				sum+=binarySearchOps;
				stepSum += binarySearchSteps;
			} else { // Ternary Search
				ternarySearchOps = 0;
				ternarySearchSteps = 0;
				int sol = ternarySearch(searchIn, targetInt);
				sum+= ternarySearchOps;
				stepSum+=ternarySearchSteps;
			}

		}
		return new int[]{sum / iterations, stepSum / iterations}; // return average ops & average steps in an array
	}
}

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
		int[] results = runTest(0, 100, 1000, 10000);
		System.out.format("Average Ops & Steps over 100 tests of linear search for an array of size 1000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(1, 100, 1000, 10000);
		System.out.format("Average Ops & Steps over 100 tests of binary search for an array of size 1000 is %d ops & %d steps.\n",  results[0], results[1]);
		results = runTest(2, 100, 1000, 10000);
		System.out.format("Average Ops & Steps over 100 tests of ternary search for an array of size 1000 is %d ops & %d steps.\n", results[0], results[1]);
	}

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

	public static int binarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			binarySearchSteps++;
			int mid = (lo + hi) / 2;
			if (arr[mid] == target) {
				binarySearchOps++;
				return mid;
			} else if (target < arr[mid]) {
				binarySearchOps+=2;
				hi = mid - 1;
			} else {
				binarySearchOps+=2;
				lo = mid + 1;
			}
		}
		return -1;
	}

	public static int ternarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			ternarySearchSteps++;
			int mid1 = lo + (hi - lo) / 3;
			int mid2 = lo + (hi - lo) * 2 / 3;

			if (arr[mid1] == target) {
				ternarySearchOps++;
				return mid1;
			} else if (arr[mid2] == target) {
				ternarySearchOps+=2;
				return mid2;
			} else if (target < arr[mid1]) {
				ternarySearchOps+=3;
				hi = mid1 - 1;
			} else if (target < arr[mid2]) {
				ternarySearchOps+=4;
				hi = mid2 - 1;
				lo = mid1+1;
			} else {
				ternarySearchOps+=4;
				lo = mid2+1;
			}
		}
		return -1;
	}

	public static int[] generate(int n, int maxIntSize) {
		return IntStream.generate(() -> new Random().nextInt(maxIntSize)).limit(n).toArray();
	}

	public static int[] runTest(int searchType, int iterations, int n, int maxIntSize) {
		int sum = 0;
		int stepSum = 0;
		Random randy = new Random();
		int[] searchIn = generate(n, maxIntSize);
		for(int i = 0; i < iterations; i++) {
			int targetInt = randy.nextInt(maxIntSize);
			if(searchType == 0){
				linearSearchOps = 0;
				linearSearchSteps = 0;
				int sol = linearSearch(searchIn, targetInt);
				sum+=linearSearchOps;
				stepSum+=linearSearchSteps;
			} else if(searchType == 1){
				binarySearchOps = 0;
				binarySearchSteps = 0;
				int sol = binarySearch(searchIn, targetInt);
				sum+=binarySearchOps;
				stepSum += binarySearchSteps;
			} else {
				ternarySearchOps = 0;
				ternarySearchSteps = 0;
				int sol = ternarySearch(searchIn, targetInt);
				sum+= ternarySearchOps;
				stepSum+=ternarySearchSteps;
			}

		}
		return new int[]{sum / iterations, stepSum / iterations}; // average ops per search
	}
}

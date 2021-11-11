import java.util.Random;

public class Question5 {
	public static void main(String[] args) {
		System.out.format("The Operations for BubbleSort of 100 elements averages %d over 100 tests run.\n", runTestSorting(0, 1000, 100, 1000000));
		System.out.format("The Operations for MergeSort of 100 elements averages %d over 100 tests run.\n", runTestSorting(1, 1000, 100, 1000000));
		System.out.format("The Operations for QuickSort of 100 elements averages %d over 100 tests run.\n", runTestSorting(2, 1000, 100, 1000000));
		System.out.format("The Operations for BubbleSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(0, 1000, 1000, 1000000));
		System.out.format("The Operations for MergeSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(1, 1000, 1000, 1000000));
		System.out.format("The Operations for QuickSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(2, 1000, 1000, 1000000));
		System.out.format("The Operations for BubbleSort of 10000 elements averages %d over 100 tests run.\n", runTestSorting(0, 100, 10000, 1000000));
		System.out.format("The Operations for MergeSort of 10000 elements averages %d over 100 tests run.\n", runTestSorting(1, 1000, 10000, 1000000));
		System.out.format("The Operations for QuickSort of 10000 elements averages %d over 100 tests run.\n", runTestSorting(2, 1000, 10000, 1000000));
		System.out.format("The Operations for BubbleSort of 100000 elements averages %d over 100 tests run.\n", runTestSorting(0, 10, 100000, 1000000));
		System.out.format("The Operations for MergeSort of 100000 elements averages %d over 100 tests run.\n", runTestSorting(1, 1000, 100000, 1000000));
		System.out.format("The Operations for QuickSort of 100000 elements averages %d over 100 tests run.\n", runTestSorting(2, 1000, 100000, 1000000));
		System.out.format("The Operations for BubbleSort of 1000000 elements averages %d over 100 tests run.\n", runTestSorting(0, 1, 1000000, 1000000));
		System.out.format("The Operations for MergeSort of 1000000 elements averages %d over 100 tests run.\n", runTestSorting(1, 1000, 1000000, 1000000));
		System.out.format("The Operations for QuickSort of 1000000 elements averages %d over 100 tests run.\n", runTestSorting(2, 1000, 1000000, 1000000));
	}

	/* Operations - Placement
	 - Using the comparison metric to define each operation (1 comparison = 1 op)
	 - Observations
	 	- My partition algorithm in quicksort always does a comparison for every index it loops through (between hi & lo)
		- My mergesort can skip comparisons for every index between hi & lo if one of the two merged arrays runs out of elmeents before the other when merging
		- Based on these observation & looking at the data, ths imperfect metric of comparisons favors mergesort
		- Obviously mergesort has other issues like memory, which this metric skips, but from a pure comparison standpoint, it looks better

	 */

	// Sorting Run Tester (Same premise as code from Problem 2)
	public static long runTestSorting(int searchType, int iterations, int n, int maxIntSize) {
		long sum = 0;
		for(int i = 0; i < iterations; i++) {
			int[] searchIn = Question2.generate(n, maxIntSize);
			if(searchType == 0){
				BubbleSortQ5 sort = new BubbleSortQ5(searchIn);
				sort.sort();
				sum+=sort.ops;
			} else if(searchType == 1){
				MergeSortQ5 sort = new MergeSortQ5(searchIn);
				sort.sort();
				sum+=sort.ops;
			} else {
				QuickSortQ5 sort = new QuickSortQ5(searchIn);
				sort.sort();
				sum+=sort.ops;
			}
		}
		return sum/ ((long)iterations); // average ops per search
	}
}

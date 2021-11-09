import java.util.Random;

public class Question5 {
	public static void main(String[] args) {
		System.out.format("The Operations for BubbleSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(0, 100, 1000, 10000));
		System.out.format("The Operations for MergeSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(1, 100, 1000, 10000));
		System.out.format("The Operations for QuickSort of 1000 elements averages %d over 100 tests run.\n", runTestSorting(2, 100, 1000, 10000));
	}


	public static int runTestSorting(int searchType, int iterations, int n, int maxIntSize) {
		int sum = 0;
		Random randy = new Random();
		for(int i = 0; i < iterations; i++) {
			int[] searchIn = Question2.generate(n, maxIntSize);
			int targetInt = randy.nextInt(maxIntSize);
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
		return sum/iterations; // average ops per search
	}
}

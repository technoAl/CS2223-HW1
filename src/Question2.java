public class Question2 {

	public static int linearSearchOps = 0;
	public static int binarySearchOps = 0;
	public static int ternarySearchOps = 0;

	public static void main(String[] args) {

	}

	public int linearSearch(int[] arr, int target){
		for(int i = 0; i < arr.length; i++){
			linearSearchOps++;
			if(target == arr[i]){
				return i;
			}
		}
		return -1;
	}

	public int binarySearch(int[] arr, int target){
		int lo = 0;
		int hi = arr.length-1;

		while(lo < hi){
			binarySearchOps++;
			int mid = (lo + hi)/2;
			if(arr[mid] == target){
				return mid;
			} else if(arr[mid] > target){
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	public int ternarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length-1;
		while(lo < hi){
			ternarySearchOps++;
			int mid1 = (lo+hi)/3;
			int mid2 = (lo+hi) * 2 / 3;

			if(arr[mid1] == target){
				return mid1;
			} else if(arr[mid2] == target){
				return mid2;
			} else if (target < arr[mid1]) {
				hi = mid1 - 1;
			} else if(target < arr[mid2]){
				hi = mid2 - 1;
				lo = mid1 + 1;
			} else {
				lo = mid2 + 1;
			}
		}
		return -1;
	}
}

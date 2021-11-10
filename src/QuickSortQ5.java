public class QuickSortQ5 {
	int[] arr;
	int ops;

	public QuickSortQ5(int[] arr){ // Constructor
		this.arr = arr;
	}

	public void sort(){
		sort(0, arr.length-1);
	}

	public void sort(int lo, int hi) { // Partition, then sort 2 halves around partition
		if(lo < hi){
			int partitionPoint = partition(lo, hi);

			sort(lo, partitionPoint-1);
			sort(partitionPoint+1, hi);
		}
	}

	public int partition(int lo, int hi){ // Implementation uses last element as pivot (approach I was most familiar with)
		int pivot = arr[hi];

		// Loop from lo to hi, and any value < pivot gets swapped to the first half of the array in the next unused spot
		int k = lo; // stores index of next unused spot
		for(int i = lo; i < hi; i++){
			ops++; // One comparison per loop iteration
			if(arr[i] < pivot){
				swap(k, i);
				k++;
			}
		}

		swap(k, hi); // Swap pivot into center
		return k;
	}


	public void swap(int a, int b){ // Swap
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

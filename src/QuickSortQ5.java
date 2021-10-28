public class QuickSortQ5 {
	int[] arr;
	int ops;

	public QuickSortQ5(int[] arr){
		this.arr = arr;
	}

	public void sort(){
		sort(0, arr.length-1);
	}

	public void sort(int lo, int hi) {
		if(lo < hi){
			int partitionPoint = partition(lo, hi);

			sort(lo, partitionPoint);
			sort(partitionPoint+1, hi);
		}
	}

	public int partition(int lo, int hi){
		int pivot = arr[hi];

		int k = lo;
		for(int i = lo; i < hi+1; i++){
			ops++;
			if(arr[i] < pivot){
				swap(k, i);
				k++;
			}
		}

		swap(k, hi);
		return k;
	}


	public void swap(int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

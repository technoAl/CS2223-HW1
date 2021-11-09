public class MergeSortQ5 {
	int[] arr;
	int ops;
	public MergeSortQ5(int[] arr){
		this.arr = arr;
	}

	public void sort(){
		sort(0, arr.length-1);
	}

	public void sort(int lo, int hi){
		if(lo < hi){
			sort(lo, (lo + hi)/2);
			sort((lo+hi)/2 + 1, hi);

			merge(lo, hi);
		}
	}

	public void merge(int lo, int hi){
		int mid = (lo+hi)/2;

		int[] l = new int[mid - lo + 1];
		int[] r = new int[hi - (mid+1) + 1];

		for(int i = 0; i < mid-lo+1; i++){
			l[i] = arr[lo+i];
		}

		for(int i = 0; i < hi - (mid+1) + 1; i++){
			r[i] = arr[mid+1 + i];
		}

		int i = 0, j = 0;
		int k = lo;
		while(i < mid - lo + 1 && j < hi - (mid+1) + 1){
			ops++;
			if(l[i] < r[j]){
				arr[k] = l[i];
				i++;
			} else if(l[i] >= r[j]){
				arr[k] = r[j];
				j++;
			}
			k++;
		}

		while(i < mid - lo + 1){
			ops++;
			arr[k] = l[i];
			i++;
			k++;
		}

		while(j < hi - (mid+1) + 1){
			ops++;
			arr[k] = r[j];
			j++;
			k++;
		}
	}
}

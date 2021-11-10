public class MergeSortQ5 {
	int[] arr;
	int ops;
	public MergeSortQ5(int[] arr){ // Constructor
		this.arr = arr;
	}

	public void sort(){ // Sort
		sort(0, arr.length-1);
	}

	public void sort(int lo, int hi){ // Sort two halves, then merge
		if(lo < hi){
			sort(lo, (lo + hi)/2);
			sort((lo+hi)/2 + 1, hi);

			merge(lo, hi);
		}
	}

	public void merge(int lo, int hi){ // Merge Operation
		int mid = (lo+hi)/2; // Calculate midpoint

		int[] l = new int[mid - lo + 1]; // Inclusive of midpoint
		int[] r = new int[hi - (mid+1) + 1]; // Uninclusive of midpoint

		for(int i = 0; i < mid-lo+1; i++){ // Copy elements into left array
			l[i] = arr[lo+i];
		}

		for(int i = 0; i < hi - (mid+1) + 1; i++){ // Copy elements into right array
			r[i] = arr[mid+1 + i];
		}

		// Begin merge process
		int i = 0, j = 0;
		int k = lo;
		while(i < mid - lo + 1 && j < hi - (mid+1) + 1){ //While i & j are in bounds of each array
			ops++; // One comparison per iteration of the loop
			if(l[i] < r[j]){ // if left < right element, then put it into place
				arr[k] = l[i];
				i++;
			} else if(l[i] >= r[j]){ // Vice versa
				arr[k] = r[j];
				j++;
			}
			k++;
		}

		// Copy in any left over values from arrays
		while(i < mid - lo + 1){
			arr[k] = l[i];
			i++;
			k++;
		}

		while(j < hi - (mid+1) + 1){
			arr[k] = r[j];
			j++;
			k++;
		}
	}
}

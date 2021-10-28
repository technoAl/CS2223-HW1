
public class BubbleSortQ5 {

	int[] arr;
	int ops;
	public BubbleSortQ5(int[] arr){
		this.arr = arr;
	}

	public void sort(){
		for(int i = 0; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 1; j < arr.length; j++) {
				ops++;
				if (arr[j] < arr[j - 1]) {
					swap(j, j - 1);
					swapped = true;
				}
			}
			if(!swapped){
				break;
			}
		}
	}

	public void swap(int a, int b){
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}

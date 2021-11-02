public class Question3 {
	public static void main(String[] args) {

	}
	public int linearFunction(int n){
		int ops = 0;
		for(int i = 0; i < n; i++){
			ops ++;
		}
		return ops;
	}

	public int quadraticFunction(int n){
		int ops = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				ops ++;
			}
		}
		return ops;
	}

	public int cubicFunction(int n){
		int ops = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					ops++;
				}
			}
		}
		return ops;
	}

}

package arch;

public class SelectSort2 {
	public static void main(String[] args) {
		int[] arr = {5,9,10,34,2,4,88,99,1,3};
		
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j=i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
	}
}

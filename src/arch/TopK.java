package arch;

/**
 * 从arr[1, n]这n个数中，找出最大的k个数
 *
 */
public class TopK {
	
	/** 找出最大的5个 */
	private static int [] arr = {5,3,7,1,8,2,9,4,7,2,6,6};
	
	public static void main(String[] args) {
//		sort();
		sortK();
	}
	
	/**
	 * 堆排序
	 */
	public static void sortHeap( ) {
		print(arr);
		//前k位建堆
	}
	
	/**
	 * sort K个数就好，时间复杂度 O(n*k)
	 */
	public static void sortK() {
		print(arr);
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i] < arr[j]) {
					int tmp = arr[i];
					arr [i] = arr[j];
					arr[j] = tmp;
				}
			}
			if (i == 4) {
				break;
			}
		}
		print(arr);
	}
	
	/**
	 * sort之后取最大的五位，时间复杂度 O(n*lg(n))
	 */
	public static void sort() {
		print(arr);
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i] < arr[j]) {
					int tmp = arr[i];
					arr [i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		print(arr);
	}
	
	private static void print(int [] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<arr.length;i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}

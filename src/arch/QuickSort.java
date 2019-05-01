package arch;

public class QuickSort {
	
	public static void quick(int [] arr,int low,int high) {
		// 如果low>high则返回，避免无限递归
		if(low>high){
            return;
        }
		
		int i,j,tmp,t;
		i = low;
		j = high;
		// tmp就是基准，数组中就是5，第一次排序后变成  2,3,1,4,5,34,88,99,10,9
		// 第二次以5分割，左边是小于5的进行排序，右边大于5的进行排序，以此递归
		tmp = arr[low];
		while (i<j) {
			// 先移动右边的，如果大于5则继续往左移动，直到找到小于5的则移动左边。
			while (tmp <= arr[j] && i<j) {
				j--;
			}
			// 如果小于5，则接着往右移动，找出左边大于5的
			while (tmp >= arr[i] && i<j) {
				i++;
			}
			// 再交换两个数字，然后继续移动
			if (i<j) {
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		
		// 当i和j到达同一后，将基准数字5和该位置数字交换
		arr[low] = arr[i];
		arr[i] = tmp;
		
		// 再以基准数字分成两个数组分别移动和排序
		quick(arr, low, j-1);
		quick(arr, j+1, high);
	}
	
	public static void main(String[] args) {
		int[] arr = {5,9,10,34,2,4,88,99,1,3};
		quick(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
	}
}

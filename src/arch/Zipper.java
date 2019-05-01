package arch;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 拉链法求两个有序列表的交集
 */
public class Zipper {
	
	public static void main(String[] args) {
		
		int [] arr1 = {1,3,5,7,8,9};
		int [] arr2 = {2,3,4,5,6,7};
		
		List<Integer> list = new ArrayList<Integer>();
		
		int i = 0,j = 0;
		while (i < arr1.length-1 || j < arr2.length-1) {// 小于数组长度时，移动指针
			if (i == arr1.length || j==arr2.length) { // 有序数组，当一个数组移动完了，则退出
				break;
			}
			if (arr1[i] == arr2[j]) { // 当两个值相等时，加到交集中，并且指针都往前移一位
				list.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] > arr2[j]) { // 每次都移动数值小的那个指针
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			}
		}
		
		for(Integer n:list) {
			System.out.print(n+",");
		}
	}
	
}

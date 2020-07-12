package suanfa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ErFenTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,55,23,21,12);
		Collections.sort(list);
		
		int value = 55;
		int low = 0;
		int high = list.size();
		int middle = 0;
		while (true) {
			middle = (low + high) /2;
			if (list.get(middle) == value) {
				System.out.print(middle);
				return;
			} else if (list.get(middle) > value) {
				high = middle -1; //猜的数字大了
			} else if (list.get(middle) < value) {
				low = middle + 1;
			}
		}
	}
}

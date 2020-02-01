package arch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
//		for(String s:list) { //报错
//			if("3".equals(s)) {
//				list.add("6");
//			}
//		}
		
//		for (int i=0;i<list.size();i++) { //正常
//			if ("3".equals(list.get(i))) {
//				list.add("6");
//			}
//		}
		
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) { //报错
			String s = iterator.next();
			if ("3".equals(s)) {
				list.add("6");
			}
		}
		
		for (String s: list) {
			System.out.print(s+",");
		}
	}
}

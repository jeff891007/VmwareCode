package jeff;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CollectionMergeSortTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<Integer> l1 = new ArrayList<>();
		l1.add(Integer.valueOf(1));
		l1.add(Integer.valueOf(3));
		l1.add(Integer.valueOf(5));
		l1.add(Integer.valueOf(7));
		l1.add(Integer.valueOf(9));
		l1.add(Integer.valueOf(11));
		
		
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(Integer.valueOf(2));
		l2.add(Integer.valueOf(4));
		l2.add(Integer.valueOf(6));
		l2.add(Integer.valueOf(8));
		l2.add(Integer.valueOf(10));
		l2.add(Integer.valueOf(12));
		
		
		List<Integer> result = CollectionMergeSort.merge(l1, l2);
		
		System.out.println(result);
		
		
		
	}
	

}

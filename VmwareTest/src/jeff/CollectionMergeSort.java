package jeff;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/***
 * 
 * @author JEFF
 * - Collections:  
Write a java merge class that will merge two sorted collections of the same kind into a 
single sorted collection. You need to think of how to design 
this class in a generic form and efficiently.
 *
 */
public class CollectionMergeSort {
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Collection> T merge(T collection1, T collection2) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		if(collection1 == null || collection2 == null) {
			throw new RuntimeException("null parameter is not allowed  for this method");
		}
		
		
		Constructor conStru  = collection1.getClass().getConstructor();
		T result = (T) conStru.newInstance();
		Iterator<Comparable> it1 = collection1.iterator();
		Iterator<Comparable> it2 = collection2.iterator();
		
		Comparable obj1 = it1.next();
		Comparable obj2 = it2.next();
		
		
		while(obj1 != null && obj2 != null) {
			
			if(obj1.compareTo(obj2) <= 0) {
				result.add(obj1);
				if(it1.hasNext()) {
					obj1 = it1.next();
				} else {
					obj1 = null;
				}
			} else  {
				result.add(obj2);
				if(it2.hasNext()) {
					obj2 = it2.next();
				} else {
					obj2 = null;
				}
			}
		}
		
		
		if(obj1 != null) {
			while(it1.hasNext()) {
				result.add(obj1);
				obj1 = it1.next();
			}
			result.add(obj1);
		}
		
		
		if(obj2 != null){
			while(it2.hasNext()) {
				result.add(obj2);
				obj2 = it2.next();
			}
			result.add(obj2);
		}
		
		
		return result;
		
	}
}



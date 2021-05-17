package jeff;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 
 * @author JEFF
 *Use java concurrency packages to write a queue that supports multi-writer and multi-reader, 
 *i.e. the writer pushes the stuff into the queue and the reader pops the stuff out the queue. 
 *All the writer's stuff can't be lost and must be into the queue, and each reader can't 
 *pops out the same stuff. Think of how you would simulate the situation and perform 
 *the testing. Using the java blocking queue is not allowed.
 *
 *
 */
public class ConcurrentQueue<T> {
	
	
	
	
	
	LinkedList<T> linkedList = new LinkedList<>();
	
	private final ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	
	private int MAX_SIZE = Integer.MAX_VALUE;
	
	
	public ConcurrentQueue() {
	}
	
	public ConcurrentQueue(int maxSize) {
		this.MAX_SIZE = maxSize;
	}
	
	
	public T read() {
		if(!lock.isHeldByCurrentThread()) {
			lock.lock();
		}
		try {
			while(linkedList.size() == 0) {
					notEmpty.await();
			}
			T result = linkedList.pollFirst();
			notFull.signal();
			return result;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			lock.unlock();
		}
	}
	
	
	public boolean write(T element) {
		if(!lock.isHeldByCurrentThread()) {
			lock.lock();
		}
		try {
			while(linkedList.size() == MAX_SIZE) {
					notFull.await();
			}
			linkedList.addLast(element);
			notEmpty.signal();
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} finally {
			lock.unlock();
		}
	}
	
	

}

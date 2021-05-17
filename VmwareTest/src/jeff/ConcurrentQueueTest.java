package jeff;

public class ConcurrentQueueTest {
	
	public static void main(String[] args) {
		
		consumerSleep();
		
	}
	
	
	private static void producerSleep() {
			ConcurrentQueue<Integer> q = new ConcurrentQueue<>();
				
			Thread consumer = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 10; i++) {
						System.out.println(q.read());
					}
				}
			});
			
			
			Thread producer = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 10; i++) {
						try {
							Thread.sleep(100);
							q.write(Integer.valueOf(i));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			});
			consumer.start();
			producer.start();
	}
	
	
	private static void consumerSleep() {
		ConcurrentQueue<Integer> q = new ConcurrentQueue<>(2);
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						Thread.sleep(2000);
						System.out.println(q.read());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		
		Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
						q.write(Integer.valueOf(i));
					
				}
			}
		});
		
		
		
		
		consumer.start();
		producer.start();
	}
	
	
	private static void multiThreadGo() {
		ConcurrentQueue<Integer> q = new ConcurrentQueue<>(2);
		
		
		for(int i =  0; i < 20; i++) {
			Thread consumer = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(q.read());
				}
			});
			consumer.setName("consumer" + i);
			consumer.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i =  0; i < 10; i++) {
			Thread producer = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 10; i++) {
						q.write(Integer.valueOf(i));
						
					}
				}
			});
			producer.setName("producer" + i);
			producer.start();
		}
		
		
		
		
		
		
		
	}
}

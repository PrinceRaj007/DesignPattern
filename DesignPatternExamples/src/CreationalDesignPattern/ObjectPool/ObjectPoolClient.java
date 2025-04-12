package CreationalDesignPattern.ObjectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPoolClient {

	public static void main(String[] args) throws InterruptedException {
		ObjectPool pool = new ObjectPool(2);
		ExpensiveObject obj1 = pool.getObjectFromPool();
		obj1.doWork();
		System.out.println(obj1);
		ExpensiveObject obj2 = pool.getObjectFromPool();
		obj2.doWork();
		System.out.println(obj2);
		pool.returnObjectToPool(obj1);
		pool.returnObjectToPool(obj2);
		ExpensiveObject obj3 = pool.getObjectFromPool();
		obj3.doWork();
		System.out.println(obj3);
	}

}
class ExpensiveObject{
	public void doWork() {
		System.out.println("Expensive Object doing WORK !!");
	}
}
class ObjectPool{
	BlockingQueue<ExpensiveObject> queue ;//= new LinkedBlockingQueue<>();
	ObjectPool(int size){
		queue = new LinkedBlockingQueue<>();
		for(int i=0;i<size;i++) {
			queue.offer(new ExpensiveObject());
		}
	}
	public ExpensiveObject getObjectFromPool() throws InterruptedException{
		return queue.take();
	}
	public void returnObjectToPool(ExpensiveObject obj) {
		queue.offer(obj);
	}
}
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncedQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    
    //Conditions
    private final Condition tooBigCondition = lock.newCondition();
    private final Condition tooSmallCondition = lock.newCondition();

    public void add(E e) {
        lock.lock();
        try {
            while(list.size() >= 10) {
                tooBigCondition.await();            
            } 
            list.add(e);
            tooSmallCondition.signalAll();
        } catch (InterruptedException exc) {

        }
        finally {
            lock.unlock();
        }
    }

    public E remove() {
        lock.lock();
        E e = null;
        try {
            while(list.size() <= 0) {
                tooSmallCondition.await();   
            } 
            e = list.removeFirst();
            tooBigCondition.signalAll();
        } catch (InterruptedException exc) {}
        finally {
            lock.unlock();
        }
        return e;
    }
    public int getSize() {
        return list.size();
    }
}

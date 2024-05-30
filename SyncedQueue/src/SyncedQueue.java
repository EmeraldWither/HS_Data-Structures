import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncedQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();

    private int size = 0;
    
    //Conditions
    private final Condition tooBigCondition = lock.newCondition();
    private final Condition tooSmallCondition = lock.newCondition();

    public void lock() {
        lock.lock();
    }
    public void unlock() {
        lock.unlock();
    }

    public void add(E e) {
        try {
            while(list.size() >= 10) {
                tooBigCondition.await();            
            } 
            list.add(e);
            this.size++;
        } catch (InterruptedException exc) {

        }
        finally {
            tooSmallCondition.signalAll();
        }
    }

    public E remove() {
        E e = null;
        try {
            while(list.size() <= 0) {
                tooSmallCondition.await();   
            } 
            e = list.removeFirst();

        } catch (InterruptedException exc) {}
        finally {
            tooBigCondition.signalAll();
        }
        return e;
    }
    public int getSize() {
        return list.size();
    }
}

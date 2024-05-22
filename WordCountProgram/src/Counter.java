package src;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Lock lock = new ReentrantLock();
    private int count = 0;
    private int tCount = 3;

    public void addCount(int amount) {
        lock.lock();
        try {
            count += amount;
            tCount--;
        }
        finally {
            lock.unlock();
        }
    }
    public synchronized int getTCount() {
        return tCount;
    }
    public int getCount() {
        return count;
    }
}

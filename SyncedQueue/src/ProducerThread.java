import java.util.Date;

public class ProducerThread implements Runnable {

    private final SyncedQueue<String> queue;
    public ProducerThread(SyncedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            queue.lock();
            String d = new Date().toString();
            queue.add(d);
            System.out.println("Added (" + i + ") " + d + " " + queue.getSize());
            queue.unlock();
        }
    }

}

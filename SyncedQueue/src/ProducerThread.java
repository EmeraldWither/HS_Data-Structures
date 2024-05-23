import java.util.Date;

public class ProducerThread implements Runnable {

    private final SyncedQueue<String> queue;
    public ProducerThread(SyncedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            String d = new Date().toString();
            queue.add(d);
            System.out.println("Added (" + i + ") " + d + " " + queue.getSize());
        }
    }

}

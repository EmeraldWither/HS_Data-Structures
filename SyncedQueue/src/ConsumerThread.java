public class ConsumerThread implements Runnable {

    private final SyncedQueue<String> queue;
    public ConsumerThread(SyncedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            String s = queue.remove();
            System.out.println("Removed (" + i + ") " + s + " " + queue.getSize());
        }
    }

}

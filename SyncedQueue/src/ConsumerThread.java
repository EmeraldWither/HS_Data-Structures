public class ConsumerThread implements Runnable {

    private final SyncedQueue<String> queue;
    public ConsumerThread(SyncedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            queue.lock();
            String s = queue.remove();
            System.out.println("Removed (" + i + ") " + s + " " + queue.getSize());
            queue.unlock();

        }
    }

}

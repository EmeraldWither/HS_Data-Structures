public class SyncedQueueProgram {
    public static void main(String[] args) throws Exception {
        SyncedQueue<String> queue = new SyncedQueue<>();
        new Thread(new ConsumerThread(queue)).start();
        new Thread(new ProducerThread(queue)).start();
    }
}

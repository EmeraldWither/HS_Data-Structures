import java.util.LinkedList;

public class LinkedListRace {
    public static void main(String[] args) throws Exception {
        LinkedList<String> ll = new LinkedList<>();
        new Thread(
                () -> {
                    while (true) {
                        ll.add("str" + ll.size());
                        System.out.println("Adding \"str" + ll.size() + "\" to the LL.");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();
        new Thread(
                () -> {
                    while (true) {
                        ll.remove();
x                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
        }).start();
    }
}

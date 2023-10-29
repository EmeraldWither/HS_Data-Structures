import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        Set<String> friends = new HashSet<>();
        friends.add("Gavin");
        friends.add("Bhavi");
        friends.add("Emilie");
        System.out.println(friends);

        friends.add("Ugh");
        friends.add("VII");
        for(String s : friends){
            System.out.println(s.hashCode());
        }
        Set<String> treeSet = new TreeSet<>();
        treeSet.addAll(friends);

        System.out.println(treeSet);
    }
}

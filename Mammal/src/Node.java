public class Node
{
    public String data;
    public Node yes;
    public Node no;

    public Node()
    {}
    public Node(String data, Node yes, Node no)
    {
        this.data = data;
        this.yes = yes;
        this.no = no;
    }
    public Node(String animal)
    {
        this.data = animal;
    }

    public boolean isLeaf()
    {
        return yes == null && no == null;
    }
}

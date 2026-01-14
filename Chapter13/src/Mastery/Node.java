package Mastery;

public class Node
{
    private Node link;
    private String info;

    public Node(String infoData)
    {
        info = infoData;
        link = null;
    }

    public String getData()
    {
        return info;
    }

    public void setNext(Node nextLink)
    {
        link = nextLink;
    }

    public Node getNext()
    {
        return link;
    }
}

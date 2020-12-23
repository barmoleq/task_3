package items;

public class Node {

    private String name;
    private String data;
    private Row owner;

    public Node(String name, String data, Row owner){
        this.data = data;
        this.name = name;
        this.owner = owner;

    }

    public String getData() {return data;}

    public String getName() {return name;}

    public Row getOwner() {
        return owner;
    }

    public void setData(String data) {
        this.data = data;
    }
}

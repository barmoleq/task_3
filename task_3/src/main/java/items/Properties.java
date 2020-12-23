package items;

public class Properties {

    private String name;
    private Node child;

    public Properties(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}

package items;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private String name;
    private List<Properties> properties;
    private List<Node> nodes;

    public Row(String name){
        this.name = name;
        this.properties = new ArrayList<>();
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {return nodes;}

    public String getName() {return name;}

    public List<Properties> getProperties() {return properties;}

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}

package items;


import java.util.ArrayList;
import java.util.List;

public class Table {

    private String name;
    private List<Row> rows;

    public Table(String name){
        this.name = name;
        this.rows = new ArrayList<>();
    }


    public List<Row> getRows() {return rows;}

    public String getName() {return name;}

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}

package items;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableService {

    public void addRow(String name, Table table){
        Row row = new Row(name);
        List<Row> rows = table.getRows();
        rows.add(row);
        table.setRows(rows);
    }

    public void addProperties(String name, Table table){
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            List<Properties> pr = row.getProperties();
            Properties properties = new Properties(name);
            Node node = new Node(name, "Неопределенно", row);
            pr.add(properties);
            row.setProperties(pr);
            properties.setChild(node);
            List<Node> nodes = row.getNodes();
            nodes.add(node);
            row.setNodes(nodes);
        }
    }

    public void addNode( Table table, String name, String pr, String data) {
        Row owner = searchRowPr(table, name, pr);
        assert owner != null;
        List<Node> nodes = owner.getNodes();
        for (Node node : nodes) {
            if (node.getName().equals(pr)) {
                node.setData(data);
            }
        }
        owner.setNodes(nodes);
    }

    public Table searchTable(List<Table> tables, String name){
        for (Table table : tables){
            if(table.getName().equals(name)){
                return table;
            }
        }
        return null;
    }

    public Row searchRowPr(Table table, String name, String pr){
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            if(row.getName().equals(name)){
                for(int i = 0; i < row.getProperties().size(); i++){
                    if(row.getProperties().get(i).getName().equals(pr)){
                        return row;
                    }
                }
            }
        }
        return null;
    }

    public Row searchRow(Table table, String name){
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            if(row.getName().equals(name)){
                        return row;
            }
        }
        return null;
    }

    public Node searchNodeData(Row row, String data){
        for (int i =0; i < row.getNodes().size(); i++){
            if(row.getNodes().get(i).getData().equals(data)){
                return row.getNodes().get(i);
            }
        }
        return null;
    }

    public Node searchNode(Row row, String pr){
        for (int i =0; i < row.getProperties().size(); i++){
            if(row.getProperties().get(i).getName().equals(pr)){
                return row.getProperties().get(i).getChild();
            }
        }
        return null;
    }

    public Properties searchNodePr(Row row, String pr){
        for (int i =0; i < row.getProperties().size(); i++){
            if(row.getProperties().get(i).getName().equals(pr)){
                return row.getProperties().get(i);
            }
        }
        return null;
    }


    public void deleteNode(Table table, String name, String pr){
        Row row = searchRowPr(table, name, pr);
        Properties properties = searchNodePr(row, pr);
        Node node = new Node(pr, "Неопределенно", row);
        properties.setChild(node);
        addNode(table, name, pr, "Неопределенно");
    }

    public void deleteProperties(Table table, String pr){
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            for (int j = 0; j < row.getProperties().size(); j++) {
                if (row.getProperties().get(j).getName().equals(pr)) {
                    row.getProperties().remove(j);
                }
                if(row.getNodes().get(j).getName().equals(pr)){
                    row.getNodes().remove(j);
                }
            }
        }
    }

    public void deleteRow(Table table, String name){
        for(int i = 0; i < table.getRows().size(); i++){
            if(table.getRows().get(i) == searchRow(table, name)){
                table.getRows().remove(i);
            }
        }
    }
}
import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Interface {
    private static TableService service = new TableService();
    private static Scanner in = new Scanner(System.in);
    private static List<Table> tables = new ArrayList<>();

    public void openMenu(){
        addDate();
        System.out.println("Меню:");
        System.out.println("1 - Создание таблицы");
        System.out.println("2 - Работа с таблицей");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if (choice == 1){
            createMenu();
        } if (choice == 2){
            workMenu();
        }
    }

    public void addDate(){
        Table car = new Table("Машины");
        tables.add(car);
        service.addRow("Сузуки", car);
        service.addRow("Бентли", car);
        service.addProperties("Тип машины", car);
        service.addProperties("Владелец", car);
        service.addNode(car, "Сузуки","Тип машины", "Легковая");
        service.addNode(car, "Сузуки","Владелец", "Петя");
    }

    public void createMenu(){
        createTable();
        createRow();
        int choiceRow = choice();
        while (choiceRow == 1){
            createRow();
            choiceRow = choice();
        }
        createProperties();
        int choicePr = choice();
        while (choicePr == 1){
            createProperties();
            choicePr = choice();
        }
        createNode();
        int choiceNode = choice();
        while (choiceNode == 1){
            createNode();
            choiceNode = choice();
        }
        openMenu();
    }

    public void workMenu(){
        System.out.println("Меню для работы:");
        System.out.println("1 - Просмотр своих таблиц");
        System.out.println("2 - Работа с таблицей");
        System.out.println("3 - Вернуться");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if (choice == 1){
            viewTable();
        }if(choice == 2){
            workTableMenu();
        }if(choice == 3){
            openMenu();
        }
    }

    public void workTableMenu(){
        System.out.println("Меню для работы:");
        System.out.println("1 - Редактирование");
        System.out.println("2 - Поиск");
        System.out.println("3 - Вернуться");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if (choice == 1){
            editingMenu();
        }if(choice == 3){
            workMenu();
        }
    }

    public void editingMenu(){
        System.out.println("Меню для работы:");
        System.out.println("1 - Добавить элемент");
        System.out.println("2 - Удалить элемент");
        System.out.println("3 - Вернуться");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if(choice == 1){
            addMenu();
        }if(choice == 2){
            deleteMenu();
        }if(choice == 3){
            workTableMenu();
        }
    }

    public void addMenu(){
        System.out.println("Меню для работы:");
        System.out.println("1 - Добавить ячейку");
        System.out.println("2 - Добавить свойство");
        System.out.println("3 - Добавить сущьность");
        System.out.println("4 - Вернуться");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if(choice == 1){
            addNode();
        }if(choice == 2){
            addProperties();
        }if(choice == 3){
            addRow();
        }if(choice == 4){
            editingMenu();
        }
    }

    public void deleteMenu(){
        System.out.println("Меню для работы:");
        System.out.println("1 - Удалить ячейку");
        System.out.println("2 - Удалить свойство");
        System.out.println("3 - Удалить сущьность");
        System.out.println("4 - Вернуться");
        System.out.println("Выберите действие для работы, нажатием цифры:");
        int choice = in.nextInt();
        in.skip("\n");
        if(choice == 1){
            deleteNode();
        }if(choice == 2){
            deleteProperties();
        }if(choice == 3){
            deleteRow();
        }if(choice == 4){
            editingMenu();
        }
    }

    private void viewTable(){
        System.out.println("Введите название таблицы для просмотра:");
        String name = in.nextLine();
        Table table = service.searchTable(tables, name);
        System.out.println("Таблица: " + table.getName());
        System.out.println("Сущьности: ");
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            System.out.println(row.getName());
            List<Properties> properties = row.getProperties();
            for (Properties property : properties){
                System.out.print(property.getName() + ": ");
                System.out.println(property.getChild().getData());
            }
            System.out.println("================================================");
        }
        workMenu();
    }

    public void printNode(Table table, String name, String pr){
        Row row = service.searchRow(table, name);
        Node node = service.searchNode(row, pr);
        System.out.println("Данные по запросу:");
        System.out.println("Таблица: " + table.getName());
        System.out.println("Сущность: " + name);
        System.out.println("Свойство: " + pr);
        System.out.println("Вы получили: " + node.getData());
    }

    public void printProperties(Table table, String name) {
        Row row = service.searchRow(table, name);
        System.out.println("Данные по запросу:");
        System.out.println("Таблица: " + table.getName());
        System.out.println("Сущность: " + name);
        System.out.println("Вы получили: ");
        List<Properties> pr = row.getProperties();
        for(Properties properties : pr) {
            System.out.println(properties.getName());
        }
    }

    public void printRow(Table table){
        List<Row> rows = table.getRows();
        System.out.println("Данные по запросу:");
        System.out.println("Таблица: " + table.getName());
        System.out.println("Вы получили: ");
        for(Row row : rows) {
            System.out.println(row.getName());
        }
    }

    private void createTable(){
        System.out.println("Введите название новой таблицы: ");
        String name = in.nextLine();
        Table table = new Table(name);
        tables.add(table);
    }

    private void createRow(){
        System.out.println("Введите название сущности:");
        String row = in.nextLine();
        Table table = tables.get(tables.size()-1);
        service.addRow(row, table);
    }

    private void createProperties(){
        System.out.println("Введите название свойства:");
        String pr = in.nextLine();
        Table table = tables.get(tables.size()-1);
        service.addProperties(pr, table);
    }

    private void createNode(){
        System.out.println("Введите, в какую сущность хотите добавить ячейку: ");
        String name = in.nextLine();
        System.out.println("Введите, к какому свойству относиться ячейка: ");
        String pr = in.nextLine();
        System.out.println("Введите данные ячейки: ");
        String date = in.nextLine();
        Table table = tables.get(tables.size()-1);
        service.addNode(table, name, pr, date);
    }

    private void addRow(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите название сущности:");
        String row = in.nextLine();
        service.addRow(row, tb);
    }

    private void addProperties(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите название свойства:");
        String pr = in.nextLine();
        service.addProperties(pr, tb);
    }

    private void addNode(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите, в какую сущность хотите добавить ячейку: ");
        String name = in.nextLine();
        System.out.println("Введите, к какому свойству относиться ячейка: ");
        String pr = in.nextLine();
        System.out.println("Введите данные ячейки: ");
        String date = in.nextLine();
        service.addNode(tb, name, pr, date);
    }

    public void deleteRow(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите, какую сущьность хотите удалить: ");
        String name = in.nextLine();
        service.deleteRow(tb, name);
        deleteMenu();
    }

    public void deleteProperties(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите, какое свойство хотите удалить: ");
        String pr = in.nextLine();
        service.deleteProperties(tb, pr);
        deleteMenu();
    }

    public void deleteNode(){
        System.out.println("Введите, с какой таблицей вы будете работать: ");
        String table = in.nextLine();
        Table tb = service.searchTable(tables, table);
        System.out.println("Введите, из какой сущности удалить ячейку: ");
        String name = in.nextLine();
        System.out.println("Введите, из какого свойства удалить ячейку: ");
        String pr = in.nextLine();
        service.deleteNode(tb, name, pr);
        deleteMenu();
    }

    private int choice(){
        System.out.println("Желаете добавить значение?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        int choice = in.nextInt();
        in.skip("\n");
        return choice;
    }

}

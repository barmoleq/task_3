import items.Table;
import items.TableService;



public class Main {
    private static TableService service = new TableService();
    private static Interface inter = new Interface();

    public static void main(String[] args) {
        /*Table car = new Table("Машины");
        service.addRow("Сузуки", car);
        service.addRow("Бентли", car);
        service.addProperties("Тип машины", car);
        service.addProperties("Владелец", car);
        service.addNode(car, "Сузуки","Тип машины", "Легковая");
        service.addNode(car, "Сузуки","Владелец", "Петя");
        service.deleteNode(car, "Сузуки", "Тип машины");
        service.deleteProperties(car, "Владелец");
        service.deleteRow(car, "Бентли");
        inter.printNode(car, "Сузуки", "Владелец");
        inter.printProperties(car, "Сузуки");
        inter.printRow(car);*/
        inter.openMenu();
    }
}

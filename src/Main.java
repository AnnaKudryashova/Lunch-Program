import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Client> clients = DataBase.dbClients();
        Menu menu = DataBase.dbDishes();
        Map<Dish, Integer> reportForKitchen;
        getMenu(clients, menu);
        clients.get(0).addDishInBill(menu.getMenuDish("Solyanka"));
        clients.get(0).addDishInBill(menu.getMenuDish("Pelmeni"));
        clients.get(0).addDishInBill(menu.getMenuDish("Rolled cake"));
        clients.get(1).addDishInBill(menu.getMenuDish("Borsch"));
        clients.get(1).addDishInBill(menu.getMenuDish("Rice"));
        clients.get(1).addDishInBill(menu.getMenuDish("Pizza"));
        clients.get(1).addDishInBill(menu.getMenuDish("Berry tart"));
        clients.get(2).addDishInBill(menu.getMenuDish("Fish soup"));
        clients.get(2).addDishInBill(menu.getMenuDish("Meatballs"));
        clients.get(2).addDishInBill(menu.getMenuDish("Mashed potato"));
        clients.get(2).addDishInBill(menu.getMenuDish("Praga cake"));
        clients.get(3).addDishInBill(menu.getMenuDish("Solyanka"));
        clients.get(3).addDishInBill(menu.getMenuDish("Golubtsy"));
        clients.get(3).addDishInBill(menu.getMenuDish("Pancakes"));
        clients.get(3).addDishInBill(menu.getMenuDish("Cheesecake"));
        clients.get(4).addDishInBill(menu.getMenuDish("Borsch"));
        clients.get(4).addDishInBill(menu.getMenuDish("Mashed potato"));
        clients.get(4).addDishInBill(menu.getMenuDish("Beef Stroganoff"));
        clients.get(4).addDishInBill(menu.getMenuDish("Noodle"));

        reportForKitchen = getReportForKitchen(clients);
        printReportForKitchen(reportForKitchen);
        getBill(clients);
        DishFactory.cookDish(reportForKitchen);
    }
    private static void getBill(List<Client> clients) {
        int fullPrice = 0;
        System.out.println("\nReport#2 (Client's bill to pay)");
        System.out.format("%-15s%36s\n", "Client", "Dish name/price/qty");
        System.out.println("----------------------------------------------------");
        for (Client client : clients) {
            System.out.println(client.getNumber());
            for (Dish dish : client.getListDish()) {
                int countDish = client.getCountDish(dish);
                fullPrice += countDish * dish.getPrice();
                System.out.format("%35s/%s rub./%s pcs", dish.getName(), dish.getPrice(), countDish);
                System.out.println();
            }
            System.out.format("%35s Total: %s rub.\n", "", fullPrice);
            System.out.println("----------------------------------------------------");
            fullPrice = 0;
        }
    }
    private static Map <Dish, Integer> getReportForKitchen (List<Client> clients) {
        Map<Dish, Integer> dishMap = new HashMap<>();
        for (Client client : clients) {
            for (Dish dish : client.getListDish()) {
                int countDish = client.getCountDish(dish);
                if(dishMap.containsKey(dish)) {
                    int countDishFromMap = dishMap.get(dish);
                    dishMap.put(dish, countDish + countDishFromMap);
                } else {
                    dishMap.put(dish, countDish);
                }
            }
        } return dishMap;
    }
    private static void printReportForKitchen(Map<Dish, Integer> dishMap) {
        int fullPrice = 0;
        System.out.println("\nReport#1 (for Kitchen)");
        System.out.printf("%-20s %-20s %-1s\n", "Dish name", "Quantity,pcs", "Sum, rub.");
        System.out.println("----------------------------------------------------");
        for (Dish dish : dishMap.keySet()) {
            int countDish = dishMap.get(dish);
            int priceDish = dish.getPrice() * countDish;
            System.out.printf("%-20s %10s %20s\n", dish.getName(), countDish, priceDish);
            fullPrice += priceDish;
        }
        System.out.println("----------------------------------------------------");
        System.out.printf("Total: %40s rub.\n", fullPrice);
        System.out.println("----------------------------------------------------");
    }
    private static void getMenu(List<Client> clients, Menu menu) {
        for (Client client : clients) {
            client.getMenu(menu);
        }
    }
}
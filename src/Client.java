import java.util.List;
public class Client {
    private String number;
    private Bill bill = new Bill();
    private Menu menu;
    public Client(String number) {
        this.number = number;
    }
    public String getNumber() {
        return this.number;
    }
    public void getMenu(Menu menu) {
        this.menu = menu;
    }
    public void addDishInBill (Dish dish) {
        bill.addDishInBill(dish);
    }
    public int getCountDish(Dish dish) {
        return bill.getCountDish(dish);
    }
    public List<Dish> getListDish() {
        return bill.getListDish();
    }
}
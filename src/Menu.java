import java.util.HashMap;
public class Menu {
    private HashMap<String, Dish> mapMenu = new HashMap<>();
    public void addMenuDish(Dish dish) {
        mapMenu.put(dish.getName(), dish);
    }
    public Dish getMenuDish(String nameDish) {
        return mapMenu.get(nameDish);
    }
}
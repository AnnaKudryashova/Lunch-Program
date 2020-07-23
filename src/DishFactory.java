import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public abstract class DishFactory {
    public static List<Dish> cookDish(Map<Dish, Integer> map) {
        List<Dish> listDish = new ArrayList<>();
        for (Dish dish : map.keySet()) {
            int count = map.get(dish);
            for (int i = 0; i < count; i++) {
                listDish.add(new Dish(dish.getName(), dish.getWeight(), dish.getPrice()));
            }
        }
        return listDish;
    }
}
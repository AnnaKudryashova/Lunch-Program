import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Bill {
    private Map<Dish, Integer> billMap = new HashMap<>();
    public void addDishInBill(Dish dish) {
        int count = 1;
        for (Dish d : billMap.keySet()) {
            if (d.getName().contentEquals(dish.getName())) {
                count += billMap.get(d);
            }
        }
        billMap.put(dish, count);
    }
    public int getCountDish(Dish dish) {
        return billMap.get(dish);
    }
    public List<Dish> getListDish() {
        List <Dish> listKeySet = new ArrayList<>();
        for (Dish dish : billMap.keySet()) {
            listKeySet.add(dish);
        }
        return listKeySet;
    }
}
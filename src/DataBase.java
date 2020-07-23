import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DataBase {
    private static String url = "jdbc:sqlite:.\\database\\dishes.db";
    private static Connection co;
    private static Statement st;
    private static ResultSet rs;
    private static void open() throws ClassNotFoundException, SQLException {
            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection(url);
            st = co.createStatement();
    }
    public static Menu dbDishes() throws SQLException, ClassNotFoundException {
        open();
        String sqlQuery = "SELECT * FROM dishes;";
        Menu menu = new Menu();
        rs = st.executeQuery(sqlQuery);
        while(rs.next()) {
            menu.addMenuDish(new Dish(rs.getString("name"), rs.getInt("weight"), rs.getInt("price")));
        }
        close();
        return menu;
    }
    public static List<Client> dbClients() throws SQLException, ClassNotFoundException {
        open();
        String sqlQuery = "SELECT * FROM clients;";
        List<Client> clients = new ArrayList<>();
        rs = st.executeQuery(sqlQuery);
        while(rs.next()) {
            clients.add(new Client(rs.getString("number"))); }
        close();
        return clients;
    }

    public static void close() {
        try {
            rs.close();
            st.close();
            co.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
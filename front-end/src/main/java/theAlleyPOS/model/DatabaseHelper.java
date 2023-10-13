package theAlleyPOS;
import theAlleyPOS.model.Item;
import theAlleyPOS.model.UserRole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    private static final String DB_URL = "jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315331_09g_db";
    private static final String USER = "csce315_909_roshantayab";
    private static final String PASS = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public UserRole validateUser(String ID) {
        if (isIDValid(ID, "Managers")) {
            return UserRole.MANAGER;
        } else if (isIDValid(ID, "Cashiers")) {
            return UserRole.EMPLOYEE;
        } else {
            return UserRole.NONE;
        }
    }

    private boolean isIDValid(String ID, String tableName) {
        String sql = "SELECT password FROM " + tableName + " WHERE password = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int password = Integer.parseInt(ID);
            pstmt.setInt(1, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Item> fetchItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                items.add(new Item(rs.getInt("id"), rs.getString("item_name"), rs.getDouble("price"), rs.getInt("inventory_count")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void addItem(Item item) {
        String sql = "INSERT INTO items (id, item_name, price, inventory_count) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getItemName());
            pstmt.setDouble(3, item.getPrice());
            pstmt.setInt(4, item.getInventoryCount());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItemInDatabase(Item item) {
        String sql = "UPDATE items SET item_name = ?, price = ?, inventory_count = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getItemName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setInt(3, item.getInventoryCount());
            pstmt.setInt(4, item.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

/*
Managers:
       id |       name       | password
       ---|------------------|----------
        0 | Grant Shields    | 9234
        1 | Blake Dugan      | 9345
        2 | Roshan Tayab     | 9456
        3 | Sebastian Oberg  | 9567
        4 | Spencer Le       | 9678

Employees:
       id |       name       | password
       ---|------------------|----------
        0 | Grant Shields    | 1234
        1 | Blake Dugan      | 1345
        2 | Roshan Tayab     | 1456
        3 | Sebastian Oberg  | 1567
        4 | Spencer Le       | 1678
*/
package model.category;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insertCategory(Category category) {  //Categoryクラスを定義したファイル(src/main/java/model/category/Category.java)から呼び出される
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            //sql文を用意
            String sql = "insert into categories(name, created_at, updated_at, users_id) values (?, ?, ?, ?)";

            //DBとの接続
            connection = create();

            //作成日時と更新日時のために現在時刻を取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //必要事項を代入
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);
            stmt.setInt(4, category.getUserId());

            //sql文を実行
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

    public static ArrayList<Category> indexCategories(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from categories where users_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            ArrayList<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        null,
                        null,
                        rs.getInt("users_id")
                );
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}

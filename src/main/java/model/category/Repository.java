package model.category;

import lib.mysql.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Repository extends Client {
    public static void insertCategory(Category category) {  //Categoryクラスを定義したファイル(src/main/java/model/category/Category.java)から呼び出される
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            //sql文を用意
            String sql = "insert into categories(name, created_at, updated_at, user_id) values (?, ?, ?, ?)";

            //DBとの接続
            connection = create();

            //作成日時と更新日時のために現在時刻を取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //必要事項を代入
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setTimestamp(2, category.getCreatedAt());
            stmt.setTimestamp(3, category.getUpdatedAt());
            stmt.setInt(4, category.getUserId());

            //sql文を実行
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}

package model.user;
import lib.mysql.Client;
import java.sql.*;
public class Repository extends Client {
    public static void signUpUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            //sql文を用意
            String sql = "insert into users(name, email, password, created_at, updated_at) values (?, ?, ?, ?, ?)";
            //DBとの接続
            connection = create();
            // 作成日時と更新日時のために現在時刻を取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            // 必要事項を代入
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPass());
            stmt.setTimestamp(4, currentTime);
            stmt.setTimestamp(5, currentTime);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}
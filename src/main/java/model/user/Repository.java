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

    public static User selectUserByEmail(String email) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // sql文を用意
            String sql = "select * from users where email = ?";
            // DBとの接続
            connection = create();
            //
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            // sql文を実行
            rs = stmt.executeQuery();
            // スコープの問題があるので空のインスタンスを定義
            User user = null;
            if (rs.next()) {    // rsの中身があれば(select文にヒットすれば)
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        null,
                        rs.getString("password"),
                        null,
                        null
                );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }

}
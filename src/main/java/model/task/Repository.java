package model.task;

import lib.mysql.Client;
import model.user.User;

import java.sql.*;
import java.util.ArrayList;

public class Repository extends Client {
    public static void insert(Task task) {  //Taskクラスを定義したファイル(src/main/java/model/task/Task.java)から呼び出される
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            //sql文を用意
            String sql = "insert into tasks(name, memo, deadline, created_at, updated_at, completed, users_id, categories_id) values (?, ?, ?, ?, ?, ?, ?, ?)";

            //DBとの接続
            connection = create();

            //作成日時と更新日時のために現在時刻を取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //必要事項を代入
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getMemo());
            stmt.setDate(3, task.getDeadline());
            stmt.setTimestamp(4, currentTime);
            stmt.setTimestamp(5, currentTime);
            stmt.setBoolean(6, task.getCompleted());
            stmt.setInt(7, task.getUserId());
            stmt.setInt(8, task.getCategoryId());

            //sql文を実行
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }

    public static ArrayList<Task> indexTasks(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from tasks where users_id = ?";
            connection = create();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            ArrayList<Task> tasks = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("memo"),
                        rs.getDate("deadline"),
                        null,
                        null,
                        rs.getBoolean("completed"),
                        rs.getInt("users_id"),
                        rs.getInt("categories_id")
                );
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}

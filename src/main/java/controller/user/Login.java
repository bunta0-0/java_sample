package controller.user;
import model.user.Repository;
import model.user.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/user/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // フォームで入力した内容を受け取る
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        // 入力内容を元にしたインスタンスを作成
        User user = new User(
                null,
                null,
                email,
                pass,
                null,
                null
        );

        // ログイン実行
        User currentUser = user.login();
        // ログイン結果によって挙動が変わる
        if (currentUser != null) {
            HttpSession session = req.getSession(); // セッションを作って
            session.setAttribute("currentUser", currentUser); // セッションスコープに格納
            //ログインが成功したのでマイページに
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/top.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("Error", "アカウントが作成されていないか、アカウントが一致しません。"); // エラーの内容をリクエストスコープに格納
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
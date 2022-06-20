package controller.task;
import model.category.Category;
import model.task.*;
import model.user.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
@WebServlet("/task/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        ArrayList<Category> categories = Category.indexCategories(user);
        req.setAttribute("categories", categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/task/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POSTリクエストはカテゴリー登録画面(/WEB-INF/category/insert.jsp)に必要事項を入力して送信された時に実行される

        //文字コードを設定
        req.setCharacterEncoding("UTF-8");

        //JSPで入力したものを受付
        String name=  req.getParameter("name");
        String memo=  req.getParameter("memo");
        Date deadline= Date.valueOf(req.getParameter("deadline"));
        int categoryId= Integer.parseInt(req.getParameter("categoryId"));



        //taskには誰が登録したかのuserIdが必要なのでログイン時に設定したセッションスコープからユーザー情報を取得
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        //JSPでの入力+セッションスコープからのユーザー情報でTaskインスタンスを生成
        Task task = new Task(
                null,
                name,
                memo,
                deadline,
                null,
                null,
                false,
                user.getId(),
                categoryId
        );

        //Categoryクラスが持つinsertCategoryを実行．これはsrc/main/java/model/category/Category.javaにある
        task.insert();

        //登録が完了したらマイページに遷移する
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/top.jsp");
        dispatcher.forward(req, resp);
    }
}
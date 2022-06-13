package controller.category;

import model.category.Category;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//まず，アノテーションを設定する
@WebServlet("/category/insert")
public class Insert extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GETリクエストのときにはカテゴリー登録画面(/WEB-INF/category/insert.jsp)を表示するようにフォワードを設定
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/category/insert.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POSTリクエストはカテゴリー登録画面(/WEB-INF/category/insert.jsp)に必要事項を入力して送信された時に実行される

        //文字コードを設定
        req.setCharacterEncoding("UTF-8");

        //JSPで入力したものを受付
        String name=  req.getParameter("name");

        //categoryには誰が登録したかのuserIdが必要なのでログイン時に設定したセッションスコープからユーザー情報を取得
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");

        //JSPでの入力+セッションスコープからのユーザー情報でCategoryインスタンスを生成
        Category category = new Category(
                null,
                name,
                null,
                null,
                user.getId()
        );

        //Categoryクラスが持つinsertCategoryを実行．これはsrc/main/java/model/category/Category.javaにある
        category.insertCategory();

        //登録が完了したらマイページに遷移する
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/user/top.jsp");
        dispatcher.forward(req, resp);
    }
}

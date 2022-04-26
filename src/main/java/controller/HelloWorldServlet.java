package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/hello/index.jsp");
		dispatcher.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		// requestオブジェクトから登録情報の取り出し
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		// コンソールに確認するために出力
		System.out.println("取得したnameは" + name + "です！");
		System.out.println("取得したpassは" + pass + "です！");
		//requestオブジェクトに情報を保存する。
		request.setAttribute("name",name);
		request.setAttribute("pass",pass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/hello/TOP.jsp");
		dispatcher.forward(request, response);
	}
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// リクエストパラメータの入力項目を取得
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		
		User user = new User();
		UserDao userDao = new UserDao();
		
		/** テーブルに同じログインIDが存在した場合*/
		if (!userDao.isCheckLoginId(loginId)) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "ログインIDが既に登録されています。");

			// ログインjspにフォワード
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
				
		if(!password.equals(password2)) {						//文字列の一致はequals()メソッドで行う
			request.setAttribute("errMsg", "パスワードが一致しません");

			// 失敗 既に登録されているログインIDが入力された場合  新しくメソッドをつくってID一致かどうか確認する
			//パスワードとパスワード(確認）の入力内容が異なる場合
			//入力項目に1つでも未入力がある場合
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(loginId.equals("")) {
			request.setAttribute("errMsg", "ログインIDが未入力です");
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(password.equals("")) {
			request.setAttribute("errMsg", "パスワードが未入力です");
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(password2.equals("")) {
			request.setAttribute("errMsg", "パスワード（確認）が未入力です");
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(name.equals("")) {
			request.setAttribute("errMsg", "ユーザ名が未入力です");
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(birthDate.equals("")) {
			request.setAttribute("errMsg", "生年月日が未入力です");
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("name",name);
			request.setAttribute("birthDate", birthDate);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user-registration2.jsp");
			dispatcher.forward(request, response);
			return;
		}																//登録失敗・・・新規登録画面に戻る
										//ページ名の下に赤色で「入力された内容は正しくありません」と表示。
										//入力した内容は引き継がれるが、パスワードおよびパスワード（確認）のみ空欄にする
		
		
		
		
		

		//登録
		userDao.createUser(loginId,  password, password2 , name, birthDate);
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("userregist", user);

		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");

		}
	//登録成功時 ユーザ一覧画面に遷移する
		

	}


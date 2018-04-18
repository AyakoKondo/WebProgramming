package controller;//見本

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 未実装：ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("userInfo");
		if(null == user) {
			response.sendRedirect("LoginServlet");
			return;
		}
		
		// ユーザ一覧情報を取得
		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("userList", userList);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインID(完全一致）
		//ユーザ名（部分一致）
		//生年月日（開始日と終了日の範囲内の日付に該当するもの）で検索可能
		request.setCharacterEncoding("UTF-8");
		
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDateStart = request.getParameter("birthDateStart");
		String birthDateEnd = request.getParameter("birthDateEnd");
		
		UserDao userDao = new UserDao();
		List<User> userSearch = userDao.findSearch(loginId,name,birthDateStart,birthDateEnd);
		
		
		
		/** テーブルに該当のデータが見つかった場合 **/
		// セッションにユーザの情報をセット
		request.setAttribute("userSearch", userSearch);

		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList2.jsp");
		dispatcher.forward(request, response);
	

	
	}

}

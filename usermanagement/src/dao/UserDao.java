package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;


public class UserDao {

   
//      ログインIDとパスワードに紐づくユーザ情報を返す
//    @param loginId
//    @param password
//    @return

    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, convertMd5(password));
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    
    //新規登録
    //戻り値なし、引数ありのメソッド
    
    public void createUser(String loginId, String password, String password2 , String name, String birthDate) {
    	Connection conn = null;
    	
    	
    	try {
    		//DBへ接続
    		conn = DBManager.getConnection();							//now()now()のとき登録いらない
    		
    		//insert文を準備
    		 String sql = "INSERT INTO user (login_id,name,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(), now())";
    		//now()現在時刻
    		     		 
    		 //insertを実行
    		 PreparedStatement pStmt = conn.prepareStatement(sql);
    		 
    		 //新規登録のときは追加レコード１つなので数える必要なし?
            
    		 
    		 pStmt.setString(1, loginId);        //preparedstatementのため必要
    		 pStmt.setString(2, name);
             pStmt.setString(3, birthDate);			
             pStmt.setString(4, convertMd5(password));
            
             pStmt.executeUpdate();
//             System.out.println(result);
             
             
             
            
         } catch (SQLException e) {
             e.printStackTrace();
             
         } finally {
             // データベース切断
             if (conn != null) {
                 try {
                     conn.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                     
                 }
             }
         }
     }

    //ログインID検索用のメソッド
    public boolean isCheckLoginId(String loginId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
    }
    
    
    
    
    //ユーザ詳細参照用のDaoメソッド
    public User findByUserDetail(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT login_id,name,birth_date,create_date,update_date FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
            String createDate = rs.getString("create_date");
        	String updateDate = rs.getString("update_date");
            
            return new User(loginIdData, nameData,birthDate,createDate,updateDate);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    //iD入りのDaoメソッド
    public User findByUserId(String id) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT id,login_id,name,birth_date FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, id);
            
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String idData = rs.getString("id");
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            Date birthDate = rs.getDate("birth_date");
           
            
            return new User(idData,loginIdData, nameData,birthDate);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
	//更新用のDaoメソッド
	
	public void updateUser(String id, String password, String password2 , String name, String birthDate) {
		 Connection conn = null;
	     try {
	         // データベースへ接続
	         conn = DBManager.getConnection();
	
	         // update文を準備
	         String sql = "UPDATE user SET name = ? ,birth_date = ?,password= ? ,update_date = now() WHERE id = ?";
	
	          // updateを実行し、結果表を取得
	         PreparedStatement pStmt = conn.prepareStatement(sql);
	        
			 pStmt.setString(1, name);				//preparedstatementのため必要
	         pStmt.setString(2, birthDate);			
	         pStmt.setString(3, convertMd5(password));
	         pStmt.setString(4, id);
	         
	         
	        int result = pStmt.executeUpdate();
	        System.out.println(result);             //更新箇所の数確認用
	
	
	      
	     } catch (SQLException e) {
	         e.printStackTrace();
	         
	     } finally {
	         // データベース切断
	         if (conn != null) {
	             try {
	                 conn.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	               
	             }
	         }
	     }
	 }
		 
	 //削除用のDaoメソッド
	public void deleteUser(String id) {
		 Connection conn = null;
	    try {
	        // データベースへ接続
	        conn = DBManager.getConnection();
	
	        // delete文を準備
	        String sql = "DELETE FROM user WHERE id = ?";
	
	         // deleteを実行	       
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	       
	        pStmt.setString(1, id);
	        
	        int result = pStmt.executeUpdate();
	        System.out.println(result);
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    } finally {
	        // データベース切断
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	              
	            }
	        }
	    }
	}
	 
	 
	 
	 
	 
	 
	 
 
 // 全てのユーザ情報を取得する
      //@return
 
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 管理者以外を取得するようSQLを変更する		where not in ()でそれ以外
            String sql = "SELECT * FROM user where login_id  not in ('admin') ORDER BY login_id";
            
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }
    
    private String convertMd5(String password) {
    	//ハッシュ生成前にバイト配列に置き換える際のCharset
    	Charset charset = StandardCharsets.UTF_8;
    	//ハッシュアルゴリズム
    	String algorithm = "MD5";

    	//ハッシュ生成処理
    	byte[] bytes= null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	String result = DatatypeConverter.printHexBinary(bytes);

    	return result;
    }
    
    public List<User> findSearch(String loginId,String name,String birthDateStart,String birthDateEnd) {
       Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user where login_id  not in ('admin')";
            
            if(!loginId.equals("")) {
           	sql += " and login_id  = '" + loginId + "'";//完全一致
            }
            if(!name.equals("")) {
            	sql +=" and name like '%"+name + "%'";//部分一致
            }
            if(!birthDateStart.equals("")) {
            	sql +=" and birth_date > '"+birthDateStart + "'";//範囲
            }
            if(!birthDateEnd.equals("")) {
            	sql +=" and birth_date < '"+birthDateEnd + "'";//範囲
            }
           
            sql += " ORDER BY login_id";
            
             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginIdData = rs.getString("login_id");
                String nameData = rs.getString("name");
                Date birthDateData = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginIdData, nameData, birthDateData, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    	} 
    
}

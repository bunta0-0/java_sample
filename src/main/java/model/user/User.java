package model.user;
import model.Default;
import java.sql.Timestamp;
public class User extends Default {
    private String name;
    private String email;
    private String pass;
    public User(
            Integer id,
            String name,
            String email,
            String pass,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        //親クラス(Default)のコンストラクタを呼び出す
        super(id, createdAt, updatedAt);
        this.name=  name;
        this.email = email;
        this.pass = pass;
    }
    //setメソッド
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    //getメソッド
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }

    // 新規登録用メソッド
    public void signUpUser() {
        Repository.signUpUser(this);
    }

    // ログイン用メソッド
    public User login() {
        // emailをもとにユーザーが存在するかどうか調べる
        User cuurentUser = Repository.selectUserByEmail(this.email);
        //返されたユーザーのパスワードと入力されたパスワードが一致するか確認する。一致しなかったらcuurentUserをnullにする。
        if(cuurentUser != null){
            if(!(cuurentUser.getPass().equals(this.pass))){
                cuurentUser = null;
            }
        }
        return cuurentUser;
    }
}
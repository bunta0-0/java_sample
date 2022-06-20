package model.task;

import model.Default;
import model.task.Repository;
import model.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
public class Task extends Default { //TaskクラスはDefaultクラスを継承する
    //Taskクラスが独自で持つ属性はnameとmemoとdeadlineとuserId(外部キー)とcategoryId
    //id, createdAt, updatedAtはDefaultクラスが持っていて継承しているのでここには記述不要
    private String name;
    private String memo;
    private Date deadline;
    private Boolean completed;
    private Integer userId;
    private Integer categoryId;


    //カテゴリーインスタンスが持つ属性を定義
    public Task(Integer id, String name, String memo,Date deadline,Timestamp createdAt, Timestamp updatedAt, Boolean completed, Integer userId, Integer categoryId){
        super(id, createdAt, updatedAt);    //super()は継承したクラス（今回はDefault）から属性を持ってこれる
        this.name = name;
        this.memo = memo;
        this.deadline = deadline;
        this.completed = completed;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    //nameのgetterとsetter．インスタンスの属性を使いたい時は直接持ってくるのではなくて，getterを用いて返り値を使う．
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    //memoのgetterとsetter．インスタンスの属性を使いたい時は直接持ってくるのではなくて，getterを用いて返り値を使う．
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {this.memo = memo;}

    //deadlineのgetterとsetter
    public Date getDeadline(){
        return deadline;
    }
    public void setDeadline(Date deadline) {this.deadline = deadline;}

    //completedのgetterとsetter
    public Boolean getCompleted(){
        return completed;
    }
    public void setCompleted(Boolean completed) {this.completed = completed;}

    //userIdのgetterとsetter
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //categoryIdのgetterとsetter
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    //DBに登録する用のメソッド．詳細はRepository.javaに記述してある
    public void insert() {
        Repository.insert(this);
    }

   /* public static ArrayList<model.task.Task> indexTasks(User user) {
        return Repository.indexTasks(user);
    }*/
}

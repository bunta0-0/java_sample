package model.category;

import model.Default;

import java.sql.Timestamp;

public class Category extends Default { //CateogryクラスはDefaultクラスを継承する
    //Categoryクラスが独自で持つ属性はnameとuserId(外部キー)だけ
    //id, createdAt, updatedAtはDefaultクラスが持っていて継承しているのでここには記述不要
    private String name;
    private Integer userId;

    //カテゴリーインスタンスが持つ属性を定義
    public Category(Integer id, String name, Timestamp createdAt, Timestamp updatedAt, Integer userId){
        super(id, createdAt, updatedAt);    //super()は継承したクラス（今回はDefault）から属性を持ってこれる
        this.name = name;
        this.userId = userId;
    }

    //nameのgetterとsetter．インスタンスの属性を使いたい時は直接持ってくるのではなくて，getterを用いて返り値を使う．
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //userIdのgetterとsetter
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    //DBに登録する用のメソッド．詳細はRepository.javaに記述してある
    public void insertCategory() {
        Repository.insertCategory(this);
    }

}

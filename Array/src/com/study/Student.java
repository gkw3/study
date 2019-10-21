package com.study;

/**
 * @author 高孔威
 * @version 1.0
 * @Description:
 * @email:gaokw@ffcs.cn
 * @Company: 北京福富软件有限公司
 * @Copyright: Copyright (c) 2015 FFCS All Rights Reserved
 * @history:
 * @创建时间：2018/7/31 上午12:57
 */
public class Student {

    private String name;
    private int score;


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",66));
        arr.addLast(new Student("CharLie",88));
        System.out.println(arr);

    }


}

package ru.otus.ninevskiy.l51.testing_framework;

public class MyClass {
    private Integer i = 9;
    private String s = "3x3";

    public MyClass(){
        i = 16;
        s = "4x4";
    }

    public MyClass(Integer i, String s){
        this.i = i;
        this.s = s;
    }


    public Integer getI() {
        return i;
    }


    public String getS() {
        return s;
    }


    public void increment(){
        this.i =  i++;
    }


    public String say(){
        return s + " = " + i.toString();
    }


    public void setI(Integer i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }
}

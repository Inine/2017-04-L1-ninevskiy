package ru.otus.ninevskiy.l51.testing_framework;

import java.lang.reflect.InvocationTargetException;

import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.test;

/**
 * Created by Ivan Ninevskiy
 *
 * Entry class for testing
 *
 * fill in  command line parameters before run
 * for example:
 * ru.otus.ninevskiy.l51.testing_framework.MyClassTest
 *
 */
public class TestRunner {
    public static void main(String[] args) {
        try{
            for (String s: args){
                Class<?> klass = Class.forName(s);
                test(klass);
            }
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
}

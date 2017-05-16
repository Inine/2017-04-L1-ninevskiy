package ru.otus.ninevskiy.l51.testing_framework;

import ru.otus.ninevskiy.l51.testing_framework.annotations.After_;
import ru.otus.ninevskiy.l51.testing_framework.annotations.Before_;
import ru.otus.ninevskiy.l51.testing_framework.annotations.Test_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * Created by ivan on 5/4/17.
 */
public class TestingFramework {
    public static void test(Class<?> klass) throws InstantiationException, IllegalAccessException, InvocationTargetException{

        ArrayList<Method> beforeList = getAnnotatedMethods(Before_.class, klass);
        ArrayList<Method> testList = getAnnotatedMethods(Test_.class, klass);
        ArrayList<Method> afterList = getAnnotatedMethods(After_.class, klass);

        for (Method m: testList){
            Object myObj = instantiate(klass);
            for (Method before: beforeList){
                callMethod(myObj, before);
            }

            callMethod(myObj, m);

            for (Method after: afterList){
                callMethod(myObj, after);
            }
        }
    }

     static ArrayList<Method> getAnnotatedMethods(Class annotation, Class clazz){
        ArrayList<Method> methodsList = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m: methods){
            if (m.isAnnotationPresent(annotation)){
                methodsList.add(m);
            }
        }
        return methodsList;
    }

    static <T> T instantiate(Class<T> type, Object... args) {
        try {

            if (args.length == 0) {
                return type.newInstance();
            } else {
                return type.getConstructor(toClasses(args)).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    static private Class<?>[] toClasses(Object[] args) {
        Class<?>[] classes = new Class<?>[args.length];
        for (int i = 0; i <= args.length; i++){
            classes[i] = args[i].getClass();
        }
        return classes;
    }

    static Object callMethod(Object object, Method method, Object... args) {
        boolean isAccessible = true;
        try {
            isAccessible = method.isAccessible();
            method.setAccessible(true);
            return method.invoke(object, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (method != null && !isAccessible) {
                method.setAccessible(false);
            }
        }
        return null;
    }

    public static void assertTrue(boolean check){
         if (!check){
             throw new TestingError();
         }
    }

    public static void assertTrue(String failMessage, boolean check){
        if (!check){
            System.out.println(failMessage);
            throw new TestingError();
        }
    }

    public static void assertNotNull(Object object){
         if (object == null){
             throw new TestingError();
         }
    }

    public static void fail(){
         throw new TestingError();
    }

}

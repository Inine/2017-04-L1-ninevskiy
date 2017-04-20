package ru.otus.collections;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> myArrList = new MyArrayList<>(3);
        System.out.println("empty? " + myArrList.isEmpty());
        myArrList.add("A");
        myArrList.add("D");
        myArrList.add("C");
        myArrList.add("B");
        myArrList.add("E");
        System.out.println("list filled with 5 elements. Empty? " + myArrList.isEmpty());
        System.out.println("list size : "+myArrList.size());
        System.out.println("first element: " + myArrList.get(0));
        myArrList.clear();
        System.out.println("list cleared. first element: " + myArrList.get(0));

        myArrList.add("O");
        myArrList.add("T");
        myArrList.add("Q");
        myArrList.add("F");
        System.out.println("filled again: " + myArrList);
        myArrList.add(2, "C");
        System.out.println("inserted 'C' in second position: " + myArrList);

        myArrList.remove(2);
        System.out.println("element in second position removed: " + myArrList + " size: " + myArrList.size());

        System.out.println("'T' is in " + myArrList.indexOf("T") + " position");


        System.out.println("\nfirst list: "+myArrList);

        List<String> myDest = new MyArrayList<>();
        boolean b = Collections.addAll(myDest, "4","5","2","6","1","3");
        System.out.println("second list: "+myDest);
        Collections.copy(myDest, myArrList);
        System.out.println("first list copied into second: "+myDest);

        myDest.set(4, "C");
        myDest.set(5, "M");
        System.out.println("\nunsorted list: " + myDest);

        Collections.sort(myArrList, (o1, o2) -> o1.toString().compareTo(o2.toString()));
        System.out.println("sorted list: " + myDest);

        MyArrayList<Integer> myInteger = new MyArrayList<>();
        MyArrayList<Integer> myIntegerDest = new MyArrayList<>();
        b = Collections.addAll(myInteger, 3, 45, 125, 75, 15);
        b = Collections.addAll(myIntegerDest, 0, 1, 2, 3, 4, 5);
        Collections.copy(myIntegerDest, myInteger);

        System.out.println("\nunsorted list of Integers: " + myIntegerDest);
        Collections.sort(myIntegerDest, (Comparator<Integer>) (o1, o2) -> o1.compareTo(o2));
        System.out.println("sorted list of Integers: " + myIntegerDest);





    }

}

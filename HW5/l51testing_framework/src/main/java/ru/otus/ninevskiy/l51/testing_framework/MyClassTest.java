package ru.otus.ninevskiy.l51.testing_framework;
import ru.otus.ninevskiy.l51.testing_framework.annotations.*;

import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.assertNotNull;
import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.assertTrue;
import static ru.otus.ninevskiy.l51.testing_framework.TestingFramework.fail;

public class MyClassTest {
    private MyClass myClass;

    @Before_
    public void init(){
        myClass = new MyClass();
    }

    @Before_
    public void printStartMessage(){
        System.out.println("Next one starts...");
    }

    @Test_
    public void testIncrement(){
        myClass.increment();
        assertTrue(myClass.getI() == 16);
    }

    @Test_
    public void testSay(){
        assertNotNull(myClass.say());
    }

    @Test_
    public void testGetI(){
        if (myClass.getI() == 50){
            fail();
        }
    }

    @After_
    public void printFinalMessage(){
        System.out.println("\t...finished");
    }

}

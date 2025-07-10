package org.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Test2 implements DIInterface  {
/*
    @Autowired// meeka oone na Parameterized constructor eka call karanawanm
*/
    DI di;
/*
    public Test2(){
        System.out.println("Test2() constructor Called");
    }
*/

    //constructor through injection//constructur through ekata @Autowired annotation eka athwashya naa
    /*public Test2(DI di){
        this.di = di;
        System.out.println("Test2 Parameterized constructor Called");
    }*/
    /*When getBean(Test2.class) is called, Spring creates a Test2 object.

    It checks the constructor of Test2, sees it needs a DI object, and finds Test1 (which implements DI and is available as a component).

    So, Spring injects Test1 into Test2's constructor.*/
    /*@Override//override bcs Test2 implements from DIInterface That's the only reason otherwise this method not needed in constructor injection If we don't implement the DIInterface
    public void injected(DI test1) {

    }*/

    /*public void test(){
        di.sayHello();
    }*/





    //setter method through injection
    /*@Autowired//-- meeka dala tiyeddi dependency eka auto inject karagannawa setter method eka through
    public void setterMethod(DI di){
        this.di = di;
        System.out.println("setterMethod Called");
    }
    //No Need to override injected(DI test1) when DIInterface not implemented
    public void test(){
        di.sayHello();
    }*/




    //Interface through injection
    @Autowired//-- meeka dala tiyeddi dependency eka auto inject karagannawa overridden method eka through
    @Override
    public void injected(DI test1) {
        this.di = test1;
        System.out.println("Test2 Override method->Injected(DI test1) Called");
    }


    public void test(){
        di.sayHello();
    }


}

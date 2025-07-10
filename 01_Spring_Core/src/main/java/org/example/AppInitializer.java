package org.example;

import org.example.bean.MyConnection;
import org.example.bean.SpringBean;
import org.example.bean.TestBean1;
import org.example.bean.TestBean2;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        /*//class name
        SpringBean springBean1 = context.getBean(SpringBean.class);
        System.out.println(springBean1);

        //Bean Id
        SpringBean springBean2 = (SpringBean) context.getBean("springBean");
        System.out.println(springBean2);

        //Bean ID with class name
        TestBean1 testBean1 = (TestBean1) context.getBean("vinod", TestBean1.class);
        System.out.println(testBean1);*/



         /*TestBean1 testBean1 = context.getBean(TestBean1.class);
        System.out.println(testBean1);

        TestBean2 testBean2 = context.getBean(TestBean2.class);
        System.out.println(testBean2);*/

        /*System.out.println(springBean2);//spring bean default scope is singleton*/

        /*Runtime.getRuntime().addShutdownHook(new Thread(){
        @Override
            public void run(){
            context.close();
            }
        });
        context.registerShutdownHook();
        TestBean2 testBean2 = context.getBean(TestBean2.class);
        System.out.println(testBean2);  */

        /////////////Api Hadapan nati third party class walain Beans hadagaddi///////////////////

        /*MyConnection myConnection = context.getBean(MyConnection.class);
        System.out.println(myConnection);

        //beanId
        MyConnection myConnection1 = (MyConnection) context.getBean("fernando");//myConnection
        System.out.println(myConnection1);

        //beanId with class name
        MyConnection myConnection2 = context.getBean("fernando", MyConnection.class);//myConnection,MyConnection.class
        System.out.println(myConnection2);*/
        TestBean1 bean1= context.getBean(TestBean1.class);
        TestBean1 bean2= context.getBean(TestBean1.class);
        System.out.println(bean1);
        System.out.println(bean2);//bean1 and bean2 are different objects because scope is prototype

        MyConnection myConnection1=context.getBean(MyConnection.class);
        MyConnection myConnection2=context.getBean(MyConnection.class);
        System.out.println(myConnection1);
        System.out.println(myConnection2);//myConnection1 and myConnection2 are same object because default scope is singleton


        context.registerShutdownHook();//@Override --> public void run(){} eke short version ekk

    }
}

package org.example.bean;

import org.springframework.stereotype.Component;

@Component//Spring context ekaya meeka bean ekak kiyala identify karanawa
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean Constructor Called");
    }

    public void test(){
        System.out.println("SpringBean test method called");
    }
}

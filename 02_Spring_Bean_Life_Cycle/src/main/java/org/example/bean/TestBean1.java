package org.example.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TestBean1 {
    public TestBean1() {
        System.out.println("TestBean1 Constructor Called");
    }
}

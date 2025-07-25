package org.example.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl2 implements Agreement {
    public Girl2() {
        System.out.println("Girl2 Constructor Called");
    }

    @Override
    public void chat() {
        System.out.println("Girl2 chatting....");
    }
}

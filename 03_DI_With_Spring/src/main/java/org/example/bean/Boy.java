package org.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {//Property Injection
    @Autowired//Runtime Dependency Injection(Adala type ekenma dependency eka inject wenawa. multiple inheritence nathnm meeka witarak ati)
    @Qualifier("girl1")//Qualified Dependency Injection
    Agreement girl;//= new girl1()

    public Boy() {
        System.out.println("Boy Constructor Called");
    }

    public void chatWithGirl(){
        girl.chat();

    }
}

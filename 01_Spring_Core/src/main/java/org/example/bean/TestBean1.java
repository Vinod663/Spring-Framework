package org.example.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("vinod")
/*@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)*/ // This bean will be created as a new instance each time it is requested
@Scope("prototype") // This bean will be created as a new instance each time it is requested// uda eka wageema tama
public class TestBean1 {
    public TestBean1() {
        System.out.println("TestBean1 Constructor Called");
    }
}

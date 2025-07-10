package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("Vinod")//Instant properties walatath runtime values inject karaganna puluwan
    private String name;

    @Value("ascjjsachbiuwdbsbhdh")
    private String key;

    /*public SpringBean() {
        System.out.println("SpringBean constructor called "+name);//null enawa sampurana bean eka hadila nati wunama
        System.out.println("SpringBean constructor called "+key);
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBean afterPropertiesSet called, name: "+name);//me weddi bean eka initialize wela na samournayen e nisa properties walata values add wen na
        System.out.println("SpringBean afterPropertiesSet called, key: "+key);
    }



    public SpringBean() {
        System.out.println("SpringBean default constructor called");
    }

    //meeke property ekk tiyana nisa default contructor eka nathnm error rkk enawaa, Mokada mulinma object eka create welaa passe tama properties tika populate karaganne
    @Autowired(required = false)
    public SpringBean(@Value("Vinod-Niloshana") String name,@Value("2") int number,@Value("true") boolean value) { //@Value annotaion eken value ekak inject karanna puluwan property ekata etakota default constructor eka oone na
        System.out.println("SpringBean constructor called"+name+" "+number+" "+value);
    }



    @Autowired(required = false)
        //Runtime mona constructor ekata inject karaganna oone(Autowire karaganna oone) kiyala denna puluwan meeken
        //Only one constructor can have @Autowired annotation when dont use required
        //@Autowired(required = false) constructors dekema tiyeddi inject karaganne parameter count eka wadima constructor eka
    public SpringBean(@Value("Vinod")String name,@Value("3") int number){
        System.out.println("SpringBean constructor called "+name+" "+number);
    }
}

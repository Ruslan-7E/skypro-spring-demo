package pro.sky.skyprospringdemo.stuff;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    public String hello() {
        return "hello";
    }


    public String answerHello(String userName) {
        return "<b>hello</b> " + userName;
    }
}

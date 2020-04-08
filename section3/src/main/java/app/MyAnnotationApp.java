package app;

import concert.ConcertConfig;
import concert.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Performance concert = ctx.getBean("concert", Performance.class);
        concert.perform();
//        Encoreable concert = ctx.getBean("concert", Encoreable.class);
//        concert.performEncore();
    }
}

package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        Object object = ctx.getBean(Object.class);
        Object object2 = ctx.getBean(Object.class);

        System.out.println("-----Hashcode of Object Bean-----");
        System.out.println(object.hashCode());
        System.out.println(object2.hashCode());

        final AnotherObject anotherObject = ctx.getBean(AnotherObject.class);
        final AnotherObject anotherObject2 = ctx.getBean(AnotherObject.class);

        System.out.println("-----Hashcode of Another Object Bean-----");
        System.out.println(anotherObject.hashCode());
        System.out.println(anotherObject2.hashCode());
        System.out.println();

        ctx.close();
    }
}

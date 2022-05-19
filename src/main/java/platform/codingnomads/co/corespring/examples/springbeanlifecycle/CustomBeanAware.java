package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanAware implements BeanNameAware {

    @Override
    public void setBeanName(@NonNull String name) {
        System.out.println("This is a custom message for setBeanName" );
    }
}

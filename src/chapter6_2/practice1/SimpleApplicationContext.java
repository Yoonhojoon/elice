package chapter6_2.practice1;

import java.util.HashMap;
import java.util.Map;

interface ApplicationContext {
    Object getBean(String name);
}

public class SimpleApplicationContext implements ApplicationContext {
    private Map<String, Object> beans = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beans.put(name, bean);
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
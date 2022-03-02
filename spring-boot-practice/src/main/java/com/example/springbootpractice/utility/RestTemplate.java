package com.example.springbootpractice.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.io.Serial;
import java.io.Serializable;

@Component
public class RestTemplate implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private RestTemplate() {
    }

    // private static inner class, created only when called
    private static class RestTemplateHolder {
        public static final RestTemplate INSTANCE = new RestTemplate();
    }

    public static RestTemplate getInstance() {
        return RestTemplateHolder.INSTANCE;
    }

    // This method will be invoked when you de-serialize the object. Inside of this method, you must return the existing instance to ensure a single instance application wide.
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
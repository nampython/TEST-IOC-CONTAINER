package org.ioc.tests.bean;

import org.ioc.stereotype.Component;

public class BeanInterface1Impl implements BeanInterface {
    @Override
    public String getValue() {
        return "impl1 bean";
    }
}

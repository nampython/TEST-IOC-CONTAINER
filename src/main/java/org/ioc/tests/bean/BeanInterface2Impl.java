package org.ioc.tests.bean;

import org.ioc.stereotype.Component;

public class BeanInterface2Impl implements BeanInterface {
    @Override
    public String getValue() {
        return "impl2 bean";
    }
}

package org.ioc.tests.scope.prototype;

public class PrototypeBean1 implements PrototypeBean {
    private static int id = 0;

    private int instanceId;


    public PrototypeBean1() {
        this.instanceId = ++id;
    }

    public int getIdentity() {
        return this.instanceId;
    }
}

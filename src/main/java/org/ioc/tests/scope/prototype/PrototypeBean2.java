package org.ioc.tests.scope.prototype;

public class PrototypeBean2 implements PrototypeBean {
    private static int id = 55;

    private int instanceId;


    public PrototypeBean2() {
        this.instanceId = ++id;
    }

    public int getIdentity() {
        return this.instanceId;
    }
}

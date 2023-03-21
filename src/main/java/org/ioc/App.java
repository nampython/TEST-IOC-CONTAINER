package org.ioc;

import org.ioc.config.Test;
import org.ioc.contex.ApplicationContext;
import org.ioc.engine.ComponentModel;
import org.ioc.stereotype.Component;
import org.ioc.stereotype.StartUp;
import org.ioc.tests.bean.BeanInterface;

@Component
public class App {
    public static ApplicationContext applicationContext;

    public static void main(String[] arg) {
        InitApplicationContext.run(App.class);
    }

    @StartUp
    public void appStartup(ApplicationContext applicationContext) {
        App.applicationContext = applicationContext;
        System.out.println("Application Started");
        for (ComponentModel implementation : applicationContext.getImplementations(Test.class)) {
            this.runTest(implementation);
        }
    }

    private void runTest(ComponentModel componentModel) {
        final Test instance = (Test) componentModel.getInstance();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Running tests from: " + componentModel.getComponentType().getName());
        instance.runTest();
        System.out.println("\n");
    }
}

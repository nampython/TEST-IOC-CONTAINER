package org.ioc;

import org.ioc.config.Test;
import org.ioc.configuration.Configuration;
import org.ioc.contex.ApplicationContext;
import org.ioc.deps.CircDepTestService;
import org.ioc.engine.ComponentModel;
import org.ioc.events.CustomScopeEventHandler;
import org.ioc.exception.CircularDependencyException;
import org.ioc.stereotype.Component;
import org.ioc.stereotype.StartUp;
import org.ioc.tests.customannotations.CustomComponent;
import org.ioc.tests.resolver.Producers.StringConfigProducer;
import org.ioc.tests.resolver.Producers.StringConfigProducerTwo;

@Component
public class App {
    public static ApplicationContext applicationContext;

    public static void main(String[] arg) {
        Configuration configs = new Configuration()
                .instantiations()
                .addDependencyResolver(new StringConfigProducer())
                .addDependencyResolver(new StringConfigProducerTwo())
                .and()
                .scanning()
                .addComponentDetailsCreatedCallback(new CustomScopeEventHandler())
                .addComponentAnnotation(CustomComponent.class)
                .and();
        InitApplicationContext.run(App.class, configs);
        runCircularDependencyTest(configs);

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
    private static void runCircularDependencyTest(Configuration config) {
        System.out.println("Running Circular dependency test");

        config.scanning().addComponentAnnotation(CircDepTestService.class);

        try {
            InitApplicationContext.run(App.class, config);
        } catch (CircularDependencyException ex) {
            System.out.println("Test passed successfully!!!");
            System.out.println(ex.getMessage());
        }
    }
}

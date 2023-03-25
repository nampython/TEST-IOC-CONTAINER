package org.ioc.tests.resolver.Producers;



import org.ioc.engine.DependencyParam;
import org.ioc.support.DependencyResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringConfigProducer implements DependencyResolver {

    private static final List<String> supportedCommands = new ArrayList<>() {{
        add("opt1");
        add("opt2");
    }};

    @Override
    public boolean canResolve(DependencyParam dependencyParam) {
        return dependencyParam.getDependencyType() == String.class && hasAnnotation(dependencyParam)
                && supportedCommands.contains(getAnnotation(dependencyParam).value());
    }

    private boolean hasAnnotation(DependencyParam dependencyParam) {
        return Arrays.stream(dependencyParam.getAnnotations())
                .anyMatch(a -> a.annotationType() == Resource.class);
    }

    @Override
    public Object resolve(DependencyParam dependencyParam) {
        final String val = getAnnotation(dependencyParam).value();

        switch (val.toLowerCase()) {
            case "opt1":
                return "1";
            case "opt2":
                return "2";
        }

        return null;
    }

    private Resource getAnnotation(DependencyParam dependencyParam) {
        return (Resource) Arrays.stream(dependencyParam.getAnnotations())
                .filter(a -> a.annotationType() == Resource.class)
                .findFirst().orElseThrow(RuntimeException::new);
    }
}

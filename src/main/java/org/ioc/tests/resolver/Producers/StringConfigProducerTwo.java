package org.ioc.tests.resolver.Producers;

import org.ioc.engine.DependencyParam;
import org.ioc.support.DependencyResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringConfigProducerTwo implements DependencyResolver {

    private static final List<String> supportedCommands = new ArrayList<>() {{
        add("opt3");
    }};

    @Override
    public boolean canResolve(DependencyParam dependencyParam) {
        boolean isMatch = dependencyParam.getDependencyType() == String.class;
        boolean matchAnno = Arrays.stream(dependencyParam.getAnnotations()).anyMatch(annotation -> annotation.annotationType() == Resource.class);
        return isMatch && matchAnno
                && supportedCommands.contains(getAnnotation(dependencyParam).value());
    }
    private boolean hasAnnotation(DependencyParam dependencyParam) {
        return Arrays.stream(dependencyParam.getAnnotations())
                .anyMatch(a -> a.annotationType() == Resource.class);
    }

    @Override
    public Object resolve(DependencyParam dependencyParam) {
        final String val = getAnnotation(dependencyParam).value();

        if ("opt3".equals(val.toLowerCase())) {
            return "3";
        }

        return null;
    }

    private Resource getAnnotation(DependencyParam dependencyParam) {
        return (Resource) Arrays.stream(dependencyParam.getAnnotations())
                .filter(a -> a.annotationType() == Resource.class)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

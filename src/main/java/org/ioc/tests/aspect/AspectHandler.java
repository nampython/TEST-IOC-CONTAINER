package org.ioc.tests.aspect;

import org.ioc.engine.ComponentMethodAspectHandler;
import org.ioc.engine.MethodInvocationChain;
import org.ioc.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AspectHandler implements ComponentMethodAspectHandler<AspectAnnotation> {
    @Override
    public Object proceed(AspectAnnotation aspectAnnotation, Method method, Object[] objects, MethodInvocationChain methodInvocationChain) throws Exception {
        return aspectAnnotation.value();
    }
}


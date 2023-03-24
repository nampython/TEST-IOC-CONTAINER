package org.ioc.tests.customannotations;


@CustomComponent
public class CustomAnnotatedHomeServiceImpl implements CustomAnnotatedHomeService {

    private String postConstructVal;

    @Override
    public String getIdentification() {
        return "customAnnotatedHomeService1";
    }

    @Override
    public String getPostConstructValue() {
        return this.postConstructVal;
    }

    @CustomPostConstruct
    void init() {
        this.postConstructVal = "customPostConstruct";
    }
}

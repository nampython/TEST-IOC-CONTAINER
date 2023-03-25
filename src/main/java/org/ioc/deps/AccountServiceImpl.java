package org.ioc.deps;


@CircDepTestService
public class AccountServiceImpl implements AccountService {

    private final ProductService productService;

    public AccountServiceImpl(ProductService productService) {
        this.productService = productService;
    }
}

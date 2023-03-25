package org.ioc.deps;


@CircDepTestService
public class CategoryServiceImpl implements CategoryService {

    private final AccountService accountService;

    public CategoryServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }
}

package org.ioc.deps;


@CircDepTestService
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;

    public ProductServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}

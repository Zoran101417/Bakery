package bakery.packaging.app.service;

import bakery.packaging.app.model.GetProductsOutput;
import bakery.packaging.app.model.GetProductsSearchInput;

public interface ProductService {
    GetProductsOutput getProducts(GetProductsSearchInput searchInput);
}

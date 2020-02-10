package bakery.packaging.app.service;

import bakery.packaging.app.model.GetProductsOutput;
import bakery.packaging.app.model.GetProductsSearchInput;
import bakery.packaging.app.model.Product;
import bakery.packaging.app.utils.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    @Override
    public GetProductsOutput getProducts(GetProductsSearchInput searchInput) {
        List<String> productCodesToFilter = searchInput.getProductCodes();


        List<Product> products = getDefaultProducts();

        List<Product> filteredProducts = products.stream()
                .filter(product -> productCodesToFilter.contains(product.getCode()))
                .collect(Collectors.toList());

        GetProductsOutput output = new GetProductsOutput();
        output.setProducts(filteredProducts);

        return output;
    }

    private List<Product> getDefaultProducts() {
        return Constants.CUSTOM_PRODUCTS;
    }
}

package com.example.module.supply;

import com.example.module.supply.model.Product;
import com.example.module.supply.model.ProductCategory;
import com.example.module.supply.model.Supplier;

import java.util.List;

public interface SupplyChainMapper {

    List<Supplier> selectSuppliers();

    List<Product> selectProducts();

    List<ProductCategory> selectProductCategorys();
}

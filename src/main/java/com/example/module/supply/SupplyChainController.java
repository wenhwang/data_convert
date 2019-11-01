package com.example.module.supply;

import com.example.module.supply.model.Product;
import com.example.module.supply.model.ProductCategory;
import com.example.module.supply.model.Supplier;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "供应链数据维护")
@RequestMapping("/supply")
public class SupplyChainController {

    @Autowired
    private SupplyChainService supplyChainService;

    @ApiOperation("供应商")
    @GetMapping("/suppliers")
    public Result<List<Supplier>> suppliersHandler() {
        return Result.<List<Supplier>>success(supplyChainService.suppliersHandler());
    }

    @ApiOperation("商品列表")
    @GetMapping("/products")
    public Result<List<Product>> productsHandler() {
        return Result.<List<Product>>success(supplyChainService.productsHandler());
    }


    @ApiOperation("商品分类")
    @GetMapping("/productCategory")
    public Result<List<ProductCategory>> productCategoryHandler() {
        return Result.<List<ProductCategory>>success(supplyChainService.productCategoryHandler());
    }


}

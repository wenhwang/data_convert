package com.example.module.supply;

import com.example.module.supply.model.MapAccount;
import com.example.module.supply.model.Product;
import com.example.module.supply.model.ProductCategory;
import com.example.module.supply.model.Supplier;
import com.example.utils.Documents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class SupplyChainService {

    private static final String TABEL_SUPPLY_SUPPLIER = Documents.SUPPLY.SUPPLY_SUPPLIER_DOC.docName;
    private static final String TABEL_SUPPLY_COMMODITY = Documents.SUPPLY.SUPPLY_COMMODITY_DOC.docName;
    private static final String TABEL_SUPPLY_COMMODITY_CATEGORY = Documents.SUPPLY.SUPPLY_COMMODITY_CATEGORY_DOC.docName;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private SupplyChainMapper supplyChainMapper;

    @Transactional
    public List<Supplier> suppliersHandler() {
        List<Supplier> supplierList = supplyChainMapper.selectSuppliers();
        supplierList.parallelStream().forEach(supplier -> {

            List<MapAccount> accountLists = new ArrayList<>();

            accountLists.add(new MapAccount(supplier.getAccountName(),supplier.getBankName(),supplier.getBankAccount()));
            supplier.setAccountList(accountLists);
        });

        log.info("已查询供应商数据:{} 条记录", supplierList.size());
        if (!Objects.isNull(supplierList)) {
            mongoTemplate.insert(supplierList, TABEL_SUPPLY_SUPPLIER);
            log.info("保存数据 ---> :{} ", TABEL_SUPPLY_SUPPLIER);
        }
        return supplierList;
    }

    @Transactional
    public List<Product> productsHandler() {
        List<Product> products = supplyChainMapper.selectProducts();
        log.info("已查询商品列表数据:{} 条记录", products.size());
        if (!Objects.isNull(products)) {
           // mongoTemplate.insert(products, TABEL_SUPPLY_COMMODITY);
            log.info("保存数据 ---> :{} ", TABEL_SUPPLY_COMMODITY);
        }
        return products;
    }

    @Transactional
    public List<ProductCategory> productCategoryHandler() {
        List<ProductCategory> categoryList = supplyChainMapper.selectProductCategorys();
        log.info("已查询商品分类数据:{} 条记录", categoryList.size());
        if (!Objects.isNull(categoryList)) {
            mongoTemplate.insert(categoryList, TABEL_SUPPLY_COMMODITY_CATEGORY);
            log.info("保存数据 ---> :{} ", TABEL_SUPPLY_COMMODITY_CATEGORY);
        }
        return categoryList;
    }
}

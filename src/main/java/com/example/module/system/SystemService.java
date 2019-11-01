package com.example.module.system;

import com.example.module.HelperService;
import com.example.module.system.model.MapCode;
import com.example.module.system.model.MapCodeCategory;
import com.example.module.system.model.MapcodeParam;
import com.example.module.system.model.SysOrg;
import com.example.utils.Documents;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SystemService {

    @Autowired
    private MongoTemplate mongoTemplate;


    public MapCodeCategory insertCategory(String label, String categoryName, String parentId) {
        MapCodeCategory category = MapCodeCategory.getInstace(label, categoryName, parentId);
        MapCodeCategory mapCodeCategory = mongoTemplate.save(category, "sys_dict_category");
        return mapCodeCategory;
    }

    public List<MapCode> insertCategoryItems(MapcodeParam param) {
        List<MapCode> mapCodes = Arrays.asList(param.getDictNames()).stream()
                .map(s -> MapCode.getInstace(s, param.getLabel(), param.getCategoryId()))
                .collect(Collectors.toList());
        List<MapCode> sysDicts = (List<MapCode>) mongoTemplate.insert(mapCodes, "sys_dict");
        return sysDicts;
    }

    //清除所有的导入数据
    public List<String> clearAll() {
        List<String> docs =  new ArrayList<>();
        Query query = Query.query(Criteria.where("dataSource").is("EPMS"));
        log.info("| remove SUPPLY data of import:");
        EnumSet.allOf(Documents.SUPPLY.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        log.info("| remove CONTRACT data of import");
        EnumSet.allOf(Documents.CONTRACT.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        log.info("| remove CUSTOMER data of import");
        EnumSet.allOf(Documents.CUSTOMER.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        log.info("| remove FINANCE data of import");
        EnumSet.allOf(Documents.FINANCE.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        log.info("| remove PROJECT data of import");
        EnumSet.allOf(Documents.PROJECT.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        log.info("| remove RESOURCE data of import");
        EnumSet.allOf(Documents.RESOURCE.class).stream().map(t -> t.docName).forEach(d-> {
            DeleteResult remove = mongoTemplate.remove(query, d);
            log.info("|");
            log.info("|____ remove {} data of {} ",remove.getDeletedCount(),d);
            docs.add(d);
        });
        return docs;
    }
}

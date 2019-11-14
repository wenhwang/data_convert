package com.example.config;

import com.example.module.HelperService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class CreateByFieldHandler implements TypeHandler<String>{


    HelperService helperService = SpringContextHolder.getBean(HelperService.class);
    List<Map> allUserNames = helperService.findAllUserName();

    /**
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型
     * @param preparedStatement 当前的PreparedStatement对象
     * @param i 当前参数的位置
     * @param parameter 当前参数的Java对象
     * @param jdbcType 当前参数的数据库类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String parameter, JdbcType jdbcType) throws SQLException {

    }

    /**
     * 获取数据结果集时如何把数据库类型转换为对应的Java类型
     * @param resultSet 当前的结果集
     * @param columnName 当前的字段名称
     * @return 转换后的Java对象
     * @throws SQLException
     */
    @Override
    public String getResult(ResultSet resultSet, String columnName) throws SQLException {
        String realName = resultSet.getString(columnName);
        realName = StringUtils.isEmpty(realName) ? StringUtils.EMPTY : realName;
        String finalRealName = realName;
        String userName = allUserNames.stream()
                .filter(r -> finalRealName.equals(r.get("realName")))
                .findFirst()
                .orElseGet(() -> {Map<String,String> defaultMap = new HashMap<>();defaultMap.put("username",finalRealName);return defaultMap;})
                .get("username")+"";
        // String userName = helperService.findUserNameByRealName(realName);
        log.debug("createBy {} ---> {}",realName,userName);
        return userName;
    }

    /**
     * 通过字段位置获取字段数据时把数据库类型转换为对应的Java类型
     * @param resultSet 当前的结果集
     * @param columnIndex 当前字段的位置
     * @return 转换后的Java对象
     * @throws SQLException
     */
    @Override
    public String getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String realName = resultSet.getString(columnIndex);
        String userName = helperService.findUserNameByRealName(realName);
        log.info("createBy {} ---> {}",realName,userName);
        return userName;
    }

    /**
     * 调用存储过程后把数据库类型的数据转换为对应的Java类型
     * @param callableStatement 当前的CallableStatement执行后的CallableStatement
     * @param columnIndex 当前输出参数的位置
     * @return
     * @throws SQLException
     */
    @Override
    public String getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return null;
    }
}

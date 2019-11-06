package com.example.module.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data_convert
 * @description:
 * @author: Administrator
 * @create: 2019-11-04 08:52
 **/
@Slf4j
public class Test {

    public static void main(String[] args) {

        String pathName = "E:\\work_spaces\\sources\\data_convert\\src\\main\\resources\\files\\import-1.xlsx";

        EasyExcel.read(pathName, DemoData.class,new TestReadListener()).sheet().doRead();
    }


    static class TestReadListener extends AnalysisEventListener<DemoData> {
        private static final int BATCH_COUNT = 2000;
        List<DemoData> list = new ArrayList<DemoData>();
        @Override
        public void invoke(DemoData data, AnalysisContext analysisContext) {
            log.info("解析到一条数据:{}",data);
            list.add(data);
            if (list.size() >= BATCH_COUNT) {
                saveData();
                list.clear();
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            saveData();
            log.info("所有数据解析完成！");
        }


        private void saveData() {
            log.info("{}条数据，开始存储数据库！", list.size());
            log.info("存储数据库成功！");
        }

    }
}

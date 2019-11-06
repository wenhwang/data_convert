package com.example.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.OutputStream;
import java.util.List;

public class ExcelUtils {

    public static void saveToFile(String filePath,String sheetName,Class head, List<? extends Object> data) {

        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short)10);
        headWriteCellStyle.setWriteFont(headWriteFont);

        // 内容
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short)10);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle,contentWriteCellStyle);

        EasyExcel.write(filePath, head).registerWriteHandler(horizontalCellStyleStrategy).sheet(sheetName).doWrite(data);
    }

    public static void saveToFile(OutputStream stream, String sheetName, Class head, List<? extends Object> data) {
        EasyExcel.write(stream, head).sheet(sheetName).doWrite(data);
    }
}

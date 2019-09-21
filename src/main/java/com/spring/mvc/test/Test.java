package com.spring.mvc.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String []arg) throws IOException, InvalidFormatException {

        File file = new File("E:\\2019年5月份 全市地方财政收入完成情况（修改上年口径）.xlsx");
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        List<Map> list = new ArrayList<>();
        for (int i = 3; i < 27; i++) {

            Row row = sheet.getRow(i);
            String cell1 = getCellValue(row.getCell(0));
            String cell2 = getCellValue(row.getCell(1));
            String cell3 = getCellValue(row.getCell(2));
            String cell4 = getCellValue(row.getCell(3));
            String cell5 = getCellValue(row.getCell(4));
            String cell6 = getCellValue(row.getCell(5));
            String cell7 = getCellValue(row.getCell(6));
            String cell8 = getCellValue(row.getCell(7));

            Map map = new HashMap();
            map.put("cell1", cell1);
            map.put("cell2", cell2);
            map.put("cell3", cell3);
            map.put("cell4", cell4);
            map.put("cell5", cell5);
            map.put("cell6", cell6);
            map.put("cell7", cell7);
            map.put("cell8", cell8);
            list.add(map);
        }

        Workbook workbook1 = new HSSFWorkbook();
        Sheet sheet1 = workbook1.createSheet();
        for (int i = 0; i < list.size(); i++) {
            Map map1 = list.get(i);
            Row row1 = sheet1.createRow(i);

            row1.createCell(0).setCellValue(map1.get("cell1").toString());
            row1.createCell(1).setCellValue(map1.get("cell2").toString());
            row1.createCell(2).setCellValue(map1.get("cell3").toString());
            row1.createCell(3).setCellValue(map1.get("cell4").toString());
            row1.createCell(4).setCellValue(map1.get("cell5").toString());
            row1.createCell(5).setCellValue(map1.get("cell6").toString());
            row1.createCell(6).setCellValue(map1.get("cell7").toString());
            row1.createCell(7).setCellValue(map1.get("cell8").toString());

        }

        FileOutputStream fileout = new FileOutputStream("d:\\结果.xls");
        workbook1.write(fileout);
        fileout.close();
        System.out.println("写入完成!");

    }

    public static String getCellValue(Cell cell){

        DecimalFormat df = new DecimalFormat("0.0");
        String var = null;
        if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
            var = cell.getStringCellValue();
        }else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            var = df.format(cell.getNumericCellValue());
        }else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA){
            try{
                var = df.format(cell.getNumericCellValue());
            }catch (Exception e){
                var = "0";
            }
        }else {
            var = "";
        }
        return var;
    }
}
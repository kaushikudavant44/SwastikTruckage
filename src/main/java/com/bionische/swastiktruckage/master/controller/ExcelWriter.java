package com.bionische.swastiktruckage.master.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*import org.apache.poi.openxml4j.exceptions.InvalidFormatException;*/
import org.apache.poi.ss.usermodel.*;
/*import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.model.Employee;
import com.bionische.swastiktruckage.model.GetPaymentDetails;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelWriter {
	
	    public static void paymentPendingExcel(List<LrBilling> list) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"LR No", "Consignee", "Consignor", "LR Date","Goods","Truck No","Quantity","Freight","Weight","Gst","LocalTempo","Hamali","PaymentBy","Total"};
	        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("LrBilling");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data'
	    
	        int rowNum = 1;
	        for(LrBilling billing: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(billing.getLrNo());

	            row.createCell(1)
	                    .setCellValue(billing.getConsigneeName());

	            row.createCell(2)
                .setCellValue(billing.getConsignorName());

	            row.createCell(3)
	                    .setCellValue(billing.getLrDate());
	            
	            row.createCell(4)
                .setCellValue(billing.getGoods());
	            
	            row.createCell(5)
                .setCellValue(billing.getTruckNo());
	            
	            row.createCell(6)
                .setCellValue(billing.getQuantity());
	            
	            row.createCell(7)
                .setCellValue(billing.getFreight());
	            
	            row.createCell(8)
                .setCellValue(billing.getWeight());
	            
	            row.createCell(9)
                .setCellValue(billing.getGst());
	            
	            row.createCell(10)
                .setCellValue(billing.getLocalTempo());
	            
	            row.createCell(11)
                .setCellValue(billing.getHamali());
	            
	            if(billing.getPaymentBy()==0)
	            {
	            	 row.createCell(12)
	                 .setCellValue("Consignee");
	            }
	            else
	            {
	            	 row.createCell(12)
	                 .setCellValue("Consigner");
	            }
	            
	            row.createCell(13)
                .setCellValue(billing.getTotal());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("D:\\first.xls");
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	    }
	    
	    public static void lrExcel(List<TransactionLrHeader> list) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"LR No","LR Date","Payment By","Total"};
	        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("TransactionLrHeader");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data'
	    
	        int rowNum = 1;
	        for(TransactionLrHeader lr: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(lr.getLrNo());

	            row.createCell(1)
	                    .setCellValue(lr.getLrDate());

	            
	            if(lr.getPaymentBy()==0)
	            {
	            	 row.createCell(2)
	                 .setCellValue("Consignee");
	            }
	            else
	            {
	            	 row.createCell(2)
	                 .setCellValue("Consigner");
	            }
	            
	            row.createCell(3)
                .setCellValue(lr.getTotal());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("D:\\second.xls");
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	    }
	    
	    
	    public static void totalBillExcel(List<GetPaymentDetails> list) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"Bill No","Bill Date","Bill To","Total","Paid"};
	        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("TransactionBillHeader");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

	        // Create Other rows and cells with employees data'
	    
	        int rowNum = 1;
	        for(GetPaymentDetails billHeader: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(billHeader.getBillNo());

	            row.createCell(1)
	                    .setCellValue(billHeader.getBillDate());

	            
	            if(billHeader.getBillPayableBy()==1)
	            {
	            	 row.createCell(2).setCellValue("Cash");
	            }
	            else if(billHeader.getBillPayableBy()==2)
	            {
	            	 row.createCell(2) .setCellValue("Check");	                
	            }
	            else
	            {
	            	 row.createCell(2).setCellValue("NEFT");		                 
	            }            
	            row.createCell(4).setCellValue(billHeader.getClientName()); 
	            row.createCell(5).setCellValue(billHeader.getBillTotal()); 
	            row.createCell(6).setCellValue(billHeader.getAmountReceived());                
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("D:\\third.xls");
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	    }
	    
	    public static void collectionExcel(List<TransactionLrCollection> list) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"Lr No","Bill Date","Payment Mode","Total"};
	        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("TransactionLrCollection");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create a Row
	        Row headerRow = sheet.createRow(0);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	        // Create Cell Style for formatting Date
	       /* CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));*/

	        // Create Other rows and cells with employees data'
	    
	        int rowNum = 1;
	        for(TransactionLrCollection collection: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(collection.getLrNo());

	            row.createCell(1)
	                    .setCellValue(collection.getCreateDate());

	            
	            if(collection.getPaymentMode()==1)
	            {
	            	 row.createCell(2)
	                 .setCellValue("Cash");
	            }
	            else if(collection.getPaymentMode()==2)
	            {
	            	 row.createCell(2)
	                 .setCellValue("Check");
	            }
	            else
	            {
	            	 row.createCell(2)
	                 .setCellValue("NEFT");	
	            }
	            
	            row.createCell(3)
                .setCellValue(collection.getTotal());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream("D:\\fourth.xls");
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	    }
	    
	    
	}



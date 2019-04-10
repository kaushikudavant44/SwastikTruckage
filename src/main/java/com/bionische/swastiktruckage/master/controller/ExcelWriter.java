package com.bionische.swastiktruckage.master.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*import org.apache.poi.openxml4j.exceptions.InvalidFormatException;*/
import org.apache.poi.ss.usermodel.*;
/*import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.springframework.util.FileCopyUtils;

import com.bionische.swastiktruckage.mastermodel.GetAllLrDetails;
import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.model.Employee;
import com.bionische.swastiktruckage.model.GetAllMemo;
import com.bionische.swastiktruckage.model.GetLrDetailsOfClient;
import com.bionische.swastiktruckage.model.GetPaymentDetails;
import com.bionische.swastiktruckage.model.GetVoucherReport;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ExcelWriter {
	
	    public static void paymentPendingExcel(List<LrBilling> list,HttpServletResponse response ) throws IOException {
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
	                 .setCellValue("To Be Billed");
	            }
	            else if(billing.getPaymentBy()==1)
	            {
	            	 row.createCell(12)
	                 .setCellValue("To Pay");
	            }else {
	            	 row.createCell(12)
	                 .setCellValue("Paid");
	            }
	            
	            row.createCell(13)
                .setCellValue(billing.getTotal());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+" PendingPayment.xls";
	       
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();
	       
	        // Closing the workbook
	        workbook.close();
	        
	        //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	    
	    public static void lrExcel(List<GetAllLrDetails> list,HttpServletResponse response ) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"LR No","LR Date","Consignor","Consignee","Payment By","Particular","Total"};
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
	        for(GetAllLrDetails lr: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(lr.getLrNo());

	            row.createCell(1)
	                    .setCellValue(lr.getLrDate());
	            
	            row.createCell(2)
                .setCellValue(lr.getConsignor());
	            
	            row.createCell(3)
                .setCellValue(lr.getConsignee());
	            
	            if(lr.getPaymentBy().equals("0"))
	            {
	            	 row.createCell(4)
	                 .setCellValue("To Be Billed");
	            }else if(lr.getPaymentBy().equals("1")) 
	            {
	            	 row.createCell(4)
	                 .setCellValue("To Pay");
	            }else {
	            	row.createCell(4)
	                 .setCellValue("Paid");
	            }
	            row.createCell(5)
                .setCellValue(lr.getParticular());
	            
	            row.createCell(6)
                .setCellValue(lr.getAmount());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // Write the output to a file
	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" LR.xls";
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	    
	    
	    public static void totalBillExcel(List<GetPaymentDetails> list,HttpServletResponse response ) throws IOException {
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
	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" Bill.xls";
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	    
	    public static void collectionExcel(List<TransactionLrCollection> list,HttpServletResponse response ) throws IOException {
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

	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" Collection.xls";
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	
	    public static void clientLrListExcel(List<GetLrDetailsOfClient> list,HttpServletResponse response ) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	        String[] columns = {"LR No","LR Date", "Consignee", "Consignor","PaymentBy", "Freight","LocalTempo","Hamali","Total"};
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
	        for(GetLrDetailsOfClient billing: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(billing.getLrNo());
	            
	            row.createCell(1)
                .setCellValue(billing.getLrDate());

	            row.createCell(2)
	                    .setCellValue(billing.getConsigneeName());

	            row.createCell(3)
                .setCellValue(billing.getConsignorName());
	            
	            if(billing.getPaymentBy()==0)
	            {
	            	 row.createCell(4)
	                 .setCellValue("To Be Billed");
	            }
	            else if(billing.getPaymentBy()==1)
	            {
	            	 row.createCell(4)
	                 .setCellValue("To Pay");
	            }else {
	            	
	            	row.createCell(4)
	                 .setCellValue("Paid");
	            }

	            row.createCell(5)
                .setCellValue(billing.getFreight());
	            
	            row.createCell(6)
                .setCellValue(billing.getLocalTempo());
	            
	            row.createCell(7)
                .setCellValue(billing.getHamali());
	                        
	            row.createCell(8)
                .setCellValue(billing.getTotal());
	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" ClientLR.xls";
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	    
	    public static void voucherExcel(List<GetVoucherReport> list,HttpServletResponse response ) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	    	
	        String[] columns = {"Memo No","Date","Vehicle No", "Office Address", "To Address"};
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
	        for(GetVoucherReport billing: list) {
	            Row row = sheet.createRow(rowNum++);

	            row.createCell(0)
	                    .setCellValue(billing.getMemoNo());
	            
	            row.createCell(1)
                .setCellValue(billing.getCreateDate());
	            
	            row.createCell(2)
                .setCellValue(billing.getVehNo());

	            row.createCell(3)
	                    .setCellValue(billing.getOfficeAddress());

	            row.createCell(4)
                .setCellValue(billing.getToAddress());
	                                    
	         	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
	       
	        String fileName = "D:\\"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" Voucher.xls";

	        System.out.println("fileName:"+fileName);
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	    
	    
	    
	    public static void memoExcel(List<GetAllLrDetails> getAllLrlist,GetAllMemo getMemoDeatails,HttpServletResponse response ) throws IOException {
	        // Create a Workbook
	    	
	   /* Field[] declaredFields = LrBilling.class.getDeclaredFields();
	    	Object[] strings = (Object[])declaredFields;
	    	
	    	String[] lrBill = (String[])strings;*/
	    	
	    	
	    	
	        String[] columns = {"Lr No","Invoice No", "Consignor", "Consignee", "Delivery location", "Goods", "No. of Qunt.", "Payment By"};
	        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

	        /* CreationHelper helps us create instances of various things like DataFormat, 
	           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
	        CreationHelper createHelper = workbook.getCreationHelper();

	        // Create a Sheet
	        Sheet sheet = workbook.createSheet("MemoDetails");

	        // Create a Font for styling header cells
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());

	        // Create a CellStyle with the font
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	        // Create Cell Style for formatting Date
	        CellStyle dateCellStyle = workbook.createCellStyle();
	        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
	        
	        Row row1 = sheet.createRow(0);
	        
	        
	        row1.createCell(0).setCellValue("Memo No:- "+getMemoDeatails.getMemoNo());
	        row1.createCell(1).setCellValue("Memo Created Date:- "+getMemoDeatails.getCreatedDate());
	        
	        Row row2 = sheet.createRow(1);
	        row2.createCell(0).setCellValue("Vehical Owner Name:- "+getMemoDeatails.getOwnerName());
	        row2.createCell(1).setCellValue("Driver Name:- "+getMemoDeatails.getDriverName());
	        
	        Row row3 = sheet.createRow(2);
	        row3.createCell(0).setCellValue("Driver Liscence No:- "+getMemoDeatails.getLicenseNo());
	        row3.createCell(1).setCellValue("Vehicle No:- "+getMemoDeatails.getVehNo());
	        
	        Row row4 = sheet.createRow(3);
	        row4.createCell(0).setCellValue("Office Name:- "+getMemoDeatails.getFromOffice());
	        row4.createCell(1).setCellValue("Delivery Office Name:- "+getMemoDeatails.getToOffice());
	        
	        
	        // Create a Row
	        Row headerRow = sheet.createRow(5);

	        // Create cells
	        for(int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	        }

	       
	     
	        
	        // Create Other rows and cells with user data'
	        int rowNum = 6;
	        for(GetAllLrDetails lrDetails: getAllLrlist) {
	            Row row = sheet.createRow(rowNum++);

	            
	            row.createCell(0)
                .setCellValue(lrDetails.getLrNo());
	            
	            row.createCell(1)
                .setCellValue(lrDetails.getInvNo());

	            row.createCell(2)
	                    .setCellValue(lrDetails.getConsignor());

	            row.createCell(3)
                .setCellValue(lrDetails.getConsignee());
	            
	            
	            row.createCell(4)
                .setCellValue(lrDetails.getClientAddress());
	            
	            row.createCell(5)
                .setCellValue(lrDetails.getParticular());
	            
	            row.createCell(6)
                .setCellValue(lrDetails.getQuantity());
	            
	            if(lrDetails.getPaymentBy().equals("0"))
	            {
	            	 row.createCell(7)
	                 .setCellValue("To Be Billed");
	            }
	            else if(lrDetails.getPaymentBy().equals("1"))
	            {
	            	 row.createCell(7)
	                 .setCellValue("To Pay");
	            }else {
	            	
	            	row.createCell(7)
	                 .setCellValue("Paid");
	            }
	                                    
	         	        }

			// Resize all columns to fit the content size
	        for(int i =0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
	       
	        String fileName = ""+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +" Memo.xls";

	        System.out.println("fileName:"+fileName);
	        // Write the output to a file
	        FileOutputStream fileOut = new FileOutputStream(fileName);
	        workbook.write(fileOut);
	        fileOut.close();

	        // Closing the workbook
	        workbook.close();
	        
	      //downlod file	
			File file = new File(fileName);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			String mimeType =  URLConnection.guessContentTypeFromStream(inputStream);
			
			if(mimeType== null)
			{
				mimeType = "application/octet-stream";
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			
			FileCopyUtils.copy(inputStream,response.getOutputStream());
			
	    }
	}



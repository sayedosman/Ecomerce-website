package com.example.ecomerce.website.services;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import  org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecomerce.website.models.User;



@Service
public class getDataFromExcel {
	@Autowired
	private UserService userService;
	
	User user;

public void readFromFile(MultipartFile file2 ) throws IOException
{
	/*file2.transferTo(new File("C:\\Users\\sayed\\"+file2.getOriginalFilename()));
    File convFile = new File("C:\\Users\\sayed\\"+file2.getOriginalFilename());
    FileInputStream file = new FileInputStream( convFile );*/
	InputStream file=new BufferedInputStream(file2.getInputStream());
	
	try {
	Workbook wb=new XSSFWorkbook(file);
	Sheet page1= (Sheet) wb.getSheetAt(0);
	 Iterator<Row> rowIterator = page1.iterator();
	 rowIterator.next();
	while (rowIterator.hasNext()) 
    {
		user=new User();
        Row row = rowIterator.next();
        //For each row, iterate through all the columns
        //to get any datatype as string from excel
        DataFormatter objDefaultFormat = new DataFormatter();
         //**
        	
            user.setAddress(row.getCell(1).getStringCellValue());
            user.setEmail(row.getCell(2).getStringCellValue());
            user.setFirstname(row.getCell(3).getStringCellValue());
            user.setLastname(row.getCell(4).getStringCellValue());
            user.setGender(row.getCell(5).getStringCellValue());
            
            user.setPhone( objDefaultFormat.formatCellValue(row.getCell(7)));
            user.setPassword(row.getCell(6).getStringCellValue());
            
            userService.save(user, row.getCell(8).getStringCellValue());
    }
    wb.close();
} 
catch (Exception e) 
{
    e.printStackTrace();
}
	
	
}
public void writeToExcel() throws IOException
{
	//FileInputStream fis=new FileInputStream("C:\\Users\\sayed\\Documents\\asd.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(); 
	
	
	Sheet sheet = workbook.createSheet("users");
	sheet.setColumnWidth(0, 6000);
	sheet.setColumnWidth(1, 6000);
	sheet.setColumnWidth(2, 6000);
	sheet.setColumnWidth(3, 6000);
	sheet.setColumnWidth(4, 6000);
	sheet.setColumnWidth(5, 6000);
	sheet.setColumnWidth(6, 6000);
	sheet.setColumnWidth(7, 6000);

	
	Row header = sheet.createRow(0);
	
	CellStyle headerStyle = workbook.createCellStyle();
	headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	XSSFFont font = ((XSSFWorkbook) workbook).createFont();
	font.setFontName("Arial");
	font.setFontHeightInPoints((short) 16);
	font.setBold(true);
	headerStyle.setFont(font);
	
	Cell headerCell = header.createCell(0);
	
	headerCell.setCellValue("Id");
	headerCell.setCellStyle(headerStyle);
	 headerCell = header.createCell(1);
	headerCell.setCellValue("Adress");
	headerCell.setCellStyle(headerStyle);
	
	headerCell = header.createCell(2);
	headerCell.setCellValue("Email");
	headerCell.setCellStyle(headerStyle);
	headerCell = header.createCell(3);
	headerCell.setCellValue("FirstName");
	headerCell.setCellStyle(headerStyle);
	headerCell = header.createCell(4);
	headerCell.setCellValue("LastName");
	headerCell.setCellStyle(headerStyle);
	headerCell = header.createCell(5);
	headerCell.setCellValue("Gender");
	headerCell.setCellStyle(headerStyle);
	
	headerCell = header.createCell(6);
	headerCell.setCellValue("Phone");
	headerCell.setCellStyle(headerStyle);
	headerCell = header.createCell(7);
	headerCell.setCellValue("Type");
	headerCell.setCellStyle(headerStyle);
	List<User>users=userService.getAllUser();
	Row row;
	for(int i=0;i<users.size();i++)
	{
		row=sheet.createRow(i+1);
		row.createCell(0).setCellValue(users.get(i).getUserId());
		row.createCell(1).setCellValue(users.get(i).getAddress());
		row.createCell(2).setCellValue(users.get(i).getEmail());
		row.createCell(3).setCellValue(users.get(i).getFirstname());
		row.createCell(4).setCellValue(users.get(i).getLastname());
		row.createCell(5).setCellValue(users.get(i).getGender());
		row.createCell(6).setCellValue(users.get(i).getPhone());
		row.createCell(7).setCellValue(users.get(i).getType().getName());
	}
	
	 FileOutputStream fileOut = new FileOutputStream("C:\\Users\\sayed\\Documents\\asd.xlsx");
     workbook.write(fileOut);
     fileOut.close();
     workbook.close();
}
}

package com.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetInput
{
	//To fetch text from properties file
	public String getFromText(String name)
	{
		String name1=name;
		BufferedReader br=null;
		String line;
		String text=null;
		
		try 
		{		
			br=new BufferedReader(new FileReader(FolderPaths.propertiesPath));
			try {
				while((line=br.readLine())!=null)
				{
					if(line.substring(0,line.indexOf(":")-1).trim().equalsIgnoreCase(name1))
					{
						text= line.substring(line.indexOf(":")+1).trim();
						
					}
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return text;
	}
	
	//To fetch string data from input excel
	public String getTextFromExcel(int rowNum,int colNum)
	{
		FileInputStream fis=null;
		File file=null;
		XSSFWorkbook wbk=null;
		XSSFSheet sheet=null;
		int row=rowNum;
		int col=colNum;
		String cellValue=null;
		try 
		{
			file=new File(FolderPaths.inputDataPath);
			fis=new FileInputStream(file);
			wbk=new XSSFWorkbook(fis);
			sheet=wbk.getSheet("Sheet1");
			cellValue= sheet.getRow(row).getCell(col).getStringCellValue();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				wbk.close();
				fis.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		return cellValue;
		
	}
	
	//To fetch numeric data from input excel
		public int getNumberFromExcel(int rowNum,int colNum)
		{
			FileInputStream fis=null;
			File file=null;
			XSSFWorkbook wbk=null;
			XSSFSheet sheet=null;
			int row=rowNum;
			int col=colNum;
			int cellValue=0;
			try 
			{
				file=new File(FolderPaths.inputDataPath);
				fis=new FileInputStream(file);
				wbk=new XSSFWorkbook(fis);
				sheet=wbk.getSheet("Sheet1");
				cellValue= (int) sheet.getRow(row).getCell(col).getNumericCellValue();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					wbk.close();
					fis.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				
			}
			
			return cellValue;
			
		}

}

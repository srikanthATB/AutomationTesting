package com.advanced.libs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.framework.utils.ReadExcel;

public class ExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/**
		 * Inside this Excel There are 3 TestCases with each Testcase having 3 rows of data. Now, Create List<String, Map<String,String>> 
		 *  to store all the data and Print the data from Product details > Supplier Name > Office Depot  
		 *  from the   Map<String, Map<String,String>>
		 */
		
		Map<String, List<Map<String, String>>> data = new HashMap<String, List<Map<String,String>>>();
		List<Map<String, String>> students = new ArrayList<Map<String, String>>();
		List<Map<String, String>> employees = new ArrayList<Map<String, String>>();
		List<Map<String, String>> products = new ArrayList<Map<String, String>>();
		
		
		students = ReadExcel.readData("Collections Assignment.xlsx", "StudentDetails");
		employees = ReadExcel.readData("Collections Assignment.xlsx", "EmployeeDetails");
		products = ReadExcel.readData("Collections Assignment.xlsx", "ProductDetails");

		data.put("StudentDetails", students);
		data.put("EmployeeDetails", employees);
		data.put("ProductDetails", products);

		System.out.println(data.get("ProductDetails").get(1).get("Supplier"));
		
	
	}

}

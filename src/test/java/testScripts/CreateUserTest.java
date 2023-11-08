package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class CreateUserTest extends BaseClass {
  @Test
  public void createUserTest() {
	  home.clickUserTab();
	  
	  users.clickNewButton();
	  Map<String,String> map = excel.readFromExcel("Sheet1","Add User");
	  addUser.createNewUser(map.get("Email"),map.get("Password"),map.get("Firstname"),map.get("LastName"),map.get("Address"),map.get("Contact Info"),map.get("Photo"));
	  soft.assertTrue(users.getSuccessMessage().contains("Success"));
	  
	  if(course.getSuccessMessage().contain("Success"))
		  excel.writeToExcel("Sheet1","Add User","Pass",IConstantPath.EXCEL_PATH);
   else
	  excel.writeToExcel("Sheet1","Add User","Fail", IConstantPath.EXCEL_PATH); 
	  
	  soft.assertAll();
  }
}
											
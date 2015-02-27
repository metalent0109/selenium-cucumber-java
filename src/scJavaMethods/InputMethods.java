package scJavaMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import features.env.CucumberRunner;

public class InputMethods 
{
	SelectElementByType eleType= new SelectElementByType();
	WebElement dropdown,element =null;
	Select selectList=null;
	
	//method to enter text into textfield
	public void enterText(String accessType,String text,String accessName)
	{
		CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName)).sendKeys(text);
	}
	
	//method to clear text from textfield
	public void clearText(String accessType, String accessName)
	{
		CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName)).clear();
	}
	
	public void selectelementfromdropdownbytype (Select select_list, String bytype, String option)
	{
		if(bytype.equals("selectByIndex"))
		{
			int index = Integer.parseInt(option);
			select_list.selectByIndex(index-1);
		}
		else if (bytype.equals("selectByValue"))
			select_list.selectByValue(option);
		else if (bytype.equals("selectByVisibleText"))
			select_list.selectByValue(option);
	}
	
	//method to select option from dropdown list
	public void selectOptionFromDropdown(String accessType, String by, String option, String accessName)
	{
		dropdown = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//dropdown = CucumberRunner.driver.findElement(eleType.getelementbytype(accessType, accessName));
		selectList = new Select(dropdown);
		selectelementfromdropdownbytype(selectList,by,option);
		
	  /*dropdown = WAIT.until { $driver.find_element(:"#{access_type}" => "#{access_name}") }
	  select_list = Selenium::WebDriver::Support::Select.new(dropdown)
	  select_list.select_by(:"#{by}", "#{option}")*/
	}
	
	//method to select all option from dropdwon list
	/*public void select_all_option_from_multiselect_dropdown(String access_type, String access_name)
	{
		dropdown = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		select_list = new Select(dropdown);
		select_list.select_all
		Select all method not present in JAVA
	}*/
	
	//method to unselect all option from dropdwon list
	public void unselectAllOptionFromMultiselectDropdown(String accessType, String accessName)
	{
		dropdown = CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//dropdown = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		selectList = new Select(dropdown);
		selectList.deselectAll();
	}
	
	//method to check checkbox
	public void checkCheckbox(String accessType, String accessName)
	{
		WebElement checkbox= CucumberRunner.wait.until(ExpectedConditions.presenceOfElementLocated(eleType.getelementbytype(accessType, accessName)));
		//WebElement checkbox = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		if (!checkbox.isSelected())
			checkbox.click();
	}
	
	//method to uncheck checkbox
	public void uncheck_checkbox(String access_type, String access_name)
	{
		WebElement checkbox = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		if (checkbox.isSelected())
			checkbox.click();
	}
	
	//method to select radio button
	public void toggle_checkbox(String access_type, String access_name)
	{
		CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name)).click();
	}
	
	//method to select radio button
	public void select_radio_button(String access_type, String access_name)
	{
		WebElement radio_button = CucumberRunner.driver.findElement(eleType.getelementbytype(access_type, access_name));
		if(!radio_button.isSelected())
			radio_button.click();
	}
	
	//method to select option from radio button group
	/*public void select_option_from_radio_button_group(String access_type, String by, String option, String access_name)
	{
		WebElement radio_button_group = CucumberRunner.driver.findElement(eletype.getelementbytype(access_type, access_name));
		

	/*  getter = ->(rb, by) { by == 'value' ? rb.attribute('value') : rb.text }
	  ele = radio_button_group.find { |rb| getter.call(rb, by) == option }
	  ele.click unless ele.selected?
	}*/
}

package scJavaMethods;

import org.openqa.selenium.By;

public class SelectElementByType 
{
	public By getelementbytype(String type,String access_name)
	{
		if(type.equals("id"))
			return By.id(access_name);
		else if (type.equals("name"))
			return By.name(access_name);
		else if (type.equals("class"))
			return By.className(access_name);
		else if (type.equals("xpath"))
			return By.xpath(access_name);
		else if (type.equals("css"))
			return By.cssSelector(access_name);
		else
			return null;
	}
}

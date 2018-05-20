package CommanLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectCombboxValue {
	
	Select ComboBox;
	public SelectCombboxValue(WebDriver d, By SelectObjectInfo)
	{
		this.ComboBox=new Select(d.findElement(SelectObjectInfo));
	}
	
	public boolean SelectComboboxOption (int index)
	{
		try
		{
			ComboBox.selectByIndex(index);
			return VerifySelectedValue(ComboBox.getOptions().get(index).getText());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean SelectComboboxOption (String OptiontoSelect_visibleText_value,boolean Flag_Value_VisibleText)
	{
		String sValue=OptiontoSelect_visibleText_value;
		try
		{
			if(Flag_Value_VisibleText)
			{
				ComboBox.selectByVisibleText(OptiontoSelect_visibleText_value);
			}else
			{
				ComboBox.selectByValue(OptiontoSelect_visibleText_value);
				OptiontoSelect_visibleText_value=ComboBox.getOptions().stream().filter(o->o.getAttribute("value").equals(sValue)).findFirst().get().getText();
			}
			return VerifySelectedValue (OptiontoSelect_visibleText_value);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	private boolean VerifySelectedValue (String VerifyText)
	{
		try
		{
			System.out.println("private boolean VerifySelectedValue (String VerifyText):");
			if(ComboBox.getFirstSelectedOption().getText().equals(VerifyText))
			{
				System.out.println("Provided Option is Selected");
				return true;
			}else
			{
				System.out.println("Provided Option is NOT Selected");
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

}

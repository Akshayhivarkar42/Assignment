

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage 
{
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy(xpath="//select[@name='url']")
	private WebElement buttonDD;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement searchBtn;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String enterSearchBox(String value) {
		
		searchBox.sendKeys(value);
		return value;
	}
	
	public void selectFilter(String filterValue) {
		Select sel= new Select(buttonDD);
		sel.selectByVisibleText(filterValue);
	}
	
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
}

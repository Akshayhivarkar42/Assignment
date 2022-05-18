
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResultPage 
{

	@FindBy(xpath="//span[text()[contains(.,'The Lost World by Arthur Conan Doyle')]]")
	private List<WebElement> maxLenghthString;
	
	@FindBy(xpath="(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
	private WebElement searchResultCount;
	

	@FindBy(xpath="//span[@class='a-size-base a-color-base']")
	private List<WebElement> checkboxes;
	
	public ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchResultCount() {
		String value=searchResultCount.getText();
		String[] strarr= value.split(" ");
		Reporter.log(strarr[2],true);
		return strarr[2];
		
	}
	
	public String matchResult() {
		String value= null;
		for(WebElement e:maxLenghthString) {
			value = e.getText();
		}
		return value;
	}
	
	
	public String languageFilter(String language) {
		String text = null;
		for(WebElement e:checkboxes) {
			text = e.getText();
			if(text.equalsIgnoreCase(language)) {
				e.click();
				break;
			}
			
		}
		return text;	
	}
	
	public void maxLengthResult(int maxCount) {
		String max=null;
		List<String> list= new ArrayList<String>();
		for(WebElement e:maxLenghthString) {
			String value = e.getText();
			
			list.add(value);
		}
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				String a = list.get(i);
				String b = list.get(j);
				if (a.length() > b.length()) {
					 max = a;
			}else {
				max = b;
			}	
			}
		}
		if(max.length()>maxCount) {
			Reporter.log("Result contains lthan 70 characters:- "+max,true);
		}else {
			Reporter.log("Result contains more than 70 characters:- "+max,true);
		}
	}
	
	
}

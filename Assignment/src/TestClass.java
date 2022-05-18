

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {

	HomePage hom;
	ResultPage res;
	

	@BeforeTest
	public void demo() {
		openBrowser();
		hom = new HomePage(driver);
		hom.selectFilter("Books");
		hom.enterSearchBox("the Lost World by Arthur Conan Doyle");
		hom.clickSearchBtn();

	}
	
	@Test(priority=0)
	public void checkResultCount() {
		
		res= new ResultPage(driver);
		res.getSearchResultCount();
		res.maxLengthResult(70);

	
	}
	@Test(priority=1)
	public void englishResult() {
		res.languageFilter("English");
		res.getSearchResultCount();
		res.maxLengthResult(70);
	}
}

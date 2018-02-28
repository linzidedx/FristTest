package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExaminationTrainingPage extends BasePage {

	public ExaminationTrainingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By onlineGetReadyLibraryLocator=By.linkText("网上准备题库");
	public WebElement getOnlineGetReadyLibrary() {
		return this.driver.findElement(onlineGetReadyLibraryLocator);
	}
	public OnlineGetReadyLibraryPage onlineGetReadyLibraryPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		//this.getSideMeunButton().click();
		BackMangementPage bm=new BackMangementPage(this.driver);
		bm.examinationTrainingPage();
		Thread.sleep(3000);
		this.getOnlineGetReadyLibrary().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		return new OnlineGetReadyLibraryPage(this.driver);
	}
}

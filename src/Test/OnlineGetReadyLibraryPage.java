package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlineGetReadyLibraryPage extends BasePage {

	public OnlineGetReadyLibraryPage(WebDriver driver){
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By introductionquestionsLocator=By.xpath("//*[@id=\"upLoad\"]");
	public WebElement getIntroductionquestionsLink() {
		return this.driver.findElement(introductionquestionsLocator);
	}
	public IntroductionquestionsPage introductionquestionsPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		//this.getSideMeunButton().click();
		ExaminationTrainingPage em=new ExaminationTrainingPage(this.driver);
		em.onlineGetReadyLibraryPage();
		Thread.sleep(3000);
		this.getIntroductionquestionsLink().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		return new IntroductionquestionsPage(this.driver);
	}
}

package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackMangementPage extends BasePage {

	public BackMangementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By examinationTrainingButtonLocator=By.xpath("/html/body/div[1]/aside[1]/section/ul/li[8]/ul/li[6]/a/span");
	public WebElement getExaminationTrainingButton() {
		return this.driver.findElement(examinationTrainingButtonLocator);
	}
	public ExaminationTrainingPage examinationTrainingPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		//this.getSideMeunButton().click();
		DashPage ds=new DashPage(this.driver);
		ds.backMangementPage();
		Thread.sleep(3000);
		this.getExaminationTrainingButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		return new ExaminationTrainingPage(this.driver);
	}
}

package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntroductionquestionsPage extends BasePage {

	public IntroductionquestionsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By upLoadLocator=By.xpath("//*[@id=\"uploadBtn\"]");
	By upLoadThisLocator=By.xpath("//*[@id=\"upLoadDiv\"]/ul/li/div[3]/button[1]");
	By cancelThisLocator=By.xpath("//*[@id=\"upLoadDiv\"]/ul/li/div[3]/button[2]");
	By deleteThisLocator=By.xpath("//*[@id=\"upLoadDiv\"]/ul/li/div[3]/button[3]");
	By upLoadAllLocator=By.xpath("//*[@id=\\\"upLoadDiv\\\"]/div[2]/button[1]");
	By cancelAllLocator=By.xpath("//*//*[@id=\"upLoadDiv\"]/div[2]/button[2]");
	By deleteAllLocator=By.xpath("//*[@id=\"upLoadDiv\"]/div[2]/button[3]");
	public WebElement getUpLoadThisButton() {
		return this.driver.findElement(upLoadThisLocator);
	}
	public WebElement getCancelThisButton() {
		return this.driver.findElement(cancelThisLocator);
	}
	public WebElement getDeleteThisButton() {
		return this.driver.findElement(deleteThisLocator);
	}
	public WebElement getUpLoadAllButton() {
		return this.driver.findElement(upLoadAllLocator);
	}
	public WebElement getCancelAllButton() {
		return this.driver.findElement(cancelAllLocator);
	}
	public WebElement getDeleteAllButton() {
		return this.driver.findElement(deleteAllLocator);
	}
	public WebElement getUpLoadLocator() {
		return this.driver.findElement(upLoadLocator);
	}
	public void upLoad() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		//this.getSideMeunButton().click();
		OnlineGetReadyLibraryPage onLine=new OnlineGetReadyLibraryPage(this.driver);
		onLine.introductionquestionsPage();
		Thread.sleep(3000);
		this.getUpLoadLocator().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void upLoadThis() throws InterruptedException {
		this.getUpLoadThisButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void cancelThis() throws InterruptedException {
		this.getCancelThisButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void deleteThis() throws InterruptedException {
		this.getDeleteThisButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void upLoadAll() throws InterruptedException {
		this.getUpLoadAllButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void cancelAll() throws InterruptedException {
		this.getCancelAllButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
	public void deleteAll() throws InterruptedException {
		this.getDeleteAllButton().click();
		System.out.println("---------kaoshipeixun----------");
		Thread.sleep(5000);
		
	}
}

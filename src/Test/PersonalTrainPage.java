package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalTrainPage extends PersonalCenterPage {

	public PersonalTrainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By startDateLocator=By.xpath("//*[@id=\"startDate\"]");
	By endDateLocator=By.xpath("//*[@id=\"endDate\"]");
	By inquireLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[1]/form/div/div[3]/button");
	List<WebElement> WebElements = driver.findElements(By.xpath(""));
	
	public WebElement getStartDateInput() {
		return this.driver.findElement(startDateLocator);
	}
	public WebElement getEndDateInput() {
		return this.driver.findElement(endDateLocator);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireLocator);
	}
	public void inquireWriteDate(String startdate,String enddate) throws InterruptedException {
		this.getStartDateInput().clear();
		this.getStartDateInput().sendKeys(startdate);
		Thread.sleep(5000);
		this.getEndDateInput().clear();
		this.getEndDateInput().sendKeys(enddate);
		Thread.sleep(5000);
		this.getInquireButton().click();
	}
}

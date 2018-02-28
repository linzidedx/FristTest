package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HistoryFlyRecordPage extends PersonalInfoCenterPage {

	public HistoryFlyRecordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By startDateLocator=By.xpath("//*[@id=\"startDate\"]");
	By endDateLocator=By.xpath("//*[@id=\"endDate\"]");
	By inquireLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[1]/form/div/div[3]/button");
	///List<WebElement> WebElements = driver.findElements(By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]"));
	public List<WebElement> getDate() {
		List<WebElement> webList = new ArrayList<WebElement>();
		  WebElement table =driver.findElement(By.tagName("tbody"));
		  List<WebElement> rows =  table.findElements(By.tagName("tr"));
		  for (WebElement row  : rows ){
		      
		      List<WebElement> cols =row.findElements(By.tagName("td"));
		      webList.add(cols.get(0));
		      System.out.println(cols.get(0).getText());
		      System.out.println("");

		  }
		  return webList;
	}
	public WebElement getStartDateInput() {
		return this.driver.findElement(startDateLocator);
	}
	public WebElement getEndDateInput() {
		return this.driver.findElement(endDateLocator);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireLocator);
	}
	public void inquireWriteDate(String startdate,String enddate) {
		this.getStartDateInput().clear();
		this.getStartDateInput().sendKeys(startdate);
		this.getEndDateInput().clear();
		this.getEndDateInput().sendKeys(enddate);
		this.getInquireButton().click();
	}
}

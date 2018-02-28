package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyFlyHoursPage extends PersonalCenterPage {

	public MyFlyHoursPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By startDateLocator=By.id("startDate");
	By endDateLocator=By.id("endDate");
	By inquireLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div[1]/form/div/div[3]/button");
	By yearUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[4]");
	By yearDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[1]");
	By monthUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[3]");
	By monthDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[2]");
	By yearTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[1]");
	By monthTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[2]");
	//String dayPath="/html/body/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]";
	//List<WebElement> WebElements = driver.findElements(By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]"));
	//List<WebElement> WebElements =;
//	public void getDate() {
//		for(int i = 0 ; i < WebElements.size() ; i++) {
//			System.out.println(WebElements.get(i).getText());
//			}
//	}
	public int startYearNow() {
		String nowYear=this.driver.findElement(yearTextNowLocator).getText();
		return Integer.valueOf(nowYear.substring(0, nowYear.length()-1)).intValue();
	}
	public int startMonthNow() {
		String nowMonth=this.driver.findElement(monthTextNowLocator).getText();
		return Integer.valueOf(nowMonth.substring(0, nowMonth.length()-1)).intValue();
	}
	public WebElement getYearUpButton() {
		return this.driver.findElement(yearUpLocator);
	}
	public WebElement getYearDownButton() {
		return this.driver.findElement(yearDownLocator);
	}
	public WebElement getMonthUpButton() {
		return this.driver.findElement(monthUpLocator);
	}
	public WebElement getMonthDownButton() {
		return this.driver.findElement(monthDownLocator);
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
	public void clickStartDate(int year,int month,int day) {
		int nowYear=startYearNow();
		int nowMonth=startMonthNow();
		if(year>nowYear) {
			for (int i=0;i<(year-nowYear);i++) {
				this.getYearUpButton().click();
			}
		}else if(year<nowYear) {
			for (int i=0;i<(nowYear-year);i++) {
				this.getYearDownButton().click();
			}
		}
		if(month>nowMonth) {
			for (int i=0;i<(month-nowMonth);i++) {
				this.getMonthUpButton().click();
			}
		}else if(month<nowMonth) {
			for (int i=0;i<(nowMonth-month);i++) {
				this.getMonthDownButton().click();
			}
		}
	}
}

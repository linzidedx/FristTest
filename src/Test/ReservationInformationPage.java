package Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservationInformationPage extends BasePage {

	public ReservationInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By yearUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[4]");
	By yearDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[1]");
	By monthUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[3]");
	By monthDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[2]");
	By yearTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[1]");
	By monthTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[2]");

	
	
	By flightNoInputLocator=By.xpath("//*[@id=\"FLIGHTNO\"]");
	By staDateInputLocator=By.xpath("//*[@id=\"flightDate\"]");	
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[3]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[1]/div[2]/div");

	public WebElement getflightNoInput() {
		return this.driver.findElement(flightNoInputLocator);
	}
	public WebElement getStaDateInput() {
		return this.driver.findElement(staDateInputLocator);
	}
	
	public WebElement getNoData() {
		return this.driver.findElement(noData);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireButtonLocator);
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
	public int startYearNow() {
		String nowYear=this.driver.findElement(yearTextNowLocator).getText();
		return Integer.valueOf(nowYear.substring(0, nowYear.length()-1)).intValue();
	}
	public int startMonthNow() {
		String nowMonth=this.driver.findElement(monthTextNowLocator).getText();
		return Integer.valueOf(nowMonth.substring(0, nowMonth.length()-1)).intValue();
	}
	public List<WebElement> getTD(int index) {
		List<WebElement> webList = new ArrayList<WebElement>();
	  WebElement table =driver.findElement(By.tagName("tbody"));
	  List<WebElement> rows =  table.findElements(By.tagName("tr"));
	  for (WebElement row  : rows ){
	      
	      List<WebElement> cols =row.findElements(By.tagName("div"));
	      webList.add(cols.get(index));
//	      System.out.println(cols.get(index).getText());
//	      System.out.println("");

	  }
	  return webList;
	}
	public void setYear(int year) throws InterruptedException {
		int nowYear=this.startYearNow();
		if(year>nowYear) {
			for(int i=0;i<year-nowYear;i++) {
				this.getYearUpButton().click();
				Thread.sleep(1000);
			}
		}else if(year<nowYear) {
			for(int i=0;i<nowYear-year;i++) {
				this.getYearDownButton().click();
				Thread.sleep(1000);
			}
		}
	}
	public void setMounth(int mounth) throws InterruptedException {
		int nowMounth=this.startMonthNow();
		if(mounth>nowMounth) {
			for(int i=0;i<mounth-nowMounth;i++) {
				this.getMonthUpButton().click();
				Thread.sleep(1000);
			}
		}else if(mounth<nowMounth) {
			for(int i=0;i<nowMounth-mounth;i++) {
				this.getMonthDownButton().click();
				Thread.sleep(1000);
			}
		}
	}
	public void setDay(int year,int mounth,int day) {
		List<WebElement> dayButtonList=this.driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/table/tbody")).findElements(By.tagName("td"));
//		int start=this.getThisMouthWeek(year, mounth);
		
//		dayButtonList.get(day+start-4).click();
		for(WebElement web:dayButtonList) {
			System.out.println(web.getAttribute("lay-ymd"));
			if(web.getAttribute("lay-ymd").equals(year+"-"+mounth+"-"+day)) {
				System.out.print(web.getAttribute("lay-ymd"));
				System.out.print("dayset");
				web.click();
				return;
			}
		}
	}
	
	public void inquireFlightNoFlyPlanInformation(String flightNo) throws InterruptedException {
		this.getflightNoInput().clear();
		this.getflightNoInput().sendKeys(flightNo);
		Thread.sleep(1000);
		//System.out.print(routeNo+"------");
		this.getInquireButton().click();
	}
	public void inquireDateinformation(int sYear,int sMounth,int sDay) throws InterruptedException {
		this.getStaDateInput().click();
		Thread.sleep(1000);
		this.setYear(sYear);
		Thread.sleep(1000);
		this.setMounth(sMounth);
		Thread.sleep(1000);
		this.setDay(sYear, sMounth, sDay);
		Thread.sleep(5000);
		
		//System.out.print(this.getRouteDateInput().getText());
		this.getInquireButton().click();
		//System.out.print(t//RouteDateInput().getText());
	}
	
}

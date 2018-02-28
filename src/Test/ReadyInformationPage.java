package Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadyInformationPage extends BasePage {

	public ReadyInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By yearUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[4]");
	By yearDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[1]");
	By monthUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[3]");
	By monthDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[2]");
	By yearTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[1]");
	By monthTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[2]");

	
	
	By routeDateInputLocator=By.xpath("//*[@id=\"date\"]");
	//By routeNoInputLocator=By.xpath("//*[@id=\"routeName\"]");
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[1]/div[2]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[2]/div[2]/div/div[2]/div");
	
	public int getThisMouthWeek(int year,int mounth) {
		Calendar c = Calendar.getInstance();
		c.set(year,mounth,1);//2011Äê1ÔÂ1ºÅ

		return c.get(Calendar.DAY_OF_WEEK);
	}
	public WebElement getRouteDateInput() {
		return this.driver.findElement(routeDateInputLocator);
	}
//	public WebElement getRouteNoInput() {
//		return this.driver.findElement(routeNoInputLocator);
//	}
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
	  WebElement table =driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[2]/div[2]/div/div[2]/table/tbody"));
	  List<WebElement> rows =  table.findElements(By.tagName("tr"));
	  for (WebElement row  : rows ){
	      
	      List<WebElement> cols =row.findElements(By.tagName("div"));
	      webList.add(cols.get(index));
//	      System.out.println(cols.get(index).getText());
//	      System.out.println("");

	  }
	  return webList;
	}
	public List<WebElement> getTDNext(int index) {
		List<WebElement> webList = new ArrayList<WebElement>();
	  WebElement table =driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div[2]/table/tbody"));
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
//		System.out.print(start);
//		dayButtonList.get(day+start-4).click();
		for(WebElement web:dayButtonList) {
			if(web.getAttribute("lay-ymd").equals(year+"-"+mounth+"-"+day)) {
				System.out.print("dayset");
				web.click();
				return;
			}
		}
	}
	public void inquireRouteNoinformation(int year,int mounth,int day) throws InterruptedException {
		this.getRouteDateInput().click();
		Thread.sleep(1000);
		this.setYear(year);
		Thread.sleep(1000);
		this.setMounth(mounth);
		Thread.sleep(1000);
		this.setDay(year, mounth, day);
		Thread.sleep(5000);
		System.out.print(this.getRouteDateInput().getText());
		this.getInquireButton().click();
		System.out.print(this.getRouteDateInput().getText());
	}
}

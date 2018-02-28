package Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightDynamicsPage extends BasePage {

	public FlightDynamicsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By yearUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[4]");
	By yearDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[1]");
	By monthUpLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[3]");
	By monthDownLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/i[2]");
	By yearTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[1]");
	By monthTextNowLocator=By.xpath("/html/body/div[2]/div[1]/div[1]/div/span[2]");

	
	
	By flyUpInputLocator=By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[2]/div/div/div/input");
	By flyDownInputLocator=By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[3]/div/div/div/input");
	By flyTimeInputLocator=By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[4]/div/div/div/input");
	By flightDateInputLocator=By.xpath("//*[@id=\"FlightDate\"]");
	By endDateInputLocator=By.xpath("//*[@id=\"endDate\"]");		
	By inquireButtonLocator=By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[5]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div");
	
	
	//List<WebElement> flyTimeList=this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[4]/div/div/dl")).findElements(By.tagName("dd"));
	List<WebElement> linkList=this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[2]/div/ul")).findElements(By.tagName("li"));
	public List<WebElement> getFlyUpList() {
		List<WebElement> flyUpList=this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[2]/div/div/dl")).findElements(By.tagName("dd"));
		return flyUpList;
	}
	public List<WebElement> getFlyTimeList() {
		List<WebElement> flyTimeList=this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[4]/div/div/dl")).findElements(By.tagName("dd"));
		return flyTimeList;
	}
	public List<WebElement> getFlyDownList() {
		List<WebElement> flyDownList=this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[1]/form/div/div[3]/div/div/dl")).findElements(By.tagName("dd"));
		return flyDownList;
	}
	
	public WebElement getAllLink() {
		WebElement web = null;
		for(WebElement link:linkList) {
			if(link.getText().equals("全部")) {
				web=link;
			}
			
		}
		return web;
	}
	public WebElement getNotTakeOffLink() {
		WebElement web = null;
		for(WebElement link:linkList) {
			if(link.getText().equals("未起飞")) {
				web=link;
			}
			
		}
		return web;
	}
	public WebElement getTakeOffLink() {
		WebElement web = null;
		for(WebElement link:linkList) {
			if(link.getText().equals("已起飞")) {
				web=link;
			}
			
		}
		return web;
	}
	public WebElement getArriveLink() {
		WebElement web = null;
		for(WebElement link:linkList) {
			if(link.getText().equals("到达")) {
				web=link;
			}
			
		}
		return web;
	}
	public WebElement getfollowLink() {
		WebElement web = null;
		for(WebElement link:linkList) {
			if(link.getText().equals("已关注")) {
				web=link;
			}
			
		}
		return web;
	}
	
	public int getThisMouthWeek(int year,int mounth) {
		Calendar c = Calendar.getInstance();
		c.set(year,mounth,1);//2011年1月1号

		return c.get(Calendar.DAY_OF_WEEK);
	}
	public WebElement getflyUpInput() {
		
		return this.driver.findElement(flyUpInputLocator);
	}
	public WebElement getFlyDownInput() {
		return this.driver.findElement(flyDownInputLocator);
	}
	public WebElement getflyTimeInput() {
		
		return this.driver.findElement(flyTimeInputLocator);
	}
	public WebElement getFlightDateInput() {
		return this.driver.findElement(flightDateInputLocator);
	}
	public WebElement getEndDateInput() {
		return this.driver.findElement(endDateInputLocator);
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
	public List<WebElement> getFollowButtonList() {
		List<WebElement> webList = new ArrayList<WebElement>();
	  WebElement table =driver.findElement(By.tagName("tbody"));
	  List<WebElement> rows =  table.findElements(By.tagName("tr"));
	  for (WebElement row  : rows ){
	      List<WebElement> cols =row.findElements(By.tagName("div"));
	      webList.add(cols.get(11).findElement(By.className("layui-btn-primary")));
//	      System.out.println(cols.get(index).getText());
//	      System.out.println("");

	  }
	  return webList;
	}
	public List<WebElement> getDetailedinFormationList() {
		List<WebElement> webList = new ArrayList<WebElement>();
	  WebElement table =driver.findElement(By.tagName("tbody"));
	  List<WebElement> rows =  table.findElements(By.tagName("tr"));
	  for (WebElement row  : rows ){
	      
		  List<WebElement> cols =row.findElements(By.tagName("div"));
	      webList.add(cols.get(11).findElement(By.linkText("详细信息")));
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
				//System.out.print(web.getAttribute("lay-ymd"));
				//System.out.print("dayset");
				web.click();
				return;
			}
		}
	}
	
	public void inquireFlightDateinformation(int sYear,int sMounth,int sDay) throws InterruptedException {
		this.getFlightDateInput().click();
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
	public String inquireFlyUpInformation() throws InterruptedException {
		this.getflyUpInput().click();
		Thread.sleep(5000);
		Random r=new Random();
		List<WebElement> flyUpList=this.getFlyUpList();
		int x=r.nextInt(flyUpList.size());
		System.out.println(x);
		String s=flyUpList.get(x).getText();
		flyUpList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
	public String inquireFlyDownInformation() throws InterruptedException {
		this.getFlyDownInput().click();
		Thread.sleep(5000);
		Random r=new Random();
		List<WebElement> flyDownList =this.getFlyDownList();
		int x=r.nextInt(flyDownList.size());
		System.out.println(x);
		String s=flyDownList.get(x).getText();
		flyDownList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
	public String inquireFlyTimeInformation() throws InterruptedException {
		this.getflyTimeInput().click();
		Thread.sleep(5000);
		Random r=new Random();
		List<WebElement> flyTimeList =this.getFlyTimeList();
		int x=r.nextInt(flyTimeList.size());
		System.out.println(x);
		String s=flyTimeList.get(x).getText();
		flyTimeList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
	public void allFlightInformation() throws InterruptedException {
		this.getArriveLink().click();
		Thread.sleep(5000);
		this.getAllLink().click();
		Thread.sleep(5000);
	}
	public void notTakeOffFlightInformation() throws InterruptedException {
		this.getNotTakeOffLink().click();
		Thread.sleep(5000);
		
	}
	public void takeOffFlightInformation() throws InterruptedException {
		this.getTakeOffLink().click();
		Thread.sleep(5000);
		
	}
	public void arriveFlightInformation() throws InterruptedException {
		this.getNotTakeOffLink().click();
		Thread.sleep(5000);
		
	}
	public String followFlightInformation() throws InterruptedException {
		this.getNotTakeOffLink().click();
		String s=null;
		List<String> foolowedflightId=new ArrayList();
		List<String> flightId=new ArrayList();
		List<WebElement> foolowFlightId=this.getTD(1);
		for(WebElement web:foolowFlightId) {
			foolowedflightId.add(web.getText());
		}
		this.getAllLink().click();
		List<WebElement> FlightNo=this.getTD(1);
		for(WebElement web:FlightNo) {
			flightId.add(web.getText());
		}
		for(int i=0;i<flightId.size();i++) {
			if(!foolowFlightId.contains(flightId.get(i))) {
				s=flightId.get(i);
				List<WebElement> followList =this.getFollowButtonList();
				followList.get(i).click();
				break;
			}
		}
		
		return s;
		
	}
	public String cencelFollowFlightInformation() throws InterruptedException {
		this.getNotTakeOffLink().click();
		String s=null;
		List<String> foolowedflightId=new ArrayList();
		List<String> flightId=new ArrayList();
		List<WebElement> foolowFlightId=this.getTD(1);
		for(WebElement web:foolowFlightId) {
			foolowedflightId.add(web.getText());
		}
		this.getAllLink().click();
		List<WebElement> FlightNo=this.getTD(1);
		for(WebElement web:FlightNo) {
			flightId.add(web.getText());
		}
		for(int i=0;i<flightId.size();i++) {
			if(foolowFlightId.contains(flightId.get(i))) {
				s=flightId.get(i);
				List<WebElement> followList =this.getFollowButtonList();
				followList.get(i).click();
				break;
			}
		}
		
		return s;
		
	}
}

package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightCharacteristicPage extends BasePage {

	public FlightCharacteristicPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By routeCharactInputLocator=By.xpath("//*[@id=\"routeName\"]");
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div/div[1]/div[2]/div");
	
	public WebElement getRouteCharactInput() {
		return this.driver.findElement(routeCharactInputLocator);
	}
	public WebElement getNoData() {
		return this.driver.findElement(noData);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireButtonLocator);
	}
	public void inquireRouteformation(String route) throws InterruptedException {
		this.getRouteCharactInput().clear();
		this.getRouteCharactInput().sendKeys(route);
		Thread.sleep(1000);
		this.getInquireButton().click();
	}
//	public String inquireStartAirportformation() throws InterruptedException {
//		this.getStartAirportSelect().click();
//		Thread.sleep(5000);
//		Random r=new Random();
//		int x=r.nextInt(startAirportList.size());
//		System.out.println(x);
//		String s=startAirportList.get(x).getText();
//		startAirportList.get(x).click();
//		this.getInquireButton().click();
//		return s;
//	}
//	public String inquireEndAirportformation() throws InterruptedException {
//		this.getEndAirportSelect().click();
//		Thread.sleep(5000);
//		Random r=new Random();
//		int x=r.nextInt(startAirportList.size());
//		System.out.println(x);
//		String s=endAirportList.get(x).getText();
//		endAirportList.get(x).click();
//		this.getInquireButton().click();
//		return s;
//	}
//	public List<String> detailedInformation() throws InterruptedException {
//		List<String> plt = new ArrayList();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
////        js.executeScript("scrollTo(0,10000)");
////        Thread.sleep(2000);
//		WebElement target = driver.findElement(By.linkText("·É»úÐÅÏ¢"));
//		js.executeScript("arguments[0].scrollIntoView();", target);
//		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");  
//        //((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");
//		 for (int i=0;i<planeInfoList.size();i++){
//			 planeInfoList.get(i).click();
//		      Thread.sleep(5000);
//		      System.out.println(this.getPlaneNo().getText());
//		      
//		      String s=this.getPlaneNo().getText();
//		      System.out.println(s);
//		      plt.add(s);
//		      
//		      Thread.sleep(5000);
//		      this.getPlaneInfoClose().click();
//		      System.out.println("111111");
//		      Thread.sleep(10000);
//		  }
//		return plt;
//	}
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
}

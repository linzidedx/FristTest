package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaneInformationPage extends BasePage {

	public PlaneInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By fourCodeSelectLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div/input");
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[1]/div[2]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div");
	List<WebElement> planeCodeList =  this.driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/dl")).findElements(By.tagName("dd"));
	List<WebElement> planeInfoList=this.driver.findElements(By.linkText("详细信息"));
	By planeNo=By.xpath("/html/body/div[1]/div/section/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]");
						
	By planeInfoClose=By.xpath("/html/body/div[1]/div/section/div/div/div[2]/div[2]/div[3]/a");
	
	public WebElement getPlaneNo() {
		return this.driver.findElement(planeNo);
	}
	public WebElement getPlaneInfoClose() {
		return this.driver.findElement(planeInfoClose);
	}
	
	
	public WebElement getFourCodeSelect() {
		return this.driver.findElement(fourCodeSelectLocator);
	}
	public WebElement getNoData() {
		return this.driver.findElement(noData);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireButtonLocator);
	}
	public String inquirePlaneInformation() throws InterruptedException {
		this.getFourCodeSelect().click();
		Thread.sleep(5000);
		Random r=new Random();
		int x=r.nextInt(planeCodeList.size());
		System.out.println(x);
		String s=planeCodeList.get(x).getText();
		planeCodeList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
	public List<String> detailedInformation() throws InterruptedException {
		List<String> plt = new ArrayList();
		JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("scrollTo(0,10000)");
//        Thread.sleep(2000);
		WebElement target = driver.findElement(By.linkText("飞机信息"));
		js.executeScript("arguments[0].scrollIntoView();", target);
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");  
        //((JavascriptExecutor)driver).executeScript("document.documentElement.scrollTop=10000");
		 for (int i=0;i<planeInfoList.size();i++){
			 planeInfoList.get(i).click();
		      Thread.sleep(5000);
		      System.out.println(this.getPlaneNo().getText());
		      
		      String s=this.getPlaneNo().getText();
		      System.out.println(s);
		      plt.add(s);
		      
		      Thread.sleep(5000);
		      this.getPlaneInfoClose().click();
		      System.out.println("111111");
		      Thread.sleep(10000);
		  }
		return plt;
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
	
}

package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeaterInformationPage extends BasePage {

	public WeaterInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By staInputLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[1]/div/div/div/input");	
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[2]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/div[1]/div[2]/div");
	List<WebElement> planeNoList=this.driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[1]/div/div/dl")).findElements(By.tagName("dd"));
	public WebElement getStaInput() {
		return this.driver.findElement(staInputLocator);
	}
	
	public WebElement getNoData() {
		return this.driver.findElement(noData);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireButtonLocator);
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
	
	
	
	public String inquireWeaterInformation() throws InterruptedException {
		this.getStaInput().click();
		Thread.sleep(5000);
		Random r=new Random();
		int x=r.nextInt(planeNoList.size());
		System.out.println(x);
		String s=planeNoList.get(x).getText();
		planeNoList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
	
	
}

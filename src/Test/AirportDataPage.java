package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AirportDataPage extends BasePage {

	public AirportDataPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By fourCodeSelectLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/form/div[1]/div[1]/div/div/div/input");
	//By threeCodeSelectLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[2]/div/div/div/input");
	By inquireButtonLocator=By.xpath("/html/body/div/div/section/div/div/div[2]/div/div/form/div[1]/div[2]/button");
	By noData=By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/div/form/div[2]/div[1]/div[2]/div");
	List<WebElement> fourCodeList =  this.driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div[1]/div/form/div[1]/div/div/div/dl")).findElements(By.tagName("dd"));
	//List<WebElement> threeCodeList =  this.driver.findElement(By.xpath("/html/body/div/div/section/div/div/div[2]/div/form/div/div[2]/div/div/dl")).findElements(By.tagName("dd"));
//	List<WebElement> oneLine =  this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr")).findElements(By.cssSelector("td>div"));
//	public WebElement gettd(int x) {
//		return oneLine.get(x);
//	}
	public WebElement getFourCodeSelect() {
		return this.driver.findElement(fourCodeSelectLocator);
	}
	public WebElement getNoData() {
		return this.driver.findElement(noData);
	}
	public WebElement getInquireButton() {
		return this.driver.findElement(inquireButtonLocator);
	}
	public String inquireFourCode() throws InterruptedException {
		this.getFourCodeSelect().click();
		Thread.sleep(5000);
		Random r=new Random();
		int x=r.nextInt(fourCodeList.size());
		System.out.println(x);
		String s=fourCodeList.get(x).getText();
		fourCodeList.get(x).click();
		this.getInquireButton().click();
		return s;
	}
//	public String inquireThreeCode() throws InterruptedException {
//		this.getThreeCodeSelect().click();
//		Thread.sleep(5000);
//		Random r=new Random();
//		int x=r.nextInt(threeCodeList.size());
//		System.out.println(x);
//		String s=threeCodeList.get(x).getText();
//		threeCodeList.get(x).click();
//		this.getInquireButton().click();
//		return s;
//	}
//	public String fourCode() {
//		//System.out.println(this.getFourCodeSelect().getText());
//		return this.getFourCodeSelect().getText().substring(0, 3);
//	}
//	public String fourCodeCity() {
//		return this.getFourCodeSelect().getText().substring(4);
//	}
//	public String threeCode() {
//		return this.getThreeCodeSelect().getText().substring(0, 3);
//	}
//	public String threeCodeCity() {
//		return this.getThreeCodeSelect().getText().substring(4);
//	}
	public List<WebElement> getTD(int index) {
		List<WebElement> webList = new ArrayList<WebElement>();
	  WebElement table =driver.findElement(By.tagName("tbody"));
	  List<WebElement> rows =  table.findElements(By.tagName("tr"));
	  for (WebElement row  : rows ){
	      
	      List<WebElement> cols =row.findElements(By.tagName("div"));
	      webList.add(cols.get(index));
	      System.out.println(cols.get(index).getText());
	      System.out.println("");

	  }
	  return webList;
}
	
	
	
	
}

package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.mail163.com.DashPage;
//import com.mail163.com.HomePage;

public class Login {
	WebDriver driver;
	HomePage homePage;
	@BeforeMethod
	public void newDriver() throws InterruptedException {
		System.setProperty ( "webdriver.firefox.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
		System.setProperty("webdriver.chrome.driver", "D:\\lin\\test\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
		 options.addArguments("user-data-dir=C:/Users/sunwin/AppData/Local/Google/Chrome/User Data");
		driver=new ChromeDriver(options);
		String loginPageUrl="http://121.40.220.225";
		  
		System.out.println("Call HomePage ----------");
		  
		homePage=new HomePage(this.driver,loginPageUrl);
		Thread.sleep(5000);
	}
	@AfterMethod
	public void driverEnd() {
		this.driver.quit();
	}
	@DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	    	{ "admin", "sunwin","周永喆"}
	    	};
	    }
	@DataProvider
	  public Object[][] UPError() {
	    return new Object[][] {
	    	{ "admin", "asdfgh"},
	    	{"asdfgh", "sunwin"}
	    	};
	    }
  @Test(dataProvider = "dp")
  public void login(String username,String password,String loginName) throws Exception {
	  //String path="D:\\lin\\test\\WangYiMail\\lib\\login.xlsx";
	  //String sheetName="user";
	  //excelutils excelData=new excelutils(path,sheetName);
	 // double username=excelData.getCelldataasnumber(2, 1);
	  //double  password=excelData.getCelldataasnumber(2, 2);
	  //String username=excelData.getCelldataasstring(1,0);
	  //String password=excelData.getCelldataasstring(1,1 );
	  //String loginPageUrl="http://email.163.com/";
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	  DashPage dashboardPage=homePage.login(username, password);
	  System.out.println("Callend");
	  System.out.println(dashboardPage.getLoginName().getText());
	  assertTrue(dashboardPage.getLoginName().getText().contains(loginName));
	  
  }
  @Test(dataProvider = "dp")
  public void loginTestGeturl(String username,String password,String loginName) throws Exception {
	  //String path="D:\\lin\\test\\WangYiMail\\lib\\login.xlsx";
	  //String sheetName="user";
	  //excelutils excelData=new excelutils(path,sheetName);
	 // double username=excelData.getCelldataasnumber(2, 1);
	  //double  password=excelData.getCelldataasnumber(2, 2);
	  //String username=excelData.getCelldataasstring(1,0);
	  //String password=excelData.getCelldataasstring(1,1 );
	  //String loginPageUrl="http://email.163.com/";
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	  DashPage dashboardPage=homePage.login(username, password);
	  System.out.println("Callend");
	  Thread.sleep(5000);
	  this.driver.get("http://121.40.220.225/#!/AirportInformation/PreparCondition");
	  Thread.sleep(15000);
	  System.out.println(dashboardPage.getLoginName().getText());
	  assertTrue(dashboardPage.getLoginName().getText().contains(loginName));
	  
  }
  @Test(dataProvider = "dp")
  public void testAutoLogin(String username,String password,String loginName) throws Exception {
	  //String path="D:\\lin\\test\\WangYiMail\\lib\\login.xlsx";
	  //String sheetName="user";
	  //excelutils excelData=new excelutils(path,sheetName);
	 // double username=excelData.getCelldataasnumber(2, 1);
	  //double  password=excelData.getCelldataasnumber(2, 2);
	  //String username=excelData.getCelldataasstring(1,0);
	  //String password=excelData.getCelldataasstring(1,1 );
	  //String loginPageUrl="http://email.163.com/";
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	  DashPage dashboardPage=homePage.login(username, password);
	  System.out.println("Callend");
	  System.out.println(dashboardPage.getLoginName().getText());
	  assertTrue(dashboardPage.getLoginName().getText().contains(loginName));
	  driver.quit();
	  newDriver();
	  assertTrue(dashboardPage.getLoginName().getText().contains(loginName));
	  dashboardPage.logout();
  }
  @Test
  public void userIsNull() throws Exception {
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	 homePage.getPasswordField().sendKeys("abcd");
	 homePage.getsSubmitbutton().click();
	 System.out.println(homePage.getUserError().getText());
//	  System.out.println(dashboardPage.getLoginName().getText());
	  assertTrue(homePage.getUserError().getText().contains("用户名不能为空"));
	  
  }
  @Test
  public void passwordIsNull() throws Exception {
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	 homePage.getUserTextField().sendKeys("admin");
	 homePage.getsSubmitbutton().click();
	 System.out.println(homePage.getPasswordError().getText());
//	  System.out.println(dashboardPage.getLoginName().getText());
	  assertTrue(homePage.getPasswordError().getText().contains("密码不能为空"));
	  
  }
  @Test(dataProvider = "UPError")
  public void passwordOrUserError(String username,String password) throws InterruptedException {
	  
	  System.out.println("Call HomePage ----------");
	  
	 // HomePage homePage=new HomePage(this.driver,loginPageUrl);
	 
	  //Thread.sleep(5000);
	  System.out.println("Call");
	 homePage.getUserTextField().sendKeys(username);
	 homePage.getPasswordField().sendKeys(password);
	 homePage.getsSubmitbutton().click();
	 Thread.sleep(5000);
//	  System.out.println("Callend");
//	  System.out.println(dashboardPage.getLoginName().getText());
	 System.out.println(homePage.getUserOrPasswordError().getText());
	  assertTrue(homePage.getUserOrPasswordError().getText().contains("用户名或密码错误"));
	  
  }
//  @Test
//  public void logoImg() throws InterruptedException {
//	  System.out.println("Call logoImg()");
//	  //String loginPageUrl="http://email.163.com/";
//	  //HomePage homePage=new HomePage(this.driver,loginPageUrl);
//	  Thread.sleep(5000);
//	  WangYiHomePage wangYiPage=homePage.logoImg();
//	  Thread.sleep(5000);
//	  //System.out.println(wangYiPage);
//	  System.out.println(wangYiPage.getUrl()+"-----");
//	  assertTrue(wangYiPage.getUrl().equals("http://email.163.com/"));
//  }
//  @Test
//  public void writeEmailTest() throws InterruptedException  {
//	  DashPage dashboardPage=homePage.login("15811081292","641480Aa");
//	  WEmailPage wEmailPage=dashboardPage.writeEmail();
//	  Thread.sleep(5000);
//	  //System.out.println(wEmailPage.getAddresseeLable().getText()+"---------");
//	  assertTrue(wEmailPage.getSendMailButton().getText().contains("发送"));
//  }
//  @Test
//  public void sendEmailTest() throws InterruptedException  {
//	  String address="3070005760@qq.com";
//	  String subject="test1";
//	  String mainBody="真实环境中元素往往使用复合类名(即多个class用空格分隔)，使用className定位时要注意了，className的参数只能是一个class";
//	  DashPage dashboardPage=homePage.login("15811081292","641480Aa");
//	  WEmailPage wEmailPage=dashboardPage.writeEmail();
//	  Thread.sleep(5000);
//	  AfterSendEmailPage afterSendEmailPage=wEmailPage.sendEmail(address, subject, mainBody);
//	  Thread.sleep(5000);
//	  //System.out.println(wEmailPage.getAddresseeLable().getText()+"---------");
//	  //assertTrue(wEmailPage.getSendMailButton().getText().contains("发送"));
//  }
}

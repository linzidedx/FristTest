package Test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestPersonalCenter {
	
  
  WebDriver driver;
	HomePage homePage;
	PersonalCenterPage PCPDriver;
	@BeforeMethod
	public void newDriver() throws InterruptedException {
		System.setProperty ( "webdriver.firefox.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
		System.setProperty("webdriver.chrome.driver", "D:\\lin\\test\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
		 options.addArguments("user-data-dir=C:/Users/sunwin/AppData/Local/Google/Chrome/User Data");
		driver=new ChromeDriver(options);
		String loginPageUrl="http://121.40.220.225/Account/Login?ReturnUrl=%2F";
		 String username="feixing";
		 String password="sunwin";
		System.out.println("Call HomePage ----------");
		  
		homePage=new HomePage(this.driver,loginPageUrl);
		Thread.sleep(2000);
		DashPage dashPage=homePage.login(username, password);
		Thread.sleep(5000);
//		this.driver.findElement(By.xpath("/html/body/div/header/nav/form/div/ul/li[1]/a")).click();
//		Thread.sleep(5000);
		PCPDriver=dashPage.personalCenterPage();
	}
	@AfterMethod
	public void driverEnd() {
		this.driver.quit();
	}
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
    };
  }
//  @Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  //个人信息中心测试用例
  @Test
  public void testPersonalInfoCenter() throws InterruptedException {
	  Thread.sleep(5000);
	  PersonalInfoCenterPage personalInfoDriver=PCPDriver.personalInfoCenter();
	  Thread.sleep(5000);
	  System.out.println("yanzheng----");
	  assertTrue(this.driver.getCurrentUrl().contains("Personal"));
  }
  
  //我的飞行小时测试用例
  @Test
  public void testMyFlyHours() throws InterruptedException {
	  MyFlyHoursPage myFlyHours=PCPDriver.myFlyHours();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("FlightHours"));
	  //myFlyHours.getDate();
	  Thread.sleep(5000);
  }
  @Test
  public void testInqueryMyHours() throws InterruptedException {
	  MyFlyHoursPage myFlyHours=PCPDriver.myFlyHours();
	  Thread.sleep(5000);
	  myFlyHours.inquireWriteDate("2017-5-5", "2017-12-12");
	  Thread.sleep(5000);
	  //assertTrue(this.driver.getCurrentUrl().contains("FlightHours"));
  }
  //历史飞行记录测试用例
  @Test
  public void testHistoryFlyRecord() throws InterruptedException {
	  HistoryFlyRecordPage historyFlyRecord=PCPDriver.historyFlyRecord();
	  Thread.sleep(5000);
	  List<WebElement> webList=historyFlyRecord.getDate();
	  System.out.println("----------------------------");
	  for (WebElement row  : webList ){
		  System.out.println(row.getText());
	  }
	  assertTrue(this.driver.getCurrentUrl().contains("FlightRecord"));
	  
  }
  @Test
  public void testInqueryHistoryFlyRecord() throws InterruptedException {
	  HistoryFlyRecordPage historyFlyRecord=PCPDriver.historyFlyRecord();
	  Thread.sleep(5000);
	  historyFlyRecord.inquireWriteDate("2017/5/5", "2017/12/12");
	  Thread.sleep(5000);
	  //assertTrue(this.driver.getCurrentUrl().contains("FlightHours"));
  }
//个人训练监控测试用例
  @Test
  public void testPersonalTrain() throws InterruptedException {
	  PCPDriver.personalTrain();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("TrainRecord"));
  }
  @Test
  public void testInqueryPersonalTrainPage() throws InterruptedException {
	  PersonalTrainPage personalTrainPage=PCPDriver.personalTrain();
	  Thread.sleep(5000);
	  personalTrainPage.inquireWriteDate("2017/5/5", "2017/12/12");
	  Thread.sleep(5000);
	  //assertTrue(this.driver.getCurrentUrl().contains("FlightHours"));
  }
//QAR事件测试用例
  @Test
  public void testQAREvent() throws InterruptedException {
	  PCPDriver.QAREvent();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("QARInfo"));
  }
//证照信息
  @Test
  public void testCertificateInfomation() throws InterruptedException {
	  PCPDriver.certificateInformation();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("CertInfo"));
  }

//个人资质测试用例
  @Test
  public void testPersonalQualification() throws InterruptedException {
	  PCPDriver.personalQualification();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("QulificationInfo"));
  }
//详细信息测试用例
  @Test
  public void testDetailedInformation() throws InterruptedException {
	  PCPDriver.detailedInformation();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("BasicInfo"));
  }
//修改密码测试用例
  @Test
  public void testChangePassword() throws InterruptedException {
	  PCPDriver.changePassword();
	  Thread.sleep(5000);
	  assertTrue(this.driver.getCurrentUrl().contains("UpdatePasswordView"));
  }
}

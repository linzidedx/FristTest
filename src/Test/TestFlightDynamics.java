package Test;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFlightDynamics {
	 WebDriver driver;
		HomePage homePage;
		FlightDynamicsPage DynamDriver;
		@BeforeMethod
		public void newDriver() throws InterruptedException {
			System.setProperty ( "webdriver.firefox.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
			System.setProperty("webdriver.chrome.driver", "D:\\lin\\test\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();  
			 options.addArguments("user-data-dir=C:/Users/sunwin/AppData/Local/Google/Chrome/User Data");
			driver=new ChromeDriver(options);
			String loginPageUrl="http://121.40.220.225/Account/Login?ReturnUrl=%2F";
			 String username="admin";
			 String password="sunwin";
			System.out.println("Call HomePage ----------");
			  
			homePage=new HomePage(this.driver,loginPageUrl);
			Thread.sleep(2000);
			DashPage dashPage=homePage.login(username, password);
			Thread.sleep(5000);
			DynamDriver=dashPage.flightDynamicsPage();
			
		}
		@AfterMethod
		public void driverEnd() {
			this.driver.close();
			this.driver.quit();
		}
		@Test
		public void testInquireDateInformation() throws InterruptedException {
			DynamDriver.inquireFlightDateinformation(2018, 1, 23);
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<7;i++) {
					  System.out.println(DynamDriver.getTD(0).get(i).getText());
					  assertTrue(DynamDriver.getTD(0).get(i).getText().contains("2018-01-23"));
				  }
			  }
			
		  }
		@Test
		public void testInquirFlightUpInformation() throws InterruptedException {
			String str=DynamDriver.inquireFlyUpInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<DynamDriver.getTD(2).size();i++) {
					  assertTrue(DynamDriver.getTD(2).get(i).getText().contains(str.substring(4, str.length()-1)));
				  }
			  }
		  }
		@Test
		public void testInquirFlightDownInformation() throws InterruptedException {
			String str=DynamDriver.inquireFlyDownInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<DynamDriver.getTD(2).size();i++) {
					  assertTrue(DynamDriver.getTD(2).get(i).getText().contains(str.substring(4, str.length()-1)));
				  }
			  }
		  }
		@Test
		public void testInquirFlightTimeInformation() throws InterruptedException {
			String str=DynamDriver.inquireFlyTimeInformation();
			 DateFormat df = new SimpleDateFormat("HH:mm");
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
	
				  for(int i=0;i<DynamDriver.getTD(3).size();i++) {
					  int a=Integer.parseInt(DynamDriver.getTD(3).get(i).getText().replaceAll(":" ,""));
					  int b=Integer.parseInt(str.substring(0, 4).replaceAll(":" ,""));
					  assertTrue(a>=b);
					  assertTrue(Integer.parseInt(DynamDriver.getTD(3).get(i).getText().replaceAll(":" ,""))>=Integer.parseInt(str.substring(0, 4).replaceAll(":" ,"")));
					  assertTrue(Integer.parseInt(DynamDriver.getTD(5).get(i).getText().replaceAll(":" ,""))>=Integer.parseInt(str.substring(6, str.length()-1).replaceAll(":" ,"")));
				  }
			  }
		  }
		@Test
		public void testNotTakeOffInformation() throws InterruptedException {
			DynamDriver.notTakeOffFlightInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<DynamDriver.getTD(4).size();i++) {
					  assertTrue(DynamDriver.getTD(4).get(i).getText().isEmpty());
				  }
			  }
		  }
		@Test
		public void testTakeOffInformation() throws InterruptedException {
			DynamDriver.takeOffFlightInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  System.out.println(DynamDriver.getTD(0).size());
				  for(int i=0;i<7&&i<DynamDriver.getTD(4).size();i++) {
					  System.out.println(DynamDriver.getTD(4).get(i).getText());
					  assertTrue(DynamDriver.getTD(4).get(i).getText().length()!=0);
				  }
			  }
		  }
		@Test
		public void testArriveInformation() throws InterruptedException {
			DynamDriver.arriveFlightInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<7;i++) {
					  assertTrue(!DynamDriver.getTD(6).get(i).getText().isEmpty());
				  }
			  }
		  }
		@Test
		public void testFollowInformation() throws InterruptedException {
			String str=DynamDriver.followFlightInformation();
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  boolean b=false;
				  for(int i=0;i<DynamDriver.getTD(1).size();i++) {
					  if(DynamDriver.getTD(1).get(i).getText().contains(str)) {
						  b=true;
					  }
				  }
				  assertTrue(b);
			  }
		  }
		@Test
		public void testCencelFollowInformation() throws InterruptedException {
			String str=DynamDriver.cencelFollowFlightInformation();
			System.out.println(str);
			  Thread.sleep(5000);
			  if(DynamDriver.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(DynamDriver.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  boolean b=true;
				  for(int i=0;i<DynamDriver.getTD(1).size();i++) {
					  if(DynamDriver.getTD(1).get(i).getText().contains(str)) {
						  b=false;
					  }
				  }
				  assertTrue(b);
				  }
			  }
		  
}

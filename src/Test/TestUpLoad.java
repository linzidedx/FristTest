package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUpLoad {
	WebDriver driver;
	HomePage homePage;
	IntroductionquestionsPage iq;
	@BeforeMethod
	public void newDriver() throws InterruptedException {
		System.setProperty ( "webdriver.firefox.bin" , "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" );
		System.setProperty("webdriver.chrome.driver", "D:\\lin\\test\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
		 //options.addArguments("user-data-dir=C:/Users/sunwin/AppData/Local/Google/Chrome/User Data");
		 options.addArguments("user-data-dir=D:\\lin\\test\\User Data");
		 options.addArguments("disable-infobars");
		//driver=new ChromeDriver(options);
	
		driver=new ChromeDriver(options);
		String loginPageUrl="http://121.40.220.225/Account/Login?ReturnUrl=%2F";
		 String username="admin";
		 String password="sunwin";
		System.out.println("Call HomePage ----------");
		  
		homePage=new HomePage(this.driver,loginPageUrl);
		Thread.sleep(2000);
		DashPage dashPage=homePage.login(username, password);
		Thread.sleep(5000);
//		this.driver.findElement(By.xpath("/html/body/div/header/nav/form/div/ul/li[1]/a")).click();
//		Thread.sleep(5000);
		iq=new IntroductionquestionsPage(this.driver);
	}
	@AfterMethod
	public void driverEnd() {
		this.driver.close();
		this.driver.quit();
	}
  @Test
  public void testUpLoad() throws InterruptedException {
	  //IntroductionquestionsPage iq=new IntroductionquestionsPage(this.driver);
	  iq.upLoad();
	  RunEXE.runexe("D:\\lin\\test\\AutoIt\\FileOnLoad.exe");
	  iq.upLoadThis();  
	    //Thread.sleep(20000);
  }
}

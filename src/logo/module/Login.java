package logo.module;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import logo.log.SelLogger;

public class Login {
	private static final SelLogger logger=SelLogger.getLogger(Login.class);
	private WebDriver driver;
	PublicModule p=new PublicModule();
	@FindBy(how=How.ID,using="UserCode")
	public static WebElement LoginnameInputbox;
	
	
	@FindBy(how=How.ID,using="Password")
	public static WebElement LoginpwdInputbox;
	
	
	@FindBy(how=How.XPATH,using="/html/body/div/div[2]/div[2]/div/form/div[4]/input")
	public static WebElement LoginBtn;
	
	
	@FindBy(how=How.XPATH,using="/html/body/div/header/nav/form/div/ul/li[4]/a")
	public static WebElement userLink;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		ElementLocatorFactory finder=new AjaxElementLocatorFactory(driver,120);
		PageFactory.initElements(finder, this);
		driver.manage().window().maximize(); //浏览器页面最大化
	}
	
	//输入用户名
	public String userName(String userNameTxt) {
		LoginnameInputbox.clear();
		LoginnameInputbox.sendKeys(userNameTxt);
		return userNameTxt;
	}
	
	//输入密码
		public String passWord(String userPwdTxt) {
			LoginpwdInputbox.clear();
			LoginpwdInputbox.sendKeys(userPwdTxt);
			return userPwdTxt;
		}
		public void clickLoginButton() {
			//p.waitForPageLoadByXpath("/html/body/div/div[2]/div[2]/div/form/div[4]/input", driver);
			LoginBtn.click();
		}
		public void checkResult() {
			Assert.assertEquals(userLink.isDisplayed(), true);
		}
}

package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver,String url) {
		super(driver);
		this.url=url;
		this.goTo();
		System.out.println("CallBasePage");
	}
	By usernamelocator=By.name("UserCode");
	By passwordlocator=By.name("Password");
	By loginbuttonlocator=By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div[4]/button");
	By userErrorlocator=By.xpath("/html/body/div[2]/div/form/div[1]/div/div/span");
	By passwordErrorlocator=By.xpath("/html/body/div[2]/div/form/div[2]/div/div/span");
	By userOrPasswordErrorlocator=By.xpath("/html/body/div[2]/div/form/div[1]/div/div/div/ul/li");
	By autoLoginlocator=By.id("RememberMe");
	By forgotPasswordlocator=By.linkText("�������룿");
	public WebElement getUserOrPasswordError() {
		return this.driver.findElement(userOrPasswordErrorlocator);
	}
	public WebElement getUserError() {
		return this.driver.findElement(userErrorlocator);
	}
	public WebElement getPasswordError() {
		return this.driver.findElement(passwordErrorlocator);
	}
	public WebElement getAutoLogin() {
		return this.driver.findElement(autoLoginlocator);
	}
	public WebElement getForgotPassword() {
		return this.driver.findElement(forgotPasswordlocator);
	}
	public WebElement getUserTextField() {
		System.out.println("serchUserIndex----");
		//System.out.println(this.driver.getTitle());
		return this.driver.findElement(usernamelocator);
		//return this.driver.findElement(By.name("email"));
	}
	public WebElement getPasswordField() {
		System.out.println(this.driver.getTitle());
		return this.driver.findElement(passwordlocator);
		//return this.driver.findElement(By.name("password"));
	}
	public WebElement getsSubmitbutton() {
		return this.driver.findElement(loginbuttonlocator);
		//return this.driver.findElement(By.id("dologin"));
	}
//	public WangYiHomePage logoImg() {
//		this.getLoginImg().click();
//		return new WangYiHomePage(this.driver);
	//}
	public DashPage login(String username,String password) throws InterruptedException {
//		 WebElement xf=driver.findElement(By.xpath("//*[@id=\'panel-163\']/iframe"));
//			driver.switchTo().frame(xf);
		this.getUserTextField().sendKeys(username);
		this.getPasswordField().sendKeys(password);
		this.getsSubmitbutton().click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println(new DashPage(this.driver));
		return new DashPage(this.driver);
	}
	
	public DashPage autoLogin(String username,String password) throws InterruptedException {
//		 WebElement xf=driver.findElement(By.xpath("//*[@id=\'panel-163\']/iframe"));
//			driver.switchTo().frame(xf);
		this.getUserTextField().sendKeys(username);
		this.getPasswordField().sendKeys(password);
		this.getAutoLogin().click();
		this.getsSubmitbutton().click();
		//driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println(new DashPage(this.driver));
		return new DashPage(this.driver);
	}
	
}

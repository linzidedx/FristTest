package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import com.mail163.com.BasePage;
//import com.mail163.com.WEmailPage;



public class DashPage extends BasePage {
	public DashPage(WebDriver driver) {
		super(driver);
	}
	
	By loginNameLocator =By.xpath("/html/body/div/header/nav/form/div/ul/li[4]/a/span");
	By userInfomationLocator=By.id("");
	By logoutLocator=By.id("");
	By fristPageButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[1]/a");
	By personalCenterPageButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[2]/a/span[1]");
	By flyReadyButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[3]/a/span[1]");
	By flightDynamicsButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[3]/a/span[1]");
	By newsBulletinButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a/span[1]");
	By trainingLearningButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[6]/a/span[1]");
	By informationButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[6]/a/span[1]");
	//By informationButtonLocator=By.xpath("/html/body/div/aside[1]/section/ul/li[7]/a/span[1]");
	By backMangementPageButtonLocator=By.xpath("/html/body/div[1]/aside[1]/section/ul/li[8]/a/span[1]");
	By sideMeunLocator=By.xpath("/html/body/div/header/nav/a");
	
//	By wEmail=By.id("_mail_component_70_70");
	public WebElement getFlyReadyButton() {
		return this.driver.findElement(flyReadyButtonLocator);
	}
	public WebElement getFlightDynamicsButton() {
		return this.driver.findElement(flightDynamicsButtonLocator);
	}
	public WebElement getNewsBulletinButton() {
		return this.driver.findElement(newsBulletinButtonLocator);
	}
	public WebElement getTrainingLearningButton() {
		return this.driver.findElement(trainingLearningButtonLocator);
	}
	public WebElement getinFormationButton() {
		return this.driver.findElement(informationButtonLocator);
	}
	public WebElement getBackMangementButton() {
		return this.driver.findElement(backMangementPageButtonLocator);
	}
	public WebElement getSideMeunButton() {
		return this.driver.findElement(sideMeunLocator);
	}
	public WebElement getFristPageButton() {
		return this.driver.findElement(fristPageButtonLocator);
	}
	public WebElement getPersonalCenterPageButton() {
		return this.driver.findElement(personalCenterPageButtonLocator);
	}
	
	public FristPage fristPage() throws InterruptedException {
		this.getFristPageButton().click();
		Thread.sleep(5000);
		return new FristPage(this.driver);
	}
	public PersonalCenterPage personalCenterPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getPersonalCenterPageButton().click();
		System.out.println("---------进入个人中心----------");
		Thread.sleep(5000);
		return new PersonalCenterPage(this.driver);
	}
	public FlyReadyPage flyReadyPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getFlyReadyButton().click();
		//System.out.println("---------进入个人中心----------");
		Thread.sleep(5000);
		return new FlyReadyPage(this.driver);
	}
	public FlightDynamicsPage flightDynamicsPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getFlightDynamicsButton().click();
		Thread.sleep(5000);
		this.getSideMeunButton().click();
		//System.out.println("---------进入个人中心----------");
		
		return new FlightDynamicsPage(this.driver);
	}
	public NewsBulletinPage newsBulletinPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getNewsBulletinButton().click();
		//System.out.println("---------进入个人中心----------");
		Thread.sleep(5000);
		return new NewsBulletinPage(this.driver);
	}
	public TrainingLearningPage trainingLearningPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getTrainingLearningButton().click();
		//System.out.println("---------进入个人中心----------");
		Thread.sleep(5000);
		return new TrainingLearningPage(this.driver);
	}
	public InformationCenterPage informationCenterPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getinFormationButton().click();
		//System.out.println("---------进入个人中心----------");
		Thread.sleep(5000);
		return new InformationCenterPage(this.driver);
	}
	public BackMangementPage backMangementPage() throws InterruptedException {
		//System.out.println(this.getFristPageButton());
		//Actions action= new Actions(driver);  
        //action.moveToElement(this.getFristPageButton()).perform(); 
		this.getSideMeunButton().click();
		Thread.sleep(3000);
		this.getBackMangementButton().click();
		System.out.println("--------BackMangement----------");
		Thread.sleep(5000);
		return new BackMangementPage(this.driver);
	}
	public WebElement getUserInfomation() {
		//System.out.println("CalluserId");
		return this.driver.findElement(userInfomationLocator);
	}
	public WebElement getLogoutButton() {
		//System.out.println("CalluserId");
		return this.driver.findElement(logoutLocator);
	}
	public WebElement getLoginName() {
		//System.out.println("CalluserId");
		return this.driver.findElement(loginNameLocator);
	}
	public void userInfomation() {
		this.getUserInfomation().click();
	}
	
	public void logout() {
		userInfomation();
		this.getLogoutButton().click();
	}
//	public String getText(DashPage dashboardPage ) {
//		return dashboardPage.getUserID().getText();
//	}
}

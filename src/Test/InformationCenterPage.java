package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationCenterPage extends DashPage {

	public InformationCenterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By airportInformationLinkLocator=By.linkText("机场信息");
	By airportDataLinkLocator=By.linkText("机场资料");
	By planeInformationLinkLocator=By.linkText("飞机信息");
	By flightDataLinkLocator=By.linkText("航线数据");
	By flightCharacteristicLinkLocator=By.linkText("航线特点");
	By planeFaultLinkLocator=By.linkText("飞机故障保留");
	By flightchangeLinkLocator=By.linkText("航班调整");
	By readyInformationLinkLocator=By.linkText("准备情况");
	By flyTimeLinkLocator=By.linkText("飞行时间");
	By flyPlanLinkLocator=By.linkText("飞行计划（排班情况）");
	By reservationInformationLinkLocator=By.linkText("订座信息");
	By weaterInformationLinkLocator=By.linkText("气象资料");
	
	public WebElement getAirportInformationLink() {
		return this.driver.findElement(airportInformationLinkLocator);
	}
	
	public WebElement getAirportDataLink() {
		return this.driver.findElement(airportDataLinkLocator);
	}
	public WebElement getPlaneInformationLink() {
		return this.driver.findElement(planeInformationLinkLocator);
	}
	public WebElement getFlightDataLink() {
		return this.driver.findElement(flightDataLinkLocator);
	}
	public WebElement getFlightCharacteristicLink() {
		return this.driver.findElement(flightCharacteristicLinkLocator);
	}
	public WebElement getPlaneFaultLink() {
		return this.driver.findElement(planeFaultLinkLocator);
	}
	public WebElement getFlightchangeLink() {
		return this.driver.findElement(flightchangeLinkLocator);
	}
	public WebElement getReadyInformationLink() {
		return this.driver.findElement(readyInformationLinkLocator);
	}
	public WebElement getFlyTimeLink() {
		return this.driver.findElement(flyTimeLinkLocator);
	}
	public WebElement getFlyPlanLink() {
		return this.driver.findElement(flyPlanLinkLocator);
	}
	public WebElement getReservationInformationLink() {
		return this.driver.findElement(reservationInformationLinkLocator);
	}
	public WebElement getWeaterInformationLink() {
		return this.driver.findElement(weaterInformationLinkLocator);
	}
	
	
	public AirportInformationPage airportInformation() throws InterruptedException {
		this.getAirportInformationLink().click();
		Thread.sleep(5000);
		return new AirportInformationPage(this.driver);
	}
	public AirportDataPage airportData() throws InterruptedException {
		this.getAirportDataLink().click();
		Thread.sleep(5000);
		return new AirportDataPage(this.driver);
	}
	public PlaneInformationPage planeInformation() throws InterruptedException {
		this.getPlaneInformationLink().click();
		Thread.sleep(5000);
		return new PlaneInformationPage(this.driver);
	}
	public FlightDataPage flightData() throws InterruptedException {
		this.getFlightDataLink().click();
		Thread.sleep(5000);
		return new FlightDataPage(this.driver);
	}
	public FlightCharacteristicPage flightCharacteristic() throws InterruptedException {
		this.getFlightCharacteristicLink().click();
		Thread.sleep(5000);
		return new FlightCharacteristicPage(this.driver);
	}
	public PlaneFaultPage planeFault() throws InterruptedException {
		this.getPlaneFaultLink().click();
		Thread.sleep(5000);
		return new PlaneFaultPage(this.driver);
	}
	public FlightchangePage flightchange() throws InterruptedException {
		this.getFlightchangeLink().click();
		Thread.sleep(5000);
		return new FlightchangePage(this.driver);
	}
	public ReadyInformationPage readyInformation() throws InterruptedException {
		this.getReadyInformationLink().click();
		Thread.sleep(5000);
		return new ReadyInformationPage(this.driver);
	}
	public FlyTimePage flyTime() throws InterruptedException {
		this.getFlyTimeLink().click();
		Thread.sleep(5000);
		return new FlyTimePage(this.driver);
	}
	public FlyPlanPage flyPlan() throws InterruptedException {
		this.getFlyPlanLink().click();
		Thread.sleep(5000);
		return new FlyPlanPage(this.driver);
	}
	public ReservationInformationPage reservationInformation() throws InterruptedException {
		this.getReservationInformationLink().click();
		Thread.sleep(5000);
		return new ReservationInformationPage(this.driver);
	}
	public WeaterInformationPage weaterInformation() throws InterruptedException {
		this.getSideMeunButton().click();
		Thread.sleep(5000);
		this.getWeaterInformationLink().click();
		Thread.sleep(5000);
		return new WeaterInformationPage(this.driver);
	}
}

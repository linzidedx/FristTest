package Test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestInformationcenter {
	 WebDriver driver;
		HomePage homePage;
		InformationCenterPage PCPDriver;
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
			PCPDriver=dashPage.informationCenterPage();
		}
		@AfterMethod
		public void driverEnd() {
			this.driver.close();
			this.driver.quit();
		}
		//机场信息测试用例
		@Test
		public void testAirportInformation() throws InterruptedException {
			AirportInformationPage airportInfo=PCPDriver.airportInformation();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("AirportInformation"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testFourCodeInquire() throws InterruptedException {
			AirportInformationPage airportInfo=PCPDriver.airportInformation();
			  Thread.sleep(5000);
			  String s=airportInfo.inquireFourCode();
			  //assertTrue(this.driver.getCurrentUrl().contains("AirportInformation"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  System.out.println("s");
//			  List<WebElement> webList=airportInfo.getTD(0);
//			  for (WebElement row  : webList ){
//				  System.out.println(row.getText());
//			  }
			//System.out.println(airportInfo.gettd(0).getText());
			  //System.out.println(airportInfo.gettd(0).getText());
			  //System.out.println(airportInfo.oneLine.get(6));
			  assertTrue(airportInfo.getTD(0).get(0).getText().contains(s.substring(0,3)));
			  assertTrue(airportInfo.getTD(6).get(0).getText().contains(s.substring(5)));
		  }
		@Test
		public void testThreeCodeInquire() throws InterruptedException {
			AirportInformationPage airportInfo=PCPDriver.airportInformation();
			  Thread.sleep(5000);
			  String s=airportInfo.inquireThreeCode();
			  Thread.sleep(5000);
			  System.out.println("s");
	  
			  assertTrue(airportInfo.getTD(1).get(0).getText().contains(s.substring(0,2)));
			  assertTrue(airportInfo.getTD(6).get(0).getText().contains(s.substring(4)));
		  }
		//机场资料测试用例
		@Test
		public void testAirportData() throws InterruptedException {
			AirportDataPage aiipData=PCPDriver.airportData();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("AirportDocInfo"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testAirportDataFourCodeInquire() throws InterruptedException {
			AirportDataPage aiipData=PCPDriver.airportData();
			  Thread.sleep(5000);
			  String s=aiipData.inquireFourCode();
			  //assertTrue(this.driver.getCurrentUrl().contains("AirportInformation"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  System.out.println("s");
			  if(aiipData.getTD(0).isEmpty()) {
				  assertTrue(aiipData.getNoData().getText().contains("无数据"));
			  }else {
				  assertTrue(aiipData.getTD(0).get(0).getText().contains(s.substring(0,3)));
				  assertTrue(aiipData.getTD(1).get(0).getText().contains(s.substring(5)));
			  }
			  
		  }
		//飞机信息测试用例
		@Test
		public void testPlaneInformation() throws InterruptedException {
			PlaneInformationPage planeInfo=PCPDriver.planeInformation();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("AircraftInformation"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testPlaneCodeInquire() throws InterruptedException {
			PlaneInformationPage planeInfo=PCPDriver.planeInformation();
			  Thread.sleep(5000);
			  String s=planeInfo.inquirePlaneInformation();
			  //assertTrue(this.driver.getCurrentUrl().contains("AirportInformation"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  System.out.println("s");
			  if(planeInfo.getTD(0).isEmpty()) {
				  assertTrue(planeInfo.getNoData().getText().contains("无数据"));
			  }else {
				  assertTrue(planeInfo.getTD(1).get(0).getText().contains(s));
				  //assertTrue(planeInfo.getTD(1).get(0).getText().contains(s.substring(5)));
			  }
			  
		  }
		@Test
		public void testPlaneDetailedInformation() throws InterruptedException {
			PlaneInformationPage planeInfo=PCPDriver.planeInformation();
			  Thread.sleep(5000);
			  List<WebElement> a=planeInfo.getTD(0);
			  List<String> planeList=planeInfo.detailedInformation();
			  for(int i=0;i<a.size();i++) {
				  System.out.println(a.get(i).getText());
				  System.out.println(planeList.get(i));
				  assertTrue(a.get(i).getText().contains(planeList.get(i)));
				  
				  Thread.sleep(5000);
			  }
			  
			  
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		//航线数据测试用例
		@Test
		public void testFlightData() throws InterruptedException {
			FlightDataPage flightData=PCPDriver.flightData();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("RouteData"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testRouteInquire() throws InterruptedException {
			  FlightDataPage flightData=PCPDriver.flightData();
			  Thread.sleep(5000);
			  flightData.inquireRouteformation("桂林---昆明");
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  if(flightData.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flightData.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightData.getTD(1).size();i++) {
					  assertTrue(flightData.getTD(1).get(i).getText().contains("桂林---昆明"));
				  }
			  }
		  }
		@Test
		public void testStartAirportInquire() throws InterruptedException {
			  FlightDataPage flightData=PCPDriver.flightData();
			  Thread.sleep(5000);
			  String str=flightData.inquireStartAirportformation();
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  if(flightData.getTD(0).isEmpty()) {
				  assertTrue(flightData.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightData.getTD(1).size();i++) {
					  assertTrue(flightData.getTD(1).get(i).getText().contains(str));
				  }
			  }
		  }
		@Test
		public void testEndAirportInquire() throws InterruptedException {
			  FlightDataPage flightData=PCPDriver.flightData();
			  Thread.sleep(5000);
			  String str=flightData.inquireEndAirportformation();
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  if(flightData.getTD(0).isEmpty()) {
				  assertTrue(flightData.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightData.getTD(1).size();i++) {
					  assertTrue(flightData.getTD(1).get(i).getText().contains(str));
				  }
			  }
		  }
		//航线特点测试用例
		@Test
		public void testFlightCharacteristic() throws InterruptedException {
			FlightCharacteristicPage flightCharact=PCPDriver.flightCharacteristic();
			  Thread.sleep(5000);
			 
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireFlightCharacteristic() throws InterruptedException {
			FlightCharacteristicPage flightCharact=PCPDriver.flightCharacteristic();
			  Thread.sleep(5000);
			  flightCharact.inquireRouteformation("丽江---贵阳");
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
			  if(flightCharact.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flightCharact.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightCharact.getTD(0).size();i++) {
					  assertTrue(flightCharact.getTD(0).get(i).getText().contains("丽江---贵阳"));
				  }
			  }
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		//飞机故障保留测试用例
		@Test
		public void testPlaneFault() throws InterruptedException {
			PlaneFaultPage planeFault=PCPDriver.planeFault();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("AircraftMEL"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquirePlaneNo() throws InterruptedException {
			PlaneFaultPage planeFault=PCPDriver.planeFault();
			  Thread.sleep(5000);
			 String s =planeFault.inquirePlaneNoformation();
			  Thread.sleep(5000);
			  if(planeFault.getTD(0).isEmpty()) {
				  System.out.println(1);
				  //assertTrue(planeFault.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<planeFault.getTD(3).size();i++) {
					  assertTrue(planeFault.getTD(3).get(i).getText().contains(s));
				  }
			  }
		  }
		//航班调整
		@Test
		public void testFlightchange() throws InterruptedException {
			FlightchangePage flightChange=PCPDriver.flightchange();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("FlightAdjustment"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireFlightNo() throws InterruptedException {
			FlightchangePage flightchange=PCPDriver.flightchange();
			  Thread.sleep(5000);
			  System.out.println(222);
			  flightchange.inquireRouteNoinformation("1234");
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flightchange.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flightchange.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightchange.getTD(3).size();i++) {
					  assertTrue(flightchange.getTD(3).get(i).getText().contains(""));
				  }
			  }
		  }
		@Test
		public void testInquireFlightDate() throws InterruptedException {
			FlightchangePage flightchange=PCPDriver.flightchange();
			  Thread.sleep(5000);
			  System.out.println(222);
			  flightchange.inquireRouteDateinformation(2016, 8, 1);
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flightchange.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flightchange.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flightchange.getTD(3).size();i++) {
					  assertTrue(flightchange.getTD(3).get(i).getText().contains(""));
				  }
			  }
		  }
		//准备情况测试用例
		@Test
		public void testReadyInformation() throws InterruptedException {
			ReadyInformationPage ready=PCPDriver.readyInformation();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("PreparCondition"));
			 
			 
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireReadyInformation() throws InterruptedException {
			ReadyInformationPage ready=PCPDriver.readyInformation();
			  Thread.sleep(5000);
			  //assertTrue(this.driver.getCurrentUrl().contains("PreparCondition"));
			  //myFlyHours.getDate();
			  System.out.println(222);
			  ready.inquireRouteNoinformation(2018, 1, 16);;
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(ready.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(ready.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<ready.getTDNext(3).size();i++) {
					  assertTrue(ready.getTDNext(3).get(i).getText().contains("2018-01-16"));
				  }
			  }
			  Thread.sleep(5000);
		  }
		//飞行时间测试用例
		@Test
		public void testFlyTime() throws InterruptedException {
			FlyTimePage flyHours=PCPDriver.flyTime();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("AllFlightHours"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireNameFlyTime() throws InterruptedException {
			FlyTimePage flyHours=PCPDriver.flyTime();
			  Thread.sleep(5000);
			  flyHours.inquireNameFlyTimeInformation("aaa");;
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flyHours.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flyHours.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flyHours.getTD(3).size();i++) {
					  assertTrue(flyHours.getTD(3).get(i).getText().contains(""));
				  }
			  }
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireDateFlyTime() throws InterruptedException {
			FlyTimePage flyHours=PCPDriver.flyTime();
			  Thread.sleep(5000);
			  flyHours.inquireDateinformation(2018, 1, 1,2018,1,18);;
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flyHours.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flyHours.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flyHours.getTD(3).size();i++) {
					  assertTrue(flyHours.getTD(3).get(i).getText().contains("2018-01-16"));
				  }
			  }
		  }
		
		
		//飞行计划排班情况测试用例
		@Test
		public void testFlyPlan() throws InterruptedException {
			FlyPlanPage flyPlan=PCPDriver.flyPlan();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("FlightPlan"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireNameFlyPlan() throws InterruptedException {
			FlyPlanPage flyPlan=PCPDriver.flyPlan();
			  Thread.sleep(5000);
			  flyPlan.inquireNameFlyPlanInformation("闫亚南");
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flyPlan.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flyPlan.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flyPlan.getTD(5).size();i++) {
					  assertTrue(flyPlan.getTD(5).get(i).getText().contains(""));
				  }
			  }
		  }
		@Test
		public void testInquireFlightNoFlyPlan() throws InterruptedException {
			FlyPlanPage flyPlan=PCPDriver.flyPlan();
			  Thread.sleep(5000);
			  flyPlan.inquireFlightNoFlyPlanInformation("NS3284");
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flyPlan.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flyPlan.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flyPlan.getTD(0).size();i++) {
					  assertTrue(flyPlan.getTD(0).get(i).getText().contains(""));
				  }
			  }
		  }
		@Test
		public void testInquireDateFlyPlan() throws InterruptedException {
			FlyPlanPage flyPlan=PCPDriver.flyPlan();
			  Thread.sleep(5000);
			  flyPlan.inquireDateinformation(2018, 1, 11,2018,1,12);
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(flyPlan.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(flyPlan.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<flyPlan.getTD(4).size();i++) {
					  assertTrue(flyPlan.getTD(4).get(i).getText().contains(""));
				  }
			  }
		  }
		
		
		//订座信息测试用例
		@Test
		public void testReservationInformation() throws InterruptedException {
			ReservationInformationPage reser=PCPDriver.reservationInformation();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("EtermCabinInfo"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireFlightNoReservationInformation() throws InterruptedException {
			ReservationInformationPage reser=PCPDriver.reservationInformation();
			  Thread.sleep(5000);
			  reser.inquireFlightNoFlyPlanInformation("NS3221");
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(reser.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(reser.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<reser.getTD(0).size();i++) {
					  assertTrue(reser.getTD(0).get(i).getText().contains("NS3221"));
				  }
			  }
		  }
		@Test
		public void testInquireFlightDateReservationInformation() throws InterruptedException {
			ReservationInformationPage reser=PCPDriver.reservationInformation();
			  Thread.sleep(5000);
			  reser.inquireDateinformation(2017, 10, 1);
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(reser.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(reser.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<reser.getTD(1).size();i++) {
					  System.out.println(reser.getTD(1).get(i).getText());
					  assertTrue(reser.getTD(1).get(i).getText().contains("2017-10-01"));
				  }
			  }
		  }
		//气象资料测试用例
		@Test
		public void testWeaterInformation() throws InterruptedException {
			WeaterInformationPage myFlyHours=PCPDriver.weaterInformation();
			  Thread.sleep(5000);
			  assertTrue(this.driver.getCurrentUrl().contains("WeatherData"));
			  //myFlyHours.getDate();
			  Thread.sleep(5000);
		  }
		@Test
		public void testInquireWeaterInformation() throws InterruptedException {
			WeaterInformationPage weater=PCPDriver.weaterInformation();
			  Thread.sleep(5000);
			  String s=weater.inquireWeaterInformation();
			  System.out.println(333);
			  Thread.sleep(5000);
			  if(weater.getTD(0).isEmpty()) {
				  System.out.println(1);
				  assertTrue(weater.getNoData().getText().contains("无数据"));
			  }else {
				  System.out.println(2);
				  for(int i=0;i<weater.getTD(1).size();i++) {
					  assertTrue(weater.getTD(0).get(0).getText().contains(s.substring(0,3)));
					  assertTrue(weater.getTD(1).get(0).getText().contains(s.substring(5)));
				  }
			  }
		  }
}

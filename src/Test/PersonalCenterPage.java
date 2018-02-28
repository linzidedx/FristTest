package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalCenterPage extends DashPage {

	public  PersonalCenterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By personalInfoCenter=By.linkText("������Ϣ����");
	//By personalInfoCenter=By.xpath("/html/body/div/aside[1]/section/ul/li[2]/a");
	By myFlyHoursLocator=By.linkText("�ҵķ���Сʱ");
	By historyFlyRecordLocator=By.linkText("��ʷ���м�¼");
	By personalTrainLocator=By.linkText("����ѵ�����");
	By QAREventLocator=By.linkText("QAR�¼���ѯ");
	By certificateInformationLocator=By.linkText("֤����Ϣ");
	By personalQualificationLocator=By.linkText("��������");
	By detailedInformationLocator=By.linkText("��ϸ��Ϣ");
	By changePasswordLocator=By.linkText("�޸�����"); 
	
	public WebElement getPersonalInfoCenterLink() {
		return this.driver.findElement(personalInfoCenter);
	}
	public WebElement getMyFlyHoursLink() {
		return this.driver.findElement(myFlyHoursLocator);
	}
	public WebElement getHistoryFlyRecordLink() {
		return this.driver.findElement(historyFlyRecordLocator);
	}
	public WebElement getPersonalTrainLink() {
		return this.driver.findElement(personalTrainLocator);
	}
	public WebElement getQAREventLink() {
		return this.driver.findElement(QAREventLocator);
	}
	public WebElement getCertificateInformationLink() {
		return this.driver.findElement(certificateInformationLocator);
	}
	public WebElement getPersonalQualificationLink() {
		return this.driver.findElement(personalQualificationLocator);
	}
	public WebElement getDetailedInformationLink() {
		return this.driver.findElement(detailedInformationLocator);
	}
	public WebElement getChangePasswordLink() {
		return this.driver.findElement(changePasswordLocator);
	}
	public PersonalInfoCenterPage personalInfoCenter() {
		this.getPersonalInfoCenterLink().click();
		return new PersonalInfoCenterPage(this.driver);
	}
	public MyFlyHoursPage myFlyHours() {
		this.getMyFlyHoursLink().click();
		return new MyFlyHoursPage(this.driver);
	}
	public HistoryFlyRecordPage historyFlyRecord() {
		this.getHistoryFlyRecordLink().click();
		return new HistoryFlyRecordPage(this.driver);
	}
	public PersonalTrainPage personalTrain() {
		this.getPersonalTrainLink().click();
		return new PersonalTrainPage(this.driver);
	}
	public QAREventPage QAREvent() {
		this.getQAREventLink().click();
		return new QAREventPage(this.driver);
	}
	public CertificateInformationPage certificateInformation() {
		this.getCertificateInformationLink().click();
		return new CertificateInformationPage(this.driver);
	}
	public PersonalQualificationPage personalQualification() {
		this.getPersonalQualificationLink().click();
		return new PersonalQualificationPage(this.driver);
	}
	public DetailedInformationPage detailedInformation() {
		this.getDetailedInformationLink().click();
		return new DetailedInformationPage(this.driver);
	}
	public ChangePasswordPage changePassword() {
		this.getChangePasswordLink().click();
		return new ChangePasswordPage(this.driver);
	}
}







package logo.module;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import logo.log.SelLogger;

public class PublicModule {
	private static final SelLogger logger=SelLogger.getLogger(PublicModule.class);
	
	public void waitForPageLoadByID(final String ID,WebDriver browser) {
		try {
			WebDriverWait wait=new WebDriverWait(browser,10);
			wait.until(new ExpectedCondition<WebElement>() {
//				public WebElement Apply(WebDriver d) {
//					return d.findElement(By.id(ID));
//				}
//
//				@Override
				public WebElement apply(WebDriver d) {
					// TODO Auto-generated method stub
					return d.findElement(By.id(ID));
				}
				
				
			});
			if(null==wait){
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);
				browser.quit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);
			browser.quit();
		}
	}

	public void waitForPageLoadBylinkText(final String linkText,WebDriver browser) {
		try {
			WebDriverWait wait=new WebDriverWait(browser,10);
			wait.until(new ExpectedCondition<WebElement>() {
//				public WebElement Apply(WebDriver d) {
//					return d.findElement(By.id(ID));
//				}
//
//				@Override
				public WebElement apply(WebDriver d) {
					// TODO Auto-generated method stub
					return d.findElement(By.linkText(linkText));
				}
				
				
			});
			if(null==wait){
				this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);
				browser.quit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			this.CaptureScreenshot(Thread.currentThread().getId()+"ID",browser);
			browser.quit();
		}
	}
	
	
	public boolean switchToWindow_Title(WebDriver driver,String windowTitle) {
		boolean flag=false;
		try {
			String cueewntHandle=driver.getWindowHandle();
			Set<String>handles= driver.getWindowHandles();
			for( String s: handles){
				if(s.equals(cueewntHandle))
					continue;
				else {
					driver.switchTo().window(s);
					
					if(driver.getTitle().contains(windowTitle)) 
					{
						flag=true;
						break;
					}else {
						continue;
					}
					
				}
				
			}
		}catch(NoSuchWindowException e) {
			System.out.println("Window:"+windowTitle+"cound not find!!!"+e.fillInStackTrace());
			flag=false;
		}
		return flag;
	}
	
	

	public boolean switchToWindow_Url(WebDriver driver,String windowUrl) {
		boolean flag=false;
		try {
			String cueewntHandle=driver.getWindowHandle();
			Set<String>handles= driver.getWindowHandles();
			for( String s: handles){
				if(s.equals(cueewntHandle))
					continue;
				else {
					driver.switchTo().window(s);
					
					if(driver.getTitle().contains(windowUrl)) 
					{
						flag=true;
						break;
					}else {
						continue;
					}
					
				}
				
			}
		}catch(NoSuchWindowException e) {
			System.out.println("Window:"+windowUrl+"cound not find!!!"+e.fillInStackTrace());
			flag=false;
		}
		return flag;
	}
	protected void CaptureScreenshot(String fileName, WebDriver driver) {
		String dirName="test-output/screenshot";
		if(!(new File(dirName).isDirectory())) {
			new File(dirName).mkdirs();
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time=sdf.format(new Date(0));
		TakesScreenshot tsDriver=(TakesScreenshot)driver;
		File image=new File(dirName+File.separator+time+"_"+fileName+".png");
		tsDriver.getScreenshotAs(OutputType.FILE).renameTo(image);
		
		
	}
}

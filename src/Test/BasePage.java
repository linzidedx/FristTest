package Test;
import org.openqa.selenium.WebDriver;

public class BasePage {
	protected final WebDriver driver;
	protected String url;
	
	public  BasePage(WebDriver driver) {
		this.driver=driver;
	}
	public void goTo() {
		this.driver.get(this.url);
	}
}

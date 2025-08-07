package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

	WebDriver driver;
	By addBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]");
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By Empid = By.xpath(
			"//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
	By Savebtn = By.xpath("//button[@type='submit']");
	By empList = By.xpath("//a[normalize-space()='Employee List']");
	By add = By.xpath("//button[normalize-space()='Add']");
	By firstPage = By.cssSelector("button[class='oxd-pagination-page-item oxd-pagination-page-item--previous-next'] i[class='oxd-icon bi-chevron-left']");

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAdd() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(addBtn));

		Actions actions = new Actions(driver);
		actions.moveToElement(Add).click().perform();
	}

	public void enterEmployeeName(String first, String last, String id) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("First name " + first + " " + last);
		driver.findElement(FirstName).sendKeys(first);
		driver.findElement(LastName).sendKeys(last);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement empIdField = wait.until(ExpectedConditions.elementToBeClickable(Empid));
		empIdField.click();
		empIdField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		empIdField.sendKeys(Keys.DELETE);
		empIdField.sendKeys(id);

	}

	public void saveEmployee() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(Savebtn));
		saveButton.click();
		// Waiting for 2 sec, as data is taking some time to save
		try {
			Thread.sleep(Duration.ofSeconds(2)); 
		} catch(Exception e) {}
	}

	public void employeeList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement empListButton = wait.until(ExpectedConditions.elementToBeClickable(empList));
		empListButton.click();
	}

	public void addEmployee() {
		driver.findElement(add).click();
	}

	public void selectFirstPage() {
		do {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement prevButton = wait.until(ExpectedConditions.elementToBeClickable(firstPage));
				prevButton.click();
			}catch (Exception e) {
				break;
			}
		} while(true);
		
	}

}

package googleprogs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitiongoogle {
	WebDriver driver=null;
	@Given("user is on Google Page")
	public void user_is_on_google_page() {
		WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
	}
	@When("user inputs data inside search text field {string}")
	public void user_inputs_data_inside_search_text_field(String string) {
	    
	    WebElement search=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
	    search.sendKeys(string,Keys.ENTER);
	   
	}

	@Then("validate whether the results contains the {string}")
	public void validate_whether_the_results_contains_the(String string) {
	   List<WebElement> list= driver.findElements(By.tagName("span"));
	   int count=0;
	   for(int i=0;i<list.size();i++)
	   {
		   if(list.get(i).getText().contains(string))
			   count++;
	   }
	   System.out.println(count);
	   Assert.assertTrue(count>=5);
	}

}

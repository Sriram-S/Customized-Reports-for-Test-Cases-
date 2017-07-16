import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_script extends report {
	 public static void main(String[] args) throws HeadlessException, AWTException 
	    {
	        try {
	        	report rep=new report();
	        	rep.TC_Name("Test Case: Chrome Driver Test");
	        	System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Desktop/Chrome/chromedriver_win32 (1)/chromedriver.exe");
	           rep.takescreenshot();
	       	rep.StepDef("Launching Chrome", "Passed",filename);
	        	ChromeDriver driver=new ChromeDriver();
	        	driver.get("https://www.google.com");
	        	 rep.takescreenshot();
	        	rep.StepDef("Launching Google", "Passed",filename);        
	            WriteToFile(htmlBuilder.toString(),"testfile.html");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

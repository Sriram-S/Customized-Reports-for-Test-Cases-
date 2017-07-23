import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_script extends report {

	public static BasePage base=new BasePage();
	 public static void main(String[] args) throws HeadlessException, AWTException 
	    {
		 
	        try {
	        	report rep=new report();
	        	rep.TC_Name("Test Case: Chrome Driver Test");
	        	
	        	base.launch_chrome();
	        	
	        	base.serach("TCS");
	        	
	        	
	            WriteToFile(htmlBuilder.toString(),"testfile.html");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

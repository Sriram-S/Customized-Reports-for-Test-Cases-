import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class BasePage extends report {
	

  private static WebDriver driver;
 private static long starttime;
 private static long endtime;
 private static long diff;
 private static long hour;
 private static long min;
 private static long sec;
 private static float dif;
 private static String time_taken;
 
  BasePage(){
	  
  }
 
  
  public static void record_start_time(){
	  starttime=System.currentTimeMillis();
  }
  
 public static void record_end_time(){
	 endtime=System.currentTimeMillis();
  }
  
  
 public void reset(){
	 starttime=endtime=sec=hour=min=0;
	 time_taken=null;
 }
 
 public void calculate(){
	 diff=endtime-starttime;
	 sec= (diff /1000) % 60;
	 min =(diff /(1000*60)) %60;
	 hour=(diff /(100*60*60)) %24;
	 if(sec==0){
		 
		
		 dif= (float)diff/1000;
		
		 time_taken=hour +":" +min + ":"+dif;
		 return;
	 }
	
	 time_taken=hour +":" +min + ":"+sec;
 }
  
	public void launch_chrome() throws HeadlessException, AWTException, IOException{
		try{
		record_start_time();
			System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
			record_end_time();
			
		
			calculate();
			
			System.out.println(hour +":" +min + ":"+sec);
			System.out.println("Diff" +diff);
        	takescreenshot();
         	StepDef("Launching Chrome","Passed",filename,time_taken);
         	reset();
		}
		
		catch(Exception e){
			takescreenshot();
         	StepDef("Launching Chrome", "Failed",filename,time_taken);
		}
	}
	
	public void serach(String search) throws HeadlessException, AWTException, IOException{
		try{
			record_start_time();
			driver.findElement(By.id("lst-ib")).sendKeys(search);
			driver.findElement(By.id("_fZl")).click();
			record_end_time();
			calculate();
			System.out.println("Diff" +diff);
			System.out.println(hour +":" +min + ":"+sec);
			takescreenshot();
         	StepDef("Enter Search String in Google", "Passed",filename,time_taken);
         	reset();
		}
         	catch(Exception e){
         		System.out.println(e.toString());
    			takescreenshot();
             	StepDef("Enter Search String in Google", "Failed",filename,time_taken);
    		}
		
		
	}
}

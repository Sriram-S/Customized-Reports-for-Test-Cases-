import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.imageio.ImageIO;


public class report {
	static StringBuilder htmlBuilder=new StringBuilder();
	private static int i;
	protected static int filename;
	report(){
		 htmlBuilder.append("<html><head><title>Test Case Report </title> <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" /></head>");
         //append body
         htmlBuilder.append("<body>");
	}
	public void TC_Name(String name){
		htmlBuilder.append("<p><font size=\"12\"color=\"blue\"><center>"+ name +"</center></font></p>");
	
		 htmlBuilder.append("<table border=\"2\" bordercolor=\"#000000\">");
         //append row
         htmlBuilder.append("<tr><td><b>Step No.</b></td><td><b>Step Name</b></td><td><b>TestResult</b></td><td><b>Total Time</b></td></tr>");
	}
	
	public void StepDef(String step,String res,int number,String time)
	{
		
		 i++;
		 if(res.equalsIgnoreCase("Passed")){
			 htmlBuilder.append("<tr><td>"+ i+"</td><td>" +step +"</td><td><b><a href=\"C://Users//HP/workspace/Customized_Reports/screenshot/"+filename+".png\" target=\"_blank\" class=\"green\"> "+ res +"</a></b></td><td>" +time+ " </tr>"); 
		 }
		 
		 if(res.equalsIgnoreCase("Failed")){
			 htmlBuilder.append("<tr><td>"+ i+"</td><td>" +step +"</td><td><b><a href=\"C://Users//HP/workspace/Customized_Reports/screenshot/"+filename+".png\" target=\"_blank\" class=\"red\"> "+ res +"</a></b></td></tr>"); 
		 }
		
         filename++;
	}
	
	
	public void takescreenshot() throws HeadlessException, AWTException, IOException{
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    	ImageIO.write(image, "png", new File("C://Users/HP/workspace/Customized_Reports/screenshot/"+ filename+".png"));
	}
	
	    public static void WriteToFile(String Content, String fileName) throws IOException {
	    	 htmlBuilder.append("</table></body></html>");
	    	String projectPath = System.getProperty("user.dir");
	        String tempFile = projectPath + File.separator+fileName;
	        File file = new File(tempFile);      
	        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
	        Writer writer=new OutputStreamWriter(outputStream);
	        writer.write(Content);
	        writer.close();

	    }
}

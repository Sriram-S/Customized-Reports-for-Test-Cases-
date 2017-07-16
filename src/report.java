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
         htmlBuilder.append("<tr><td><b>Step No.</b></td><td><b>Step Name</b></td><td><b>TestResult</b></td></tr>");
	}
	
	public void StepDef(String step,String res,int number)
	{
		 i++;
		 htmlBuilder.append("<tr><td>"+ i+"</td><td>" +step +"</td><td><b><a href=\"/screenshot/"+filename+".png\" target=\"_blank\" color=\"green\"> "+ res +"</a></b></td></tr>");
         filename++;
	}
	
	
	public void takescreenshot() throws HeadlessException, AWTException, IOException{
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    	ImageIO.write(image, "png", new File("/screenshot/"+ filename+".png"));
	}
	
	    public static void WriteToFile(String Content, String fileName) throws IOException {
	    	 htmlBuilder.append("</table></body></html>");
	    	String projectPath = System.getProperty("user.dir");
	        String tempFile = projectPath + File.separator+fileName;
	        File file = new File(tempFile);
	        // if file does exists, then delete and create a new file
	        if (file.exists()) {
	            try {
	                File newFileName = new File(projectPath + File.separator+ "Previous-"+fileName);
	                file.renameTo(newFileName);
	                file.createNewFile();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        //write to file with OutputStreamWriter
	        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
	        Writer writer=new OutputStreamWriter(outputStream);
	        writer.write(Content);
	        writer.close();

	    }
}

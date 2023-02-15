package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }

        return driver;
    }
    public static String getData (String keyName) {
        File FileData = new File("/Users/ifirst/Downloads/SecondProject/src/main/resources/FileData.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc=null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc= dBuilder.parse(FileData);
            doc.getDocumentElement().normalize();


        } catch (Exception e){
            e.printStackTrace();
        }
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}
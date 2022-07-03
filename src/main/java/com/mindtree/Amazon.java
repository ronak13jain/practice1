package com.mindtree;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//this is updated for testing
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//step1
		driver.get("https://www.amazon.in/");
		
		//step2
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("refrigerator");
		
		//step3&step4
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		//step5
	    WebElement we=driver.findElement(By.xpath("(//div[@data-asin='B08SC2ZTDP'] //span[@class='a-price-whole'])"));
		String price1=we.getText();
		//String con=".00";
		//String price1=pri.concat(con);
		System.out.println(price1);
		
		//step6
		driver.findElement(By.xpath("//img[contains(@alt,'Samsung 192 L 2')]")).click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String pid=it.next();
		String cid=it.next();
		driver.switchTo().window(cid);
		
		//step7
		 WebElement wc=driver.findElement(By.xpath("//div[@id='apex_desktop'] //span[@class='a-price-whole']"));
		 String price2=wc.getText();
		System.out.println(price2);
		
		if(price1.equals(price2)) 
		{
			System.out.println("Price is same on both tab");
			
		}
		else {
			System.out.println("price is different");
		}
		
		//step8
		//String weight=driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[78]")).getText();
	   //  Point index=driver.findElement(By.xpath("//table[@id='HLCXComparisonTable']"))
		//System.out.println("weight is "+index); 
		//$x("//table[@id='HLCXComparisonTable'] //tr[@class='a-span3 comparison_attribute_name_column comparison_table_first_col'] //span[@class='a-size-base a-color-base']")
		//"//table[@id='HLCXComparisonTable'] //tr[@class='comparison_other_attribute_row']"
	}
}


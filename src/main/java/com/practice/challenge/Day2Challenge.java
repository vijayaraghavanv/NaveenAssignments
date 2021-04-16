package com.practice.challenge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.pageobjects.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Challenge extends PageObjects {
	static WebDriver driver;
	static LinkedList<String> caruoselItems;
	static boolean flag = false;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		caruoselItems = new LinkedList<String>();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();
		caruoselItems = getSectionName("Recommended For You");
		Collections.sort(caruoselItems);
		for (String string : caruoselItems) {
			System.out.println(string);
		}
		driver.quit();
	}

	public static LinkedList<String> getSectionName(String carousel) {
		RetrieveCarousel = RetrieveCarousel.replaceAll("sectionName", carousel);
		swiperButton = swiperButton.replaceAll("sectionName", carousel);
		List<WebElement> listItems = driver.findElements(By.xpath(RetrieveCarousel));
		WebElement swiperBtn = driver.findElement(By.xpath(swiperButton));
		while (swiperBtn.isEnabled()) {
			for (WebElement webElement : listItems) {
				if (webElement.isDisplayed()) {
					// System.out.println(webElement.getText());
					caruoselItems.add(webElement.getText());
				} else if (swiperBtn.isDisplayed()) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].scrollIntoView(true);", swiperBtn);
					swiperBtn.click();
				} else {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		return caruoselItems;
	}

}

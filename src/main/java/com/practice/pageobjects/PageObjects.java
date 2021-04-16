package com.practice.pageobjects;

import org.openqa.selenium.By;

public class PageObjects {
	
	//public static String RetrieveCarousel="//*[text()='sectionName']/../../following-sibling::div//*[contains(@class,'swiper-slide')]";
	public static String RetrieveCarousel="//*[text()='sectionName']/../../following-sibling::div//*[contains(@class,'swiper-slide')]//div[@data-qa='product-name']//div";
	public static String swiperButton="//*[text()='sectionName']/../../following-sibling::div//*[contains(@class,'swiper-button-next')]";
	public static String swiperButtonDisabled="//*[text()='sectionName']/../../following-sibling::div//*[contains(@class,'swiper-button-disabled')]";

}

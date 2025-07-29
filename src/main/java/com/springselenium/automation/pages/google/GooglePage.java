package com.springselenium.automation.pages.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springselenium.automation.pages.AbstractPage;

@Component
public class GooglePage extends AbstractPage {

	@Value("${application.url}")
	private String url;
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	@FindBy(name = "btnK")
	private WebElement searchBtn;
	
	@Override
	public boolean isAt() {
		return wait.until((d) -> searchBox.isDisplayed());
	}
	
	public void goTo() {
		driver.get(url);
	}

	public void search(String search) {
		searchBox.sendKeys(search);
	}

	public void clickSearch() {
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void quit() {
		driver.quit();
	}
	
}

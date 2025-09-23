package com.springselenium.automation.pages.google;

import com.springselenium.automation.annotation.LazyComponent;
import com.springselenium.automation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class GooglePage extends AbstractPage {

	@Value("${application.url}")
	private String url;

	private final By searchBox = By.name("q");

	private final By searchBtn = By.name("btnK");

	@Override
	public boolean isAt() {
		return wait.until((d) -> driver.findElement(searchBox).isDisplayed());
	}
	
	public void goTo() {
		driver.get(url);
	}

	public void search(String search) {
		driver.findElement(searchBox).sendKeys(search);
	}

	public void clickSearch() {
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
}
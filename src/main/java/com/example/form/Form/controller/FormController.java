package com.example.form.Form.controller;

import java.util.List;

import javax.validation.Valid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.web.server.WebServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.Form.pojo.Form;

@Controller
public class FormController {
	
	private boolean isElementPresent;
	
	@GetMapping("/")
	public String displayForm(Model model) {
		model.addAttribute("formData", new Form());
		return "form";
	}
	
	@PostMapping("/submit")
	public String submitForm(@ModelAttribute("formData") @Valid Form formData, Model model) {
		model.addAttribute("result", formData);
		List<String> selectedBrowsers = formData.getBrowsers();
		String url = formData.getUrl();
		for(String browser : selectedBrowsers) {
			openUrlInSelectedBrowser(url, browser);
			model.addAttribute("url", url);
	        model.addAttribute("selectedBrowsers", selectedBrowsers);
	        model.addAttribute("isElement", isElementPresent);
		}
		return "form";
	}
	
	private void openUrlInSelectedBrowser(String url, String browser) {
		WebDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
		if("chrome".equals(browser)) {
			System.setProperty(
		            "webdriver.chrome.driver",
		            "D://chromedriver.exe/");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	        driver.get(url);
	        boolean notExists = driver.findElements(By.className("lnXdpd")).isEmpty();
	        if(notExists) {
	        	isElementPresent = false;
	        } else {
	        	isElementPresent = true;
	        }

		}
		
		if("edge".equals(browser)) {
			System.setProperty(
		            "webdriver.edge.driver",
		            "D:/msedgedriver.exe");
			driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.get(url);
	        boolean notExists = driver.findElements(By.className("lnXdpd")).isEmpty();
	        if(notExists) {
	        	isElementPresent = false;
	        } else {
	        	isElementPresent = true;
	        }
		}
	}
	
	
}

'''
Created on 04-Mar-2020

@author: eviupay
'''
from automation import getWebDriver
from automation import SeleniumEnhancements
from automation.SeleniumEnhancements import switchWindowByPartialTitle
from selenium.webdriver.common.by import By
import time

driver = getWebDriver.getDriverInstance()
driver.get("https://www.goindigo.in/")
time.sleep(4)

driver.find_element_by_xpath("//button[contains(text(),'Accept cookies')]").click()
driver.find_element_by_name("or-src").send_keys("DE")
autosuggest_src = driver.find_elements_by_css_selector("div.autocomplete-results.autocomplete-main.station-results div.wrap div[data-name]")
time.sleep(1)
for webElement_src in autosuggest_src:
    if webElement_src.get_attribute("data-name").lower() == "Delhi".lower() :
        webElement_src.click()
        break
    
driver.find_element_by_name("or-dest").send_keys("CH")
autosuggest_dest = driver.find_elements_by_css_selector("div.autocomplete-results.autocomplete-main.station-results div.wrap div[data-name]")
time.sleep(1);
for webElement_dest in autosuggest_dest:
    if webElement_dest.get_attribute("data-name").lower() == "Chennai".lower() and webElement_dest.is_displayed() :
        webElement_dest.click()
        break
  
driver.find_element_by_xpath("//td[@data-handler='selectDay' and @data-month='8' and @data-year='2020']/a[text()='7']").click()
print("EoE")

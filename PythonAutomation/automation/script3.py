'''
Created on 04-Mar-2020

@author: eviupay
'''
from automation import getWebDriver
from automation import SeleniumEnhancements
from automation.SeleniumEnhancements import switchWindowByPartialTitle
from selenium.webdriver.common.by import By

driver = getWebDriver.getDriverInstance()
driver.get("https://www.amazon.in")

driver.find_element_by_id("twotabsearchtextbox").send_keys("samsung galaxy m30s mobile")
driver.find_element_by_id("twotabsearchtextbox").submit()

link = driver.find_element(By.PARTIAL_LINK_TEXT,"Samsung Galaxy M30s")
link.click()
print(driver.current_window_handle)
print("xxxx");

switchWindowByPartialTitle(driver,"Samsung Galaxy M30s (Blue, 6GB RAM, 128GB Storage)")
print(driver.current_window_handle)

value = driver.find_element(By.XPATH, "//div[@id='ddmDeliveryMessage']/span[@class='a-text-bold']").text
print(value)
print("----")
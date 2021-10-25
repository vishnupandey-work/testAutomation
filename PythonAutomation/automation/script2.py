'''
Created on 11-Oct-2019

@author: eviupay
'''


from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from automation import getWebDriver
import time

user = "ESRIKRI"
pwd = "ESRIKRI123"

driver = getWebDriver.getDriverInstance('firefox')
#driver.get("https://10.31.114.11:30010/custcare_cu/login")
driver.get("http://10.31.119.149:48890/custcare_cu/login")
#try:
    
time.sleep(2)
driver.find_element_by_id('j_username').send_keys(user)
driver.find_element_by_id('j_password').send_keys(pwd)
driver.find_element_by_id('j_username').send_keys(Keys.RETURN)
time.sleep(10)

list_of_rows = driver.find_elements_by_xpath('//*[@id="BUSINESS_UNITS"]')
for row in list_of_rows:
    print(row.GET_ELEMENT_ATTRIBUTE)
time.sleep(10)
driver.find_element_by_id("form_formTag_SuOkButton").click()
time.sleep(10)

print("where am i?")
# except Exception:
#    print(Exception)
#finally: 
#driver.quit()    
'''
Created on 04-Mar-2020

@author: eviupay
'''
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from automation import getWebDriver



def switchWindowByPartialTitle( driver , partialTitle):
    windowHandles = driver.window_handles
    for windowHandle in windowHandles : 
        flag = False
        driver.switch_to_window(windowHandle)
        title = driver.get_title()
        if title.contains(partialTitle):
            driver.switch_to_window(windowHandle)
            flag = True
            break
        if flag == True :
            break

def scrollIntoView(driver, element):
    driver.execute_script("arguments[0].scrollIntoView();", element)
    
    
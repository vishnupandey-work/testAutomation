'''
Created on 11-Oct-2019

Returns a webdriver instance based on value of parameter passed to function getDriverInstance.
It takes a parameter param , with a default value as None.

Syntax:
getDriverInstance()
getDriverInstance('ie')   -- case insensitive
getDriverInstance('firefox') -- case insensitive
getDriverInstance('chrome') -- case insensitive
getDriverInstance(0)
getDriverInstance(1)
getDriverInstance(2)

@author: eviupay
'''
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import os
from selenium.webdriver.firefox import firefox_profile
from selenium.webdriver.firefox.options import Options

def getDriverInstance(param=None):
    pathName = os.getcwd()
    geckoPath = pathName+"\webdriver\geckodriver.exe"
    chromePath = pathName+"chromedriver.exe"
    iePath = pathName+"\webdriver\IEDriverServer.exe"
    if param is None:
        ops = Options()
        ops.set_preference("geo.enabled", False)
        ops.set_preference("geo.provider.use_corelocation", False)
        ops.set_preference("geo.prompt.testing",False)
        ops.set_preference("geo.prompt.testing.allow", False)
        driver = webdriver.Firefox(executable_path=geckoPath, firefox_options=ops)
        driver.set_page_load_timeout(60)
        driver.implicitly_wait(40)
        driver.delete_all_cookies()
        driver.maximize_window()
        return driver
    
    elif str(param) == '0' or param.casefold() == 'firefox' :
        proxyString = "127.0.0.1:3077"
        #profile = webdriver.FirefoxProfile()
        #profile.accept_untrusted_certs = True
        desired_capability = webdriver.DesiredCapabilities.FIREFOX
        desired_capability['proxy'] = {
            "proxyType": "manual",
            #"httpProxy": proxyString,
            #"ftpProxy": proxyString,
            #"sslProxy": proxyString,
            "socksProxy": proxyString,
            "socksVersion": 4
        }
        desired_capability['acceptSslCerts'] = True
        driver = webdriver.Firefox(executable_path=geckoPath,capabilities=desired_capability)
        return driver
    
    elif str(param) == '1' or param.casefold() == 'chrome'  :
        os.environ["webdriver.chrome.driver"] = chromePath
        driver = webdriver.Chrome(chromePath)
        return driver
    
    elif  str(param) == '2' or param.casefold() == 'ie' :
        driver = webdriver.Ie(iePath)
        return driver
    
    else :
        driver = webdriver.Firefox(executable_path=geckoPath)
        return driver
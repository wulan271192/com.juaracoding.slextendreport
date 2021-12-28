package com.juaracoding.slextendreport.driver.strategies;

import com.juaracoding.slextendreport.utils.Constants;

public class DriverStrategyImplementer {
	
public static DriverStrategy chooseStrategy(String strategy) {
		
		switch (strategy) {
		case Constants.CHROME:
			  return new Chrome();
	
		case Constants.FIREFOX:
			 return new Firefox();
        
		default:
			return null;
		}
		
		
	}

}

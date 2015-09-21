package com.goeuro.testdev;

import com.goeuro.testdev.exception.GoeuroException;
import com.goeuro.testdev.util.GoeuroUtile;

public class GoeuroTestDev {

	public static void main(String[] args) {
		
		if(args != null){
			if(args.length>1 ){
				System.out.println("Please Enter only one Country ");
			}else if  ( args.length == 0){
				System.out.println("Please Enter Country ");
			}else{
				String countryName  = args[0].trim();
				if(!"".equals(countryName)){
					System.out.println("Enterd Value  =  "+countryName);
					Long start  = System.currentTimeMillis();
					System.out.println("start @ "+start);
					try {
						GoeuroUtile.callCityAPI(countryName);	
					} catch (GoeuroException ex) {
						System.err.println("Error occured ");
						ex.printStackTrace();
					}
					
					Long end  = System.currentTimeMillis()-start ; 
					System.out.println("total time  =  "+(end/1000));
				}else{
					System.out.println("Please Enter a Country Name ");
				}
			}
		}else{
			System.out.println("Please Enter a Country Name  ");
		}

	}

}

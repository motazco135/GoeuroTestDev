package com.goeuro.testdev.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.goeuro.testdev.dto.CityDTO;
import com.goeuro.testdev.exception.GoeuroException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GoeuroUtile {

	private static String filePath  =  "c:\\"; 
	
	public static void callCityAPI(String cityName) throws GoeuroException {
		try {
			Long start = System.currentTimeMillis();

			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://api.goeuro.com/api/v2/position/suggest/en/"+ cityName);

			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonText = EntityUtils.toString(response.getEntity(),HTTP.UTF_8);
				
				System.out.println("final result  =  " + jsonText);

				if (jsonText != null) {
					// Convert json String to Obj
					Gson gson = new Gson();
					List<CityDTO> citys = gson.fromJson(jsonText,
							new TypeToken<List<CityDTO>>() {
							}.getType());

					// Create CSV file
					createCSV(cityName, citys);

				}
			
				Long end = (System.currentTimeMillis() - start) / 1000;
				System.out.println("total time  API  = " + end);
			}

		}catch(GoeuroException ex){
			throw ex  ; 
		}catch (ClientProtocolException ex) {
			throw new GoeuroException(ex.getMessage(), "ClientProtocolException");
		}catch (IOException ex) {
			throw new GoeuroException(ex.getMessage(), "IOException");
		}
	}
	
	public static void createCSV (String cityName ,List<CityDTO> cityDTOs) throws GoeuroException {
		try {	
			if(cityDTOs != null && !cityDTOs.isEmpty()){
				String fileName  = filePath+cityName+".csv" ; 
				FileWriter writer = new FileWriter(fileName);
				
				 writer.append("_id");
				 writer.append(',');
				 writer.append("name");
				 writer.append(',');
				 writer.append("type");
				 writer.append(',');
				 writer.append("latitude");
				 writer.append(',');
				 writer.append("longitude");
				 writer.append('\n');
				 
				 for (CityDTO cityDTO : cityDTOs) {
					 writer.append(cityDTO.get_id()+"");
					 writer.append(',');
					 writer.append(cityDTO.getName()+"");
					 writer.append(',');
					 writer.append(cityDTO.getType()+"");
					 writer.append(',');
					 writer.append(cityDTO.getGeo_position().getLatitude()+"");
					 writer.append(',');
					 writer.append(cityDTO.getGeo_position().getLongitude()+"");
				     writer.append('\n');
				}
				 writer.flush();
				 writer.close();
				 
				 System.out.println("File create in the follwing Path "+fileName);
			}else{
				System.out.println("Result from API is Empty ");
			}
		} catch (IOException ex) {
			//ex.printStackTrace();
			throw new GoeuroException(ex.getMessage(), "IOException");
		}
		
	}
}

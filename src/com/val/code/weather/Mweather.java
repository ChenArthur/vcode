package com.val.code.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Mweather {
	
	public static String getWeather(String strUrl){
		StringBuffer json = new StringBuffer();
		try {
			URL url = new URL(strUrl);
			URLConnection uc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputFile = null;
			while((inputFile = in.readLine()) != null){
				json.append(inputFile);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	
	/**
	 * 方法一直接取json
	 *  http://wthrcdn.etouch.cn/weather_mini?city=北京
		通过城市名字获得天气数据，json数据
		http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
		通过城市id获得天气数据，json数据
		
		方法二 解析xml文件
		http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100
		通过城市id获得天气数据，xml文件数据,
		当错误时会有<error>节点
		http://wthrcdn.etouch.cn/WeatherApi?city=北京
		通过城市名字获得天气数据，xml文件数据

	 * @param args
	 */
	public static void main(String[] args) {
//		String url = "http://www.weather.com.cn/data/sk/101010100.html";
		String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
//		String url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101010100";
		String json = getWeather(url);
		System.out.println(json);
	}
}

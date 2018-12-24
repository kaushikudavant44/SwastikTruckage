package com.bionische.swastiktruckage.master.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
public class SMSSender {

	public static boolean send(String no,String msg)
	{   
		
		try 
		{
		
		String data="user=" + URLEncoder.encode("kaushikudavant", "UTF-8");
		data +="&password=" + URLEncoder.encode("kaushik123@", "UTF-8");
		data +="&message=" + URLEncoder.encode(msg, "UTF-8");
		data +="&sender=" + URLEncoder.encode("Testid", "UTF-8");
		data +="&mobile=" + URLEncoder.encode(no, "UTF-8");
		data +="&type=" + URLEncoder.encode("3", "UTF-8");
		URL url = new URL("https://login.bulksmsgateway.in/sendmessage.php?"+data);
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		String sResult1="";
		while ((line = rd.readLine()) != null) 
		{
		// Process line...
		sResult1=sResult1+line+" ";
		}
		wr.close();
		rd.close();
		return true;
		} 
		catch (Exception e)
		{
		System.out.println("Error SMS "+e);
		return false;
		}
	} 
}

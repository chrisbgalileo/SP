package com.example.demo3.data;

public class Helper {
public final static String INSTAGRAM_API_KEY = "4df479db94e6494bae670368b19ee792";
public final static String BASE_API_URL = "https://api.instagram.com/v1";

public static String getRecentMediaUrl(String tag)
{
return BASE_API_URL + "/tags/" + tag + "/media/recent?client_id=" + INSTAGRAM_API_KEY;
}

}
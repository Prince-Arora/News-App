package com.example.laptop.newsapp;

/**
 * Created by LAPTOP on 07-06-2017.
 */

public class Custom {
    String SectionName="";
    String WebpblDate="";
    String WebTitle="";
    String WebUrl="";
    public Custom(String a,String b,String c,String d)
    {
        SectionName=a;
        WebpblDate=c;
        WebTitle=b;
        WebUrl=d;
    }
    public String getSectionName()
    {
        return SectionName;
    }
    public String getWebpblDate()
    {
        return  WebpblDate;
    }
    public String getWebTitle()
    {
        return WebTitle;
    }
    public String getWebUrl()
    {
        return WebUrl;
    }


}

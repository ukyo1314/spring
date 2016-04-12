package com.cn.quartz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class QuartzJob
{

    public void work() throws ParseException
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
    	Date data = sdf.parse("20160105010203");
    	System.out.println(data.toString()+"Quartz的任务调度！！！");
    }
}
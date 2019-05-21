package com.centit.jtt2xyb.bo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 简易DateConverter. 供Apache BeanUtils 做转换,默认时间格式为yyyy-MM-dd,可由构造函数改变.
 *
 * @author jijinhui
 * 
 */
public class DateUtils {
	
	private static final Log log = LogFactory.getLog(DateUtils.class);
	
	//默认日期和格式
	private static String datePattern = "yyyy-MM-dd";
	private static String timePattern = " HH:mm:ss";

	private static SimpleDateFormat format = new SimpleDateFormat(datePattern);

	public DateUtils(String formatPattern) {
		if (StringUtils.isNotBlank(formatPattern)) {
			format = new SimpleDateFormat(formatPattern);
		}
	}
	
	public static String getDate(Date date, String pattern) {
		long curDate = 0L;
		if (StringUtils.isNotBlank(pattern)) {
			format = new SimpleDateFormat(pattern);
		}
		
		if (date == null) {
			curDate = System.currentTimeMillis();
		}
		else {
			curDate = date.getTime();
		}
		
		return format.format(new Date(curDate));
	}
	
	public static String getDateTime(Date date, String pattern) {
		long curTimestamp = 0L;
		
		if (StringUtils.isNotBlank(pattern)) {
			format = new SimpleDateFormat(pattern);
		}
		else {
			format = new SimpleDateFormat(datePattern + timePattern);
		}
		
		if (date == null) {
			curTimestamp = System.currentTimeMillis();
		}
		else {
			curTimestamp = date.getTime();
		}
			
		return format.format(new Timestamp(curTimestamp));
	}

	public static Date conv2Date(String date, String pattern) throws ParseException {	
		Date rDate = new Date();
		
		if (StringUtils.isNotBlank(pattern)) {
			format = new SimpleDateFormat(pattern);
		}
		
		if (!StringUtils.isBlank(date)) {
			try {
				rDate = format.parse(date);
			} 
			catch (ParseException exec) {
				throw new ParseException(exec.getMessage(), exec.getErrorOffset());
			}
		}
		return rDate;
	}

	@SuppressWarnings("unchecked")
	public static Object conv2Date(Class clazz, Object value, String pattern) {
		
		if (StringUtils.isNotBlank(pattern)) {
			format = new SimpleDateFormat(pattern);
		}
		
		try {
			if (value instanceof String) {
				if (StringUtils.isBlank((String) value)) {
					return new Date();
				}
				
				Date date = format.parse((String) value);
				
				if (clazz.equals(Timestamp.class)) {
					return new Timestamp(date.getTime());
				}
			}
		}
		catch (Exception exec) {
			exec.printStackTrace();
			throw new ConversionException("转换出现错误");
		}
		
		throw new ConversionException("Could not convert " +
                value.getClass().getName() + " to " +
                clazz.getName());
 	}
	
	@SuppressWarnings("unchecked")
	public static Object conv2Str(Class clazz, Object value) {
		Object object = null;
		
		if (value instanceof Date) {
			if (value instanceof Timestamp) {
				format = new SimpleDateFormat(datePattern + timePattern);
			}
			
			try {
				object = format.parse((String) value);
			}
			catch (Exception exec) {
				exec.printStackTrace();
				throw new ConversionException("日期转换错误");
			}
		}
		else {
			object = (String) value;
		}
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public static Object convert(Class clazz, Object value) {
		
		if (clazz == null || value == null) {
			return new Date();
		}
		
		if (clazz == Timestamp.class) {
			return conv2Date(clazz, value, datePattern + timePattern);
		}
		else if (clazz == Date.class) {
			return conv2Date(clazz, value, datePattern);
		}
		else if (clazz == String.class) {
			return conv2Str(clazz, value);
		}
		
		throw new ConversionException("Could not convert " +
                value.getClass().getName() + " to " +
                clazz.getName());
	}
}

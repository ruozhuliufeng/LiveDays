package cn.aixuxi.livedays.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述 日期转换工具类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/7 22:13
 */
public class DateUtils {
    /**
     * 功能描述: 将日期转为字符串
     * @param date 日期
     * @return : 转为字符串的日期
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:36
     */
    public static String dateToString(Date date){
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dfs.format(date);
    }

    /**
     * 功能描述: 两个日期间的比较
     * @param d1 第一个日期
     * @param d2 第二个日期
     * @return : 两个日期之间的分钟
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:35
     */
    public static String dateCompare(Date d1,Date d2) throws ParseException {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = dateToString(d1);
        String s2 = dateToString(d2);
        Date begin=dfs.parse(s1);
        Date end = dfs.parse(s2);
        long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒 
        long fen= between/60;
        return fen+"分钟";
      }
}

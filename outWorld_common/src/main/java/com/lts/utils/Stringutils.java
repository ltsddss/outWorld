package com.lts.utils;

import com.lts.xss.HTMLFilter;
import com.lts.xss.SQLFilter;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @author 爆炸杰克
 * @create 2022/4/30
 */
public class Stringutils {

    /**
     * 用户名和密码均不可小于6位(大于6位返回true,小于六位返回false)
     * @param str 字符串
     * @return true or false
     */
    public static boolean isEmptyOrLess6(String str){
        return !str.isEmpty() && str.trim().length() >= 6;
    }

    /**
     * 判断字符串是否是数字,字符和特殊符号的组合
     * @param str 字符串
     * @return true or false
     */
    public static boolean isTrue(String str){

        int digit=0;
        int charac=0;
        int teshu=0;

        for(int i=0;i<str.length();i++){
//            判断是否为数字
            char temp=str.charAt(i);
            if(Character.isDigit(temp)){
                digit++;
            }
//            是否为字母
            else if(temp>='a'&&temp<='z'){
                charac++;
            }
//            是特殊符号(不能是中文)
            else {
                teshu++;
            }
        }

        return digit!=0&&charac!=0&&teshu!=0;
    }

    /**
     * 判断用户的输入是否合法
     * @return true/false
     */
    public static boolean legalString(String s){
//        TODO: 之后要具体的做非法字符的替换
        return true;
    }

    /**
     * 判断数字是否合法
     * @param num
     * @return
     */
    public static boolean legalString(Integer num){
//        TODO: 之后要具体的做非法字符的替换

        return true;
    }
}

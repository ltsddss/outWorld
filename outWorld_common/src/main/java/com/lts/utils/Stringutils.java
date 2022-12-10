package com.lts.utils;

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

//    对传来的IP地址进行处理

    public static String solutionIP(String ip){
//        获取第一次出现cip的位置,第一个"出现到第二个"结束切出来
        int temp=0;
        int start=0;
        int end=0;
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='\"'){
                temp++;
                if(temp==3){
                    start=i+1;
                }
                if (temp==4){
                    end=i;
                    break;
                }
            }
        }

        return ip.substring(start,end);
    }

    public static String solutionCity(String city){
//        获取第一次出现cip的位置,第一个"出现到第二个"结束切出来
        int temp=0;
        int start=0;
        int end=0;
        for(int i=0;i<city.length();i++){
            if(city.charAt(i)=='\"'){
                temp++;
                if(temp==11){
                    start=i+1;
                }
                if (temp==12){
                    end=i;
                    break;
                }
            }
        }

        return city.substring(start,end);
    }
}

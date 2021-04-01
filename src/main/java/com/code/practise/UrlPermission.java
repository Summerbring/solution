package com.code.practise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 根据url生成对应的权限编码
 *
 * @author Summer 2020/10/12 9:03
 */
public class UrlPermission {

    public static String buildUrl(String oldUrl){

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < oldUrl.length() - 1; i++) {
            if('/' == oldUrl.charAt(i) && '/' == oldUrl.charAt(i + 1)){
                sb.append("*");
                continue;
            }
            sb.append(oldUrl.charAt(i));
        }

        return sb.toString();
    }

    /**
     *  url请求转驼峰
     *  规则：遇/ | - 转驼峰，{}则直接舍弃
     * @param str
     * @author Summer 2020-09-15 13:13
     * @return java.lang.String
     */
    public static String exChange(String str) {

        str = str.replaceAll("\\d", "");

        str = buildUrl(str);

        Pattern linePattern = Pattern.compile("(/|-)(\\w)");

        str = str.toLowerCase();

        //去除{}包括参数
        String reg = "\\/\\{[^\\}]*\\}";

        str = str.replaceAll(reg, "").replaceAll("\\{","").replaceAll("}","");

        Matcher matcher = linePattern.matcher(str);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {

            matcher.appendReplacement(sb, matcher.group(2).toUpperCase());

        }

        matcher.appendTail(sb);

        return sb.toString();

    }

}

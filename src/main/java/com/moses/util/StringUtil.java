package com.moses.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses on 2016/12/17.
 */
public class StringUtil {
    private final String[] formatsDefault = {"utf-8", "gbk", "gb2312", "iso8859-1"};
    private String[] formats = formatsDefault;

    public static void main(String[] args) throws Exception {
        StringUtil t = new StringUtil();
        String str = "中文";
        str = new String(str.getBytes("utf-8"),"gbk");
//        str =new String(str.getBytes("utf-8"),"gbk");
        List<Object[]> list = t.fixGarbled(str, 1);
        for (Object[] objs : list) {
            System.out.println(objs[0] + " " + objs[1]);
            for (String[] strs : (List<String[]>) objs[2]) {
                System.out.println("from:" + strs[0] + " to:" + strs[1]);
            }
        }
    }

    /**
     * 多次编译修复乱码
     * @param str 需修复字符串
     * @param time 修复次数
     * @return Object[原字符串，编译后字符串，编码顺序]
     * @throws Exception
     */
    public List<Object[]> fixGarbled(String str, int time) throws Exception {
        List<Object[]> list = new ArrayList<Object[]>();
        if (time <= 0) {
            return null;
        }
        for (int i = 0; i < time; i++) {
            if (i == 0) {
                list = fixGarbled(str, null);
            } else {
                List<Object[]> tmp = null;
                for (Object[] objs : list) {
                    if (tmp == null) {
                        tmp = fixGarbled((String) objs[1], (List<String[]>) objs[2]);
                    } else {
                        tmp.addAll(fixGarbled((String) objs[1], (List<String[]>) objs[2]));
                    }
                }
                list = tmp;
            }
        }
        return list;
    }


    /**
     * 单次修复乱码
     * @param str 需修复字符串
     * @param pathList 修复的编码顺序
     * @return Object[原字符串，编译后字符串，编码顺序]
     * @throws Exception
     */
    public List<Object[]> fixGarbled(String str, List<String[]> pathList) throws Exception {
        if (pathList == null) {
            pathList = new ArrayList<String[]>();
        }
        List<Object[]> list = new ArrayList<Object[]>();
        for (String from : formats) {
            for (String to : formats) {
                if (from.equals(to)) {
                    continue;
                }
                String resultStr = new String(str.getBytes(from), to);
                if (resultStr.indexOf("?") < 0) {
                    List<String[]> tmp = new ArrayList<String[]>();
                    tmp.addAll(pathList);
                    tmp.add(new String[]{from, to});
                    list.add(new Object[]{str, resultStr, tmp});
                }
            }
        }
        return list;
    }
}

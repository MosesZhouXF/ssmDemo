package com.moses.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses on 2016/12/17.
 */
public class StringUtil {
    public String[] formats = {"utf-8", "gbk", "gb2312", "iso8859-1"};

    public static void main(String[] args) throws Exception {
        StringUtil t = new StringUtil();
        String str = "涓\uE15F枃";
        List<String[]> list = t.fixGarbled(str);
        for (String[] strs : list) {
            for (String str1 : strs) {
                System.out.print(str1 + " ");
            }
            System.out.println();
        }
    }


    public List<String[]> fixGarbled(String str) throws Exception {
        List<String[]> list = new ArrayList<String[]>();
        for (String from : formats) {
            for (String to : formats) {
                if (from.equals(to)) {
                    continue;
                }
                String resultStr = new String(str.getBytes(from), to);
                if (resultStr.indexOf("?") < 0) {
                    list.add(new String[]{str, resultStr, from, to});
                }
            }
        }
        return list;
    }
}

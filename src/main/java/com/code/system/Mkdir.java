package com.code.system;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * description
 *
 * @author Summer 2021/04/28 8:36
 */
public class Mkdir {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入文件目录: ");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isEmpty(ipt)) {
                ipt = "C:\\";
            }
            File dir = new File(ipt + File.separator + "dou");
            if (!dir.exists()) {// 判断目录是否存在
                dir.mkdir();
            }
            String fileName = "test.txt";
            File test = new File(dir.getPath() + File.separator + fileName);
            test.createNewFile();
        }

    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.webscrapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author User
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String link = "https://soundcloud.com/lifeofdesiigner/desiigner-panda";
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            String[] data = link.split("/");
            FileOutputStream os = new FileOutputStream(data[data.length - 1]);

            InputStream is = conn.getInputStream();
            byte[] byt = new byte[1024];
            int i = 0;
            while ((i = is.read(byt)) != -1) {
                os.write(byt, 0, i);
            }
            is.close();

            System.out.println(link + "file downloaded");
        } catch (IOException ioe) {
            ioe.getMessage();
        }

    }

}

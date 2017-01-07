/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelpackage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author root
 */
public class config {
    public static String MD5(String gelen) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] message = md.digest(gelen.getBytes());
            BigInteger number = new BigInteger(1, message);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public static String SHA1(String gelen){
            try {
                MessageDigest md = MessageDigest.getInstance("SHA1");
                byte[] message = md.digest(gelen.getBytes());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < message.length; i++) {
                    sb.append(Integer.toString((message[i]& 0xff)+0x100,16).substring(1));
                }
                return sb.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
    public String donDate(String s) throws ParseException {
        Date now = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(now);
    }
    public String tersDonDate(String s) throws ParseException {
        Date now = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(now);
    }
}

package com.water.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by dell on 2017/7/16.
 */
public class SignUtil {

    public static boolean validSign(String signature,String token,String timestamp,String nonce){
        String[] strs=new String[]{token,timestamp,nonce};
        Arrays.sort(strs);
        StringBuffer content=new StringBuffer();
        for(int i=0;i<strs.length;i++){
            content.append(strs[i]);
        }
        MessageDigest md=null;
        String tmpStr=null;
        try{
            md=MessageDigest.getInstance("SHA-1");
            byte[] digest=md.digest(content.toString().getBytes());
            tmpStr=new String(digest);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return signature!=null?signature.toUpperCase().equals(tmpStr.toUpperCase()):false;
    }
}

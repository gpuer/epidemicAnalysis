package com.gpu.epidemic.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {
    private static final String CHARSET="UTF-8";


    public static String encoder(String str) throws UnsupportedEncodingException {
        Base64.Encoder encoder=Base64.getEncoder();
       return encoder.encodeToString(str.getBytes(CHARSET));
    }
    public static String decoder(String str) throws UnsupportedEncodingException {
        Base64.Decoder decoder=Base64.getDecoder();
        return new String(decoder.decode(str),CHARSET);
    }
}

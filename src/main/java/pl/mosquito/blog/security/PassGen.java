package pl.mosquito.blog.security;

import java.security.SecureRandom;

public class PassGen {
    private static final int PASSLEN = 10;
    private static final String VALUES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static StringBuilder pass = new StringBuilder(PASSLEN);

    public static String getPass() {
        SecureRandom rnd = new SecureRandom();

        for(int i = 0; i < PASSLEN; i++) {
            pass.append(VALUES.charAt(rnd.nextInt(VALUES.length())));
        }

        return pass.toString();
    }
}

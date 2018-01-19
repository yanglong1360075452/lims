package com.wizinno.lims.common.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 关于验证码的工具类
 * <p>
 * @author LiuMei on 2017-06-12.
 */
public final class CaptchaUtil {

    private CaptchaUtil() {
    }

    /**
     * 随机字符字典
     */
    private static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
            'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 随机数
     */
    private static Random random = new Random();

    /**
     * 获取随机数
     * @param digit 随机数位数
     * @return
     */
    private static String getRandomString(int digit) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < digit; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 获取随机数颜色
     */
    private static Color getRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255),
                random.nextInt(255));
    }

    /**
     * 返回某颜色的反色
     */
    private static Color getReverseColor(Color c) {
        return new Color(255 - c.getRed(), 255 - c.getGreen(),
                255 - c.getBlue());
    }

    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg");

        String randomString = getRandomString(6);
        request.getSession(true).setAttribute("captcha", randomString);

        int width = 100;
        int height = 30;
        int randomInt = 100;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
        for (int i = 0, n = random.nextInt(randomInt); i < n; i++) {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "png", out);
        out.flush();
    }

}

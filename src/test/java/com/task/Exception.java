package com.task;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.basepackage.BaseClass;

public class Exception extends BaseClass{
public static void main(String[] args)  {
	
	
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    BufferedImage fullimage = ImageIO.read(src);

    double v = fullimage.getWidth() * 0.80;
    int width =(int)v;
    int height = fullimage.getHeight();
    BufferedImage croppedimage = fullimage.getSubimage(0, 0, dimension.width, dimension.height);
    File des = new File("C:\\Users\\Screenshot\\A3.png");
    ImageIO.write(croppedimage, "png", des);
}
}

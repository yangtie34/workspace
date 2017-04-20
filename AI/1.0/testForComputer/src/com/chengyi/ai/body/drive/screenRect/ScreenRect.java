package com.chengyi.ai.body.drive.screenRect;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.chengyi.ai.body.canDo.Focus;
import com.chengyi.ai.body.drive.MyRobot;
import com.chengyi.ai.core.interfaces.DataListener;

public class ScreenRect {
	private static DataListener<Integer> dataListner;

	public static void setDataListner(DataListener<Integer> dataListner) {
		ScreenRect.dataListner = dataListner;
	}
	static  Dimension d;
	static{
		//获取屏幕分辨率
        d = Toolkit.getDefaultToolkit().getScreenSize();
	}
	/**
	 * 获取屏幕截图
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static byte[] getScreen() throws IOException{
		//获取屏幕分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(d);
        //截图
        BufferedImage bufferedImage =       MyRobot.robot.createScreenCapture(screenRect);
		 ByteArrayOutputStream out = new ByteArrayOutputStream();  
         ImageIO.write(bufferedImage, "png", out);  
         byte[] b = out.toByteArray();
         out.close();  
         return b;
	}
	/**
	 * 获取像素点int
	 * @param position
	 * @return
	 */
	private static int getRGBByPostition(int position){
		int y=position/d.width;
		int x=position%d.width;
		if(y>d.height)y=d.height;
		Color color =MyRobot.robot.getPixelColor(x, y);
		int color_int=color.getRGB();
		return color_int;
	}
	public synchronized static void init() {
		MyRobot.print("获取屏幕中。。。。");
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}// 睡1 
			dataListner.hasChange(getRGBByPostition(Focus.postion));
		}
	}
}

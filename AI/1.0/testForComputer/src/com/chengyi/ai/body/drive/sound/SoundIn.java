package com.chengyi.ai.body.drive.sound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.chengyi.ai.body.drive.MyRobot;
import com.chengyi.ai.core.interfaces.DataListener;
import com.chengyi.ai.util.TypeConvert;

/**
 * 耳朵
 */
public class SoundIn {
	private static DataListener<Integer> dataListner;

	public static void setDataListner(DataListener<Integer> dataListner) {
		SoundIn.dataListner = dataListner;
	}
	protected static void forOut(int i) {
		if(dataListner!=null){
			dataListner.hasChange(i);
		}
	}
	// 定义存放录音的字节数组长度
	private static int byteLength = 4;

	private static void record() {
		// -------------开启录音
		// 定义目标数据行,可以从中读取音频数据,该 TargetDataLine 接口提供从目标数据行的缓冲区读取所捕获数据的方法。
		TargetDataLine td = null;
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, SoundUtil.af);
		try {
			td = (TargetDataLine) (AudioSystem.getLine(info));
			// 打开具有指定格式的行，这样可使行获得所有所需的系统资源并变得可操作。
			td.open(SoundUtil.af);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		// 允许某一数据行执行数据 I/O
		td.start();
		// -------------开启录音成功
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}// 睡1 
			// 定义存放录音的字节数组,作为缓冲区
			byte bts[] = new byte[byteLength];
			// 从数据行的输入缓冲区读取音频数据。
			// 要读取bts.length长度的字节,cnt 是实际读取的字节数
			int cnt = td.read(bts, 0, bts.length);
			if (cnt > 0) {
				dataListner.hasChange(TypeConvert.bytesToInt(bts));
			}
		}
	}

	public static void init() {
		MyRobot.print("获取声音中。。。。");
		record();
	}
}

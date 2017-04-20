package com.chengyi.ai.body.drive.sound;

import java.io.ByteArrayInputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import com.chengyi.ai.util.TypeConvert;


/**
 * 嗓子
 */
public class SoundOut {
	//定义源数据行,源数据行是可以写入数据的数据行。它充当其混频器的源。应用程序将音频字节写入源数据行，这样可处理字节缓冲并将它们传递给混频器。
	private static SourceDataLine sd = null;
	//定义存放录音的字节数组长度
		private static int byteLength=4;
		//定义音频输入流
		private static AudioInputStream ais = null;
		//定义字节数组输入输出流
		private static ByteArrayInputStream bais = null;
		static {
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, SoundUtil.af);
            try {
            	  sd = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
				sd.open(SoundUtil.af);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
            sd.start();
		}
		public static void play(int i) {
			play(TypeConvert.intToBytes(i));
			SoundIn.forOut(i);
		}
		private static void play(byte audioData[]) {
			//转换为输入流
			bais = new ByteArrayInputStream(audioData);
			//定义录音格式
			AudioFormat af = SoundUtil.af;
			ais = new AudioInputStream(bais, af, audioData.length/af.getFrameSize());
			byte bts[] = new byte[byteLength];
			try {
				int cnt;
	            //读取数据到缓存数据
	            while ((cnt = ais.read(bts, 0, bts.length)) != -1){
	                if (cnt > 0) {
	                    //写入缓存数据
	                    //将音频数据写入到混频器
	                    sd.write(bts, 0, cnt);
	                }
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					//关闭流
					if(ais != null)
					{
						ais.close();
					}
					if(bais != null)
					{
						bais.close();
					}
				} catch (Exception e) {		
					e.printStackTrace();
				}
			}
		}
		
}

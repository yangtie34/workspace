package com.chengyi.ai.body.perception;

import com.chengyi.ai.body.drive.sound.SoundIn;
import com.chengyi.ai.core.interfaces.DataListener;
import com.chengyi.ai.core.interfaces.Get;

/**
 * 声觉
 * @author Administrator
 *
 */
public class Acoustic implements Get{

	@Override
	public void setDataListener(DataListener<Integer> dataListner) {
		SoundIn.setDataListner(dataListner);
		new Thread(new Runnable() {
			@Override
			public void run() {
				SoundIn.init();
			}
		}).start();
	}

	@Override
	public int getId() {
		return 201;
	}
	
}

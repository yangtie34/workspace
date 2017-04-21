package com.chengyi.ai.body.perception;

import com.chengyi.ai.body.drive.screenRect.ScreenRect;
import com.chengyi.ai.core.interfaces.DataListener;
import com.chengyi.ai.core.interfaces.Get;

/**
 * 视觉
 * @author Administrator
 *
 */
public class Vision implements Get{

	@Override
	public void setDataListener(DataListener<Integer> dataListner) {
		ScreenRect.setDataListner(dataListner);
		new Thread(new Runnable() {
			@Override
			public void run() {
				ScreenRect.init();
			}
		}).start();
	}
	@Override
	public int getId() {
		return 202;
	}
}

package com.chengyi.ai.drive.keyboard;

import java.awt.event.KeyEvent;

import com.chengyi.ai.drive.MyRobot;

public class KeyBoardEvent {
	private static int[] keyList=null;
	 /**
     * 按下触发
     */
    public static void mousePress(int i) {
    	MyRobot.print("键盘按下——"+i);
    	int key=getKey(i);
    	if(key==-1)return;
    	MyRobot.robot.keyPress(key);
	}
    /**
     * 释放触发
     */
    public static void mouseRelease(int i) {
    	MyRobot.print("键盘释放——"+i);
    	int key=getKey(i);
    	if(key==-1)return;
    	MyRobot.robot.keyRelease(key);
   	}
    private static int getKey(int i){
    	if(i<0||i>=keyList.length){
    		return -1;
    	}else{
    		return keyList[i];
    	}
    }
    static {
    	keyList=new int[]{
    			KeyEvent.VK_HOME      ,//   Home键                    
    			KeyEvent.VK_END       ,//     End键                                         
    			KeyEvent.VK_PAGE_UP      ,//    page up键                                      
    			KeyEvent.VK_PAGE_DOWN      ,//    page down键                                    
    			KeyEvent.VK_UP        ,//      上箭头                                       
    			KeyEvent.VK_DOWN      ,//   下箭头                                          
    			KeyEvent.VK_LEFT      ,//     左箭头                                        
    			KeyEvent.VK_RIGHT     ,//     右箭头                                        
    			KeyEvent.VK_ESCAPE    ,//   Esc键                                           
    			KeyEvent.VK_TAB       ,//      Tab键                                        
    			KeyEvent.VK_CONTROL   ,//               控制键                              
    			KeyEvent.VK_SHIFT     ,//                  shift键                          
    			KeyEvent.VK_BACK_SPACE,//             退格键                                
    			KeyEvent.VK_CAPS_LOCK ,//             大小写锁定键                          
    			KeyEvent.VK_NUM_LOCK  ,//              小键盘锁定键                         
    			KeyEvent.VK_ENTER     ,//                 回车键                            
    			KeyEvent.VK_UNDEFINED ,//               未知键     
    			KeyEvent.VK_F1		  ,//F1 -- F12
    			KeyEvent.VK_F2        ,//
    			KeyEvent.VK_F3        ,//
    			KeyEvent.VK_F4        ,//
    			KeyEvent.VK_F5        ,//
    			KeyEvent.VK_F6        ,//
    			KeyEvent.VK_F7        ,//
    			KeyEvent.VK_F8        ,//
    			KeyEvent.VK_F9        ,//
    			KeyEvent.VK_F10       ,//
    			KeyEvent.VK_F11       ,//
    			KeyEvent.VK_F12       ,//
    			KeyEvent.VK_0		  ,//0 --- 9    
    			KeyEvent.VK_1         ,//
    			KeyEvent.VK_2         ,//
    			KeyEvent.VK_3         ,//
    			KeyEvent.VK_4         ,//
    			KeyEvent.VK_5         ,//
    			KeyEvent.VK_6         ,//
    			KeyEvent.VK_7         ,//
    			KeyEvent.VK_8         ,//
    			KeyEvent.VK_9         ,//        
    			KeyEvent.VK_A 		  ,//	A----Z
    			KeyEvent.VK_B         ,//
    			KeyEvent.VK_C         ,//
    			KeyEvent.VK_D         ,//
    			KeyEvent.VK_E         ,//
    			KeyEvent.VK_F         ,//
    			KeyEvent.VK_G         ,//
    			KeyEvent.VK_H         ,//
    			KeyEvent.VK_I         ,//
    			KeyEvent.VK_J         ,//
    			KeyEvent.VK_K         ,//
    			KeyEvent.VK_L         ,//
    			KeyEvent.VK_M         ,//
    			KeyEvent.VK_N         ,//
    			KeyEvent.VK_O         ,//
    			KeyEvent.VK_P         ,//
    			KeyEvent.VK_Q         ,//
    			KeyEvent.VK_R         ,//
    			KeyEvent.VK_S         ,//
    			KeyEvent.VK_T         ,//
    			KeyEvent.VK_U         ,//
    			KeyEvent.VK_V         ,//
    			KeyEvent.VK_W         ,//
    			KeyEvent.VK_X         ,//
    			KeyEvent.VK_Y         ,//
    			KeyEvent.VK_Z         ,//
    	};
    }
}

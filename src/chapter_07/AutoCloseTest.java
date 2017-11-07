package chapter_07;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoCloseTest {
	private static final Logger myLogger = Logger.getLogger("com.myLogger.myapp");
	
	public static void main(String[] args) throws SecurityException, IOException {
		
//		if(System.getProperty("java.util.logging.config.class") == null
//				&& System.getProperty("java.util.logging.config.file") == null){
//			try{
//				Logger.getLogger("").setLevel(Level.ALL);
//				final int LOG_ROTATION_COUNT = 10;
//				Handler handler = new FileHandler("%h/myapp.log", 0, LOG_ROTATION_COUNT);
//				Logger.getLogger("").addHandler(handler);
//			}catch(IOException e){
//				myLogger.log(Level.SEVERE, "Can't create log file handler", e);
//			}
//		}
		
		String message = "my message: ";
		
		myLogger.setLevel(Level.FINE);
		myLogger.setUseParentHandlers(false);
		//安装设置自己的处理器
		String path = "E:/Test/Java/CoreJavaVolume1/src/chapter_07/java%myapp.log";
		final int LOG_ROTATION_COUNT = 5;
		FileHandler handler = new FileHandler(path, 0, LOG_ROTATION_COUNT);
		
		handler.setLevel(Level.FINE);
		myLogger.addHandler(handler);
		
		myLogger.log(Level.INFO, "info:");
		myLogger.fine("fine: " + myLogger.getName());
		
		String s = Integer.toString(99);
		System.out.println(s);
	}

}

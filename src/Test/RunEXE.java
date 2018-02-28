package Test;

public class RunEXE {
	public static void runexe(String exeurl) {
		  final Runtime runtime = Runtime.getRuntime();  
		    Process process = null;  
		  
		    try {  
		        process = runtime.exec(exeurl); 
		        System.out.println("scsseful exec!");  
		        Thread.sleep(20000);
		    } catch (final Exception e) {  
		        System.out.println("Error exec!");  
		    }  
	}
}

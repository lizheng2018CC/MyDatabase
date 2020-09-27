package database2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess implements Runnable {

	private Socket socket;
	private String tempString; 
	public BufferedReader reader;
	public PrintWriter writer;
	
	public ClientProcess(Socket socket) throws IOException {
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(socket.getOutputStream(), true);
		this.socket = socket;
	}

	public void run() {
		try {
			//为每一个socket建立读写通道
			
			writer.println("********** Welcome to HnuDB **********");
			writer.println();
			writer.flush();

			while(true) {
				tempString = reader.readLine();  //如果客户端断开链接，则返回null
				if(tempString == null) {//ClientProcess.isServerClose(socket) 只能发送17次
					socket.close();
					break;
				}
				if(tempString.equals("logout")) break;
				ClientManage.ReturnMessage().add(tempString);
				//writer.println("the repeat of Server: " + tempString);	
				//writer.flush();
				
			}
			System.out.println("bye!");
			
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				
			}
		}
	}
	
	
	public static Boolean isServerClose(Socket socket){ 
		   try{ 
		    socket.sendUrgentData(0xFF);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信 
		    return false; 
		   }catch(Exception se){ 
		    return true; 
		   } 
		} 
}

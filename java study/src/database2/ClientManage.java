package database2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Vector;

public class ClientManage implements Runnable {
	private static Vector<Socket> vSocket = new Vector<Socket>();
	private static Vector<String> vMessage = new Vector<String>(); // 类型安全：该方法添加（对象）属于原始类型向量。对泛型类型向量的引用要进行参数化
//	private static Vector<ClientProcess> vClitProcess = new Vector<ClientProcess>();
	private static Vector<PrintWriter> vPrintWriters = new Vector<PrintWriter>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	///private String messageString;
	private int socksize;
	private int NewSockets;

	public void run() {
		try {
				while (true) {
					if(br.ready()) {
						vMessage.add(br.readLine());	
					}
				Thread.sleep(200);
				NewSockets = vSocket.size() - socksize;
				if(0 == NewSockets){
					;
				}else if(NewSockets > 0) {
					for(int i=0 ; i<NewSockets ; i++) {
						System.out.println(vSocket.get(socksize+i).toString() + "login!");
						vPrintWriters.add(new PrintWriter(vSocket.get(socksize+i).getOutputStream(), true));
						vPrintWriters.get(socksize+i).println("********** Welcome to HnuDB **********");
						vPrintWriters.get(socksize+i).flush();
					}
				}else if(NewSockets < 0) {
					
				}
				socksize = vSocket.size();
				
				for (int j = 0; j < socksize; j++) {
					for (int i = 0; i < vMessage.size(); i++) {
					//	vClitProcess.get(j).writer.println(vMessage.get(i));
						vPrintWriters.get(j).println(vMessage.get(i));
						vPrintWriters.get(j).flush();
						if(j == 0)
							System.out.println(vMessage.get(i));
					}
					
				}
				vMessage.clear();
				//System.out.println("socksize数是：" + socksize);

			}

		} catch (InterruptedException e1) { 
				  
		} catch (IOException e2) { 
				    
			  }
			 

	}
	
	public static Vector<String> ReturnMessage() {
		return vMessage;
	}
	public void AddSock(Socket s) {
		vSocket.add(s);
	}

	/*
	 * public void AddClitProcess(ClientProcess c) { vClitProcess.add(c); }
	 */

	public void AddMessage(String s) {
		vMessage.add(s);
	}
	public static void NoteMeBye(Socket s) {
		System.out.println(s.toString() + "quit!");
		int n = vSocket.indexOf(s);
		vPrintWriters.get(n).close();
		vPrintWriters.remove(n);
		vSocket.remove(s);
	}
	public static void NoteMeLogin() {
		
	}

}

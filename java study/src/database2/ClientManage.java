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
	private static Vector<ClientProcess> vClitProcess = new Vector<ClientProcess>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	///private String messageString;
	private int socksize;

	public void run() {
		try {
				while (true) {
					if(br.ready()) {
						vMessage.add(br.readLine());	
					}
				Thread.sleep(200);
				socksize = vSocket.size();
				for (int j = 0; j < socksize; j++) {
					for (int i = 0; i < vMessage.size(); i++) {
						vClitProcess.get(j).writer.println(vMessage.get(i));
						if(j == 0)
						System.out.println(vMessage.get(i));
					}
					
				}
				vMessage.clear();
				//System.out.println("socksize数是：" + socksize);

			}

		} catch (InterruptedException e1) { 
				  // TODO: handle exception 
		} catch (IOException e2) { 
				  // TODO: handle exception  
			  }
			 

	}
	
	public static Vector<String> ReturnMessage() {
		return vMessage;
	}
	public void AddSock(Socket s) {
		vSocket.add(s);
	}

	public void AddClitProcess(ClientProcess c) {
		vClitProcess.add(c);
	}

	public void AddMessage(String s) {
		vMessage.add(s);
	}

}

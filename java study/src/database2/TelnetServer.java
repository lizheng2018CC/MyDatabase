package database2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;



public class TelnetServer {

	 private ServerSocket server = null;
	 //_start
	 
	 private final ExecutorService executor = 
			 Executors.newFixedThreadPool(100);
	 //_end
	
	 private int GIVEN_PORT=2223;//端口号
	 
	 private ClientProcess CP = null; 
	 private ClientManage CM = new ClientManage();

	 public void telnetServer(String port) {
	    GIVEN_PORT = port != null ? 
	        		Integer.valueOf(port).intValue() : 0;
	    }

	 
	 
	 /*
	  * 启动服务器
	  */
	 public void run() {

	        try {
	            // 在指定端口号建立连接
	            server = new ServerSocket(GIVEN_PORT );
	            System.out.println("Server running and listening on port : "
	                    + GIVEN_PORT );
	            
	            executor.execute(CM);
	            
	            while (true) {
	            	 //开始侦听
	                Socket s = server.accept();
	                //有客户端连接进入后，即启动一个线程，并将socket作为一个参数来传入
	                CP = new ClientProcess(s);
	                executor.execute(CP);
	                //保存客户端连接
	                CM.AddSock(s);
	               // CM.AddClitProcess(CP);
	                
	            }

	        } catch (IOException e) {
	        	System.out.println(Level.WARNING+ e.toString()+" Shutting down the server..");
	        } finally {
	            executor.shutdown();
	        }

	    }

	    /**
	     * Checks if the server is running.
	     *
	     * @return
	     */
	    public boolean isRunning() {
	        return !server.isClosed();
	    }

	    /**
	     * 关闭所有连接
	     *
	     * @throws IOException
	     */
	    public void shutDown() throws IOException {
	        if (server != null) {
	            server.close();
	        }

	    }
}

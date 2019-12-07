package mvc.commons.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Hashtable;


public class Forwarder {
    private final Map<String,Service> services = new Hashtable();
    
    public void send(String serviceName, String message){
        try{
			Service service = getService(serviceName);
			Socket socket = new Socket(service.getIP(),service.getPortName());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(message);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
	
	public void addService(String name, Service service){
		services.put(name,service);
		
	}
	public Service getService(String name){
		return services.get(name);
	}
}

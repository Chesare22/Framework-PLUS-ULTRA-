package mvc.commons.sockets;

public class Service{
	
	private String IP;
	private int portName;
	
	public Service(String ip, int port){
		this.IP=ip;
		this.portName=port;
		
	}
	public String getIP( ){
		return IP;
	}
	public int getPortName( ){
		return portName;
	}
	
	
	
	
}
package mvc.commons.sockets;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Receiver {
	private final ServerSocket server;

	public Receiver(int port, int backlog) {
		ServerSocket server1;
		try {
			server1 = new ServerSocket(port, backlog);
		} catch (IOException e) {
			System.out.println("No se pudo establecer la conexion");
			System.exit(0);
			server1 = null;
		}
		server = server1;
	}

	public String getMessage()throws IOException{
		try {
			try (Socket socketConnection = server.accept()) {
				Scanner inputStream = new Scanner(socketConnection.getInputStream());
				return inputStream.nextLine();
			}
		} catch (EOFException eof) {
			System.out.println("Error");
		}
		return "";
	}
}

package labServerUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.google.gson.Gson;

public class UDPConexion extends Thread{
	private Observer observer;
	private DatagramSocket socket;
	
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
	@Override
	public void run() {
		try {
		socket = new DatagramSocket(5000);
	
		while(true) {
			byte[] buffer = new byte[500];
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
			System.out.println("Esperando datagrama");
			socket.receive(packet);
			String message = new String(packet.getData()).trim();
			System.out.println("Datagrama recibido"+message);
			observer.mensajeRecibido(message);
			
		}
		
		
		
		
		}catch(SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

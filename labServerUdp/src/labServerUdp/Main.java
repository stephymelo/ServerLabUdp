package labServerUdp;

import java.io.StringReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet implements Observer{
	
	private UDPConexion udp;
	private int posY;
	private int posXImg,posYImg,tamX,tamY;
	private ArrayList<Orden> ordenArrayL;
	private Orden ordens;
	private int index;
	private int pedidoNumero;
	PImage hamburgerImg;
	PImage friesImg;
	PImage juiceImg;
	 
	

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(500, 500);
		
	}
	
	public void setup() {
		
		ordenArrayL=new ArrayList<Orden>();
		posY=50;
		posXImg=300;
		posYImg=50;
		tamX=30;
		tamY=30;
		hamburgerImg=loadImage("./hamburger.jpg");
		juiceImg=loadImage("./juice.jpg");
		friesImg=loadImage("./fries.jpg");
		udp = new UDPConexion();
		udp.setObserver(this);
		udp.start();

	}
	
	public void draw() {
		background(255);
		
		for(int i=0;i<ordenArrayL.size();i++) {
			fill(0);
			if(ordenArrayL.get(i).getItem()=="Hamburger") {
				image(hamburgerImg,posXImg,(posYImg*i)+50,tamX,tamY);
			}
			if(ordenArrayL.get(i).getItem()=="Fries") {
				image(friesImg,posXImg,(posYImg*i)+50,tamX,tamY);
			}
			
			if(ordenArrayL.get(i).getItem()=="Jugo") {
				image(juiceImg,posXImg,(posYImg*i)+50,tamX,tamY);
			}
			
			
			textSize(14);
			text(ordenArrayL.get(i).getItem(),10,(posY*i)+50);
			textSize(8);
			text("Pedido# "+ordenArrayL.get(i).getPedido(),200,(posY*i)+50);
			text(ordenArrayL.get(i).getFechaOrden(),100,(posY*i)+50);
			
		}
		
		
	}
	
	
	public void mouseClicked() {
		if(dist(mouseX,tamX,mouseY,tamY)<100) {
			
			
		}
		
		for(int i=0;i<ordenArrayL.size();i++) {
			pedidoNumero=ordenArrayL.get(i).getPedido();
			
			ordenArrayL.remove(index);
		}
		
	}
	

	@Override
	public void mensajeRecibido(String message) {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
//		Orden ordenes = gson.fromJson(message,Orden.class);
		Orden []ordenes = gson.fromJson(message,Orden[].class);
//		ordenArrayL.add(new Orden(ordenes.getItem(),ordenes.getPedido(),ordenes.getFechaOrden()));
		for(int i=0;i<ordenes.length;i++) {
			ordens= ordenes[i];
			
		}
		if(ordens!=null) {
			ordenArrayL.add(new Orden(ordens.getItem(),ordens.getPedido(),ordens.getFechaOrden()));
			}
		
	}
	
	
}


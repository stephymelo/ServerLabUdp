package labServerUdp;

public class Orden {
    private String item;
    private int pedido;
    private String fechaOrden;
    public Orden(String item,int pedido,String fechaOrden){
        this.item=item;
        this.pedido=pedido;
        this.fechaOrden=fechaOrden;

    }
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}


}

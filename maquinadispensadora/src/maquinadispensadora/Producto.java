package maquinadispensadora;

import javax.swing.*;

public class Producto {

	private int codigo;
	private String nombreproducto;
	private int cantidaddeproducto;
	private double costoproducto;
	
	public Producto() {
		codigo=0;
		nombreproducto="";
		cantidaddeproducto=0;
		costoproducto=0;
	}
	
	public Producto(int code,String name,int quantity,double cost ) {
		this.codigo=code;
		this.nombreproducto=name;
		this.cantidaddeproducto=quantity;
		this.costoproducto=cost;
	}
	
	
	public void mostrardatos() {
		
		
		JOptionPane.showMessageDialog(null, "PRODUCTOS DISPONIBLES \n"+codigo+"\n"+nombreproducto+"\n"+cantidaddeproducto+"\n"+costoproducto);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public int getCantidaddeproducto() {
		return cantidaddeproducto;
	}

	public void setCantidaddeproducto(int cantidaddeproducto) {
		this.cantidaddeproducto = cantidaddeproducto;
	}

	public double getCostoproducto() {
		return costoproducto;
	}

	public void setCostoproducto(double costoproducto) {
		this.costoproducto = costoproducto;
	}

	public void setAplicariva(double costo) {
		
		this.costoproducto=costoproducto+costo;
	}
	public void setSecomproproducto() {
		this.cantidaddeproducto=cantidaddeproducto-1;
	}


	
	
	
}

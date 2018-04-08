package maquinadispensadora;

import javax.swing.*;

public class Factura {
	
	private String nombreproducto;
	private double descuento;
	private double costoproducto;
	private static final double ivaproducto=21;
	private static final double estudiante=5;
	private static final double administrativo=10;
	private double iva;
	private double total,total2;
	private int tipodeuser;

	public Factura() {
		nombreproducto="";
		descuento=0;
		total=0;
		iva=0;

	}
	
	public void facturausuario(Producto listadeproductos[],int producto) {
		this.nombreproducto=listadeproductos[producto].getNombreproducto();
		this.iva=((ivaproducto/100)*listadeproductos[producto].getCostoproducto());
		this.total=listadeproductos[producto].getCostoproducto();
		this.costoproducto=total-iva;
	}
	


	
	public void facturalista(int tipodeusuario3) {
		this.tipodeuser=tipodeusuario3;
		if(tipodeuser==1) {
			this.descuento=((estudiante*total)/100);
			total2=total-descuento;
			JOptionPane.showMessageDialog(null, "FACTURA \nNOMBRE PRODUCTO: "+nombreproducto+"\nCOSTO DEL PRODUCTO: "+costoproducto+"\nDESCUENTO TIPO DE USUARIO: ESTUDIANTE 5%" +descuento+"\nIVA:"+iva+"\nTOTAL: "+total2);
		}else if(tipodeuser==2) {
			this.descuento=((administrativo*total)/100);
			total2=total-descuento;
			JOptionPane.showMessageDialog(null, "FACTURA \nNOMBRE PRODUCTO: "+nombreproducto+"\nCOSTO DEL PRODUCTO: "+costoproducto+"\nDESCUENTO TIPO DE USUARIO: ADMINISTRATIVO 10%" +descuento+"\nIVA:"+iva+"\nTOTAL: "+total2);
		}else {
			this.descuento=0;
			total2=total-descuento;
			JOptionPane.showMessageDialog(null, "FACTURA \nNOMBRE PRODUCTO: "+nombreproducto+"\nCOSTO DEL PRODUCTO: "+costoproducto+"\nDESCUENTO TIPO DE USUARIO: NADA" +descuento+"\nIVA:"+iva+"\nTOTAL: "+total2);

		}
	}

	
}

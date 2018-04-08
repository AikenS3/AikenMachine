package maquinadispensadora;

import javax.swing.*;

public class Usuario {
	/*
	 * 1 estudiante
	 * 2 administrativo
	 */
	
	private int codigo;
	private double identificacion;
	private String nombre;
	private double dinerosdisponible;
	private String usurio;
	private int contrase�ausuario;
	private int tipodeusuario;
	
	Librocontable tipodeuser=new Librocontable();
	
	
	public Usuario() {
		codigo=0;
		identificacion=0;
		nombre="";
		dinerosdisponible=0;
		usurio="";
		contrase�ausuario=0;
		tipodeusuario=0;
	}
	
	public Usuario(int code,double iduser,String nameuser,double moneyuser,String user,int passworduser) {
		this.codigo=code;
		this.identificacion=iduser;
		this.nombre=nameuser;
		this.dinerosdisponible=moneyuser;
		this.usurio=user;
		this.contrase�ausuario=passworduser;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void informacionusuario() {
		
		JOptionPane.showMessageDialog(null,codigo+"\n"+identificacion+"\n"+nombre+"\n"+dinerosdisponible+"\n"+usurio+"\n"+contrase�ausuario+"\n"+tipodeusuario );
	}

	public double getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(double identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDinerosdisponible() {
		return dinerosdisponible;
	}

	public void setDinerosdisponible(double dinerosdisponible) {
		this.dinerosdisponible = dinerosdisponible;
	}

	public String getUsurio() {
		return usurio;
	}

	public void setUsurio(String usurio) {
		this.usurio = usurio;
	}

	public int getContrase�ausuario() {
		return contrase�ausuario;
	}

	public void setontrase�ausuario(int contrase�ausuario) {
		this.contrase�ausuario = contrase�ausuario;
	}
	
	public int getTipodeusuario() {
		return tipodeusuario;
	}

	public void setTipodeusuario(int tipodeusuario) {
		this.tipodeusuario = tipodeusuario;
	}
	
	
	
	public void setDepositardinero(double deposdinero) {
	
		this.dinerosdisponible=dinerosdisponible+deposdinero;
	
	}
	
	
	public void setTranferirdinero(double deposdinero1) {
		
		this.dinerosdisponible=dinerosdisponible-deposdinero1;
	}
	
	
	public void setComprarproduto(double costoproducto,int tipousuario) {
		
		tipodeuser.aplicardescuento(costoproducto,tipousuario);
		
		this.dinerosdisponible=((dinerosdisponible-costoproducto)+tipodeuser.Total());
	}
	
	
	public void setCambiarcontrase�a(int nuevacontrase�a) {
		this.contrase�ausuario=nuevacontrase�a;
	}

	




	




	

}

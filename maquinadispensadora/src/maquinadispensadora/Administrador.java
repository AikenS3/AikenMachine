package maquinadispensadora;

import javax.swing.JOptionPane;

public class Administrador {
	
	private String usuarioadmin;
	private int contraseñaadmin;
	private int contadmin=0,contproductos=0,aux2=0,codigousuario=0,tipodeusuario=0,opc=0,aux=0;
	int aux1=0;
	Librocontable contabilidad=new Librocontable();
	
	
	public Administrador() {
		usuarioadmin="soyadmin";
		contraseñaadmin=2421;
	}
	
	public void administrador(String usuario,int contraseña,Producto listadeproductos[],Usuario listadeusuarios[],int contuser2,Librocontable listacontabilidad[],int contcontablidad) {
		
		if(usuario.equals(usuarioadmin) &&	contraseña==contraseñaadmin) {
			aux2=1;
			do {	
				contadmin=Integer.parseInt(JOptionPane.showInputDialog( "HOLA, BIENVENIDO ADMIN \n1.ADMINISTRAR PRODUCTOS \n2.VER PRODUCTOS \n3.VER USUARIOS \n4.AGREGAR TIPO DE USUARIO \n5.VER LIBRO CONTABLE \n6.SALIR"));
				switch(contadmin) {
				case 1:
					contproductos=Integer.parseInt(JOptionPane.showInputDialog ("HOLA ADMIN CUANTOS PRODUCTOS DESEA INGRESAR"));
					for(int i=0;i<contproductos;i++) {
						int codigo=Integer.parseInt(JOptionPane.showInputDialog("ESCRIBA EL CODIGO DEL PRODUCTO"));
						String nombreproducto=JOptionPane.showInputDialog("ESCRIBA EL NOMBRE DEL PRODUCTO");
						int cantidaddeproducto=Integer.parseInt(JOptionPane.showInputDialog("DIGITE LA CANTIDAD DE QUE HAY DE: "+nombreproducto));
						double costoproducto=Double.parseDouble(JOptionPane.showInputDialog("DIGITE EL PRECIO DEL PRODUCTO"));
						
						listadeproductos[i]=new Producto(codigo,nombreproducto,cantidaddeproducto,costoproducto);
					
						contabilidad.aplicarivaproductos(listadeproductos,i);
						
					}
					break;
				case 2:
					for(int j=0;j<contproductos;j++) {
						listadeproductos[j].mostrardatos();
					}
					aux1=contproductos;
					
					break;
				case 3:
					for(int i=0;i<contuser2;i++) {
						listadeusuarios[i].informacionusuario();
					}
					
					break;
				case 4:
					codigousuario=Integer.parseInt(JOptionPane.showInputDialog("DIGITE CODIGO DEL USUARIO POR FAVOR"));
					for(int k=0;k<contuser2;k++) {
						if(codigousuario==listadeusuarios[k].getCodigo()) {
							do {
								tipodeusuario=Integer.parseInt(JOptionPane.showInputDialog("USUARIO ENCONTRADO \n HAORA MARQUE QUE TIPO DE USUARIO ES: \n1. ESTUDIANTE \n2.ADMINISTRADOR"));
							
								if(tipodeusuario==1 || tipodeusuario==2) {
									listadeusuarios[k].setTipodeusuario(tipodeusuario);
									opc=0;
								}else {
									JOptionPane.showMessageDialog(null, "LO SIENTO ESA OPCION ES INCORRECTA");
									opc=1;
								}
							}while(opc==1);
						}else {
							if(aux==contuser2) {
								JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO");
							}
							aux=aux+1;
						}
					}

					break;
				case 5:
					for(int j=0;j<contcontablidad;j++) {
						JOptionPane.showMessageDialog(null, "NOMBRE DEL CLIENTE:"+listacontabilidad[j].getNombre()+"\nNOMBRE DE USUARIO:"+listacontabilidad[j].getUsuario()+"\nNOMBRE DEL PRODUCTO:"+listacontabilidad[j].getNombrepro()+"\nCOSTO PRODUCTO:"+listacontabilidad[j].getCostoproducto());
						
					}
					
					break;
				case 6:
					contadmin=6;
					JOptionPane.showMessageDialog(null, "HASTA LUEGO");
					
					break;
				default: 
					JOptionPane.showMessageDialog(null, "ADMIN OPCION EQUIVOCADA");
					contadmin=1;
					
					break;
					}
			}while(contadmin!=6);
		}else {
			aux2=2;
		}
	

	}
	
	public int auxiliar() {
		return aux2;
	}
	
	public int cuantoproductoshay() {
		return contproductos;
	}

	

}

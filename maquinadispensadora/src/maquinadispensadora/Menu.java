package maquinadispensadora;

import javax.swing.*;

public class Menu {
	private int op=0, contraseña=0,op2=0,aux=0,opccompraproducto=0,contuser=0,contuser2=0,codigousuario=0,band=1,aux2=1,contcontabilidad=0;
	private double cuantollevausuario=0;
	String user;

	Usuario listadeusuarios[]=new Usuario[10];
	
	Producto listadeproductos[]=new Producto[10];
	
	Producto producto=new Producto();
	
	Operaciones operacionesdeusuario=new Operaciones();
	
	Administrador admin=new Administrador();
	
	Librocontable historialcontabilidad[]=new Librocontable[20];
	
	Factura resivousuario=new Factura();
	
	Librocontable contabilidad=new  Librocontable();
	
	public void Menumaquina() {



		do {
		
			op=Integer.parseInt(JOptionPane.showInputDialog("HOLA SOY AIKEN TU MAQUINA DISPENSADORA\n1. INGRESAR\n 2. CREAR\n 3.SALIR"));
		
			switch(op) {
			case 1:
				user=JOptionPane.showInputDialog("escriba usuario");
				contraseña=Integer.parseInt(JOptionPane.showInputDialog("escriba constraseña"));
				if(aux2==1) {

					admin.administrador(user, contraseña, listadeproductos,listadeusuarios,contuser2,historialcontabilidad,contcontabilidad);
					aux2=admin.auxiliar();
				}if(aux2==2){
	
					if(contuser2>0) {
						for(int h=0;h<contuser2;h++) {
							if(listadeusuarios[h].getUsurio().equals(user)&& listadeusuarios[h].getContraseñausuario()==contraseña) {
								JOptionPane.showMessageDialog(null, "HOLA "+listadeusuarios[h].getNombre()+ "\nSESION INICIADA");
								do {
									
								op2=Integer.parseInt(JOptionPane.showInputDialog("EN QUE PUEDO AYUDARTE(RECUERDE QUE EL MONTO MAXIMO PARA COMPRAR ES 20.000) \n1.COMPRAR \n2.DEPOSITAR DINERO \n3.TRANFERIR DINERO \n4.CAMBIAR CONTRASEÑA \n5.VER MI CODIGO \n6.VER MI DINERO \n7.SALIR"));
									switch(op2) {
									
									case 1:
										for(int n=0;n<admin.cuantoproductoshay();n++) {
											listadeproductos[n].mostrardatos();
											opccompraproducto=Integer.parseInt(JOptionPane.showInputDialog("DESEA COMPRAR ESTE PRODUCTO 1.SI, 2.NO"));
											if(listadeproductos[n].getCantidaddeproducto()>0) {	
												if(opccompraproducto==1) {
													if(listadeproductos[n].getCostoproducto()>=listadeusuarios[h].getDinerosdisponible()) {
														JOptionPane.showMessageDialog(null, "DINERO INSUFICIENTE PARA COMPRAR PRODUCTO");
														n=admin.cuantoproductoshay();
														
													}else {
														if(cuantollevausuario<=operacionesdeusuario.getMontomax()) {
			
															listadeusuarios[h].setComprarproduto(listadeproductos[n].getCostoproducto(),listadeusuarios[h].getCodigo());
															listadeproductos[n].setSecomproproducto();
															cuantollevausuario=cuantollevausuario+listadeproductos[n].getCostoproducto();
															
															resivousuario.facturausuario(listadeproductos,n);
															resivousuario.facturalista(listadeusuarios[h].getTipodeusuario());
															
															historialcontabilidad[contcontabilidad]=new Librocontable(listadeusuarios[h].getNombre(),listadeproductos[n].getCostoproducto(),listadeusuarios[h].getNombre(),listadeproductos[n].getNombreproducto());
															contcontabilidad=contcontabilidad+1;
														
															
															n=admin.cuantoproductoshay();
															
														}else {
															JOptionPane.showMessageDialog(null, "LIMITE MAXIMO DE COMPRA, POR FAVOR VUELVA Y COMPRE LA PROXIMA VEZ");
														}
													}
												}
											}else {
												JOptionPane.showMessageDialog(null, "LO SIENTO SE HA ACABADO EL PRODUCTO");
											}

										}
										break;
									case 2:
		
										operacionesdeusuario.setDepositar(h,listadeusuarios);
										JOptionPane.showMessageDialog(null, "SU DINERO HAORA ES: "+listadeusuarios[h].getDinerosdisponible());
										
										
										break;
										
									case 3:
										codigousuario=Integer.parseInt(JOptionPane.showInputDialog("POR FAVOR ESCRIBA EL CODIGO DEL USUARIO AL QUE DESEA TRANFERIR DINERO"));
										operacionesdeusuario.setTranferir(codigousuario,listadeusuarios,contuser2,h);
										
										break;
									case 4:
										operacionesdeusuario.setCambiarcontraseña(listadeusuarios,h);
										
										break;
									case 5:
										JOptionPane.showMessageDialog(null, "SU CODIGO ES: "+listadeusuarios[h].getCodigo());
						
										break;
									case 6:
										JOptionPane.showMessageDialog(null, listadeusuarios[h].getDinerosdisponible());
										
										break;
									case 7:
										op2=7;
										aux2=1;
										
										break;
									default :
										JOptionPane.showMessageDialog(null, "OPCION EQUIVOCADA");
										
										break;
									}
						
								}while(op2!=7);
							}else {
								aux=aux+1;

							}	
						}
					}else
					{
						JOptionPane.showMessageDialog(null, "LO SIENTO DATOS ERRONEOS O CUENTA NO EXISTENTE");
					}
					if(aux>0) {
						if(aux==contuser2) {
							JOptionPane.showMessageDialog(null, "LO SIENTO DATOS ERRONEOS O CUENTA NO EXISTENTE");
						}
					}
					aux2=1;
					
					break;

					
				}
				break;
			case 2:

				while(band==1) {
					codigousuario=codigousuario+1;
					band=0;
				}
				JOptionPane.showMessageDialog(null, "RECUERDE QUE SI USTED ES ESTUDIANTE O ADMINISTRATIVO TIENE BENEFICIOS\nEN DESCUENTOS, HABLE CON EL ADMINISTRADOR PARA QUE SUINFORMACION\nSEA SUMINISTRADA");
				double identificacion=Double.parseDouble(JOptionPane.showInputDialog("POR FAVOR ESCRIBA SU IDENTIFICACION"));
				String nombre=JOptionPane.showInputDialog("POR FAVOR ESCRIBA SU NOMBRE");
				int dinerodispobonible=Integer.parseInt(JOptionPane.showInputDialog("CUANTO DINERO TIENE"));
				String usurio=JOptionPane.showInputDialog("DIGITE UN NOMBRE DE USUARIO");
				int contraseña=Integer.parseInt(JOptionPane.showInputDialog("DIGITE LA CONTRASEÑA DE SU USUARIO (RECUERDE QUE SOLO NUMEROS DEBE TENER NUMERO NADA DE LETRAS)"));
				
				listadeusuarios[contuser]=new Usuario(codigousuario,identificacion, nombre, dinerodispobonible, usurio, contraseña);
		
				contuser=contuser+1;
				contuser2=contuser;
				band=1;
		
			
				break;
			case 3:
				op=3;
				JOptionPane.showMessageDialog(null, "HASTA LUEGO");
				
				break;
			default: 
			
				JOptionPane.showMessageDialog(null, "OPCION INCORRECTA");
				op=1;
				break;
	
			}
		}while(op!=3);		
		
	}


}

package maquinadispensadora;

import javax.swing.JOptionPane;

public class Operaciones {

	private double montomax;
	private double depositar;
	private double tranferir;
	private String cambiarcontraseña;
	private int cont2=0,cambiarcontraseña2=0;
	private double deposdinero=0,tranferirdinero=0;
	Usuario operacionesusuario=new Usuario();
	


	public Operaciones() {
		montomax=20000;
		depositar=0;
		tranferir=0;
		cambiarcontraseña="";
	}

	public double getMontomax() {
		return montomax;
	}

	public void setMontomax(double montomax) {
		this.montomax = montomax;
	}

	public double getDepositar() {
		return depositar;
	}

	public void setDepositar(int cont,Usuario listadeusuario1[]) {
		deposdinero=Double.parseDouble(JOptionPane.showInputDialog("HOLA, "+operacionesusuario.getNombre() +" CUANTO DINERO DESEA DEPOSITAR"));
		listadeusuario1[cont].setDepositardinero(deposdinero);
	}

	public double getTranferir() {
		return tranferir;
	}

	public void setTranferir(int tranferircodigo,Usuario listasuario2[],int contuser2,int contuser) {
		for(int t=0;t<contuser2;t++) {
			if(tranferircodigo==listasuario2[t].getCodigo()) {
				tranferirdinero=Double.parseDouble(JOptionPane.showInputDialog("USUARIO EXISTENTE \nCUANTO DINERO DESEA TRANFERIR"));
				if(tranferirdinero<=listasuario2[contuser].getDinerosdisponible()) {
					listasuario2[t].setDepositardinero(tranferirdinero);
					listasuario2[contuser].setTranferirdinero(tranferirdinero);
					cont2=cont2+1;
				}else {
					JOptionPane.showMessageDialog(null, "ESA CANTIDAD NO ES POSIBLE TRANFERIRILA YA QUE USTED CUENTA SOLO CON "+listasuario2[contuser].getDinerosdisponible());
					cont2=cont2+1;
				}
			}else if(cont2==tranferircodigo) {
				JOptionPane.showMessageDialog(null, "USUARIO NO EXISTENTE");
			}
		}
	}

	public String getCambiarcontraseña() {
		return cambiarcontraseña;
	}

	public void setCambiarcontraseña(Usuario listadeusuarios3[],int contuser2) {
		cambiarcontraseña2=Integer.parseInt(JOptionPane.showInputDialog("HOLA, " +listadeusuarios3[contuser2].getNombre()+"\nPOR FAVOR ESCRIBA SU NUEVA CONTRASEÑA"));
		listadeusuarios3[contuser2].setCambiarcontraseña(cambiarcontraseña2);;
	}


	
}

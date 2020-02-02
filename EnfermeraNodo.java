package Turnos;

import java.util.Date;

/**
	 * 
	 * @author 
	 * Esta clase maneja el conocimiento y comportamiento del objeto Nodo "Enfermera"
	 */
	public class EnfermeraNodo {
		//Variables
		protected int idEnfermera;
		protected String nombreCompleto;
		protected long telefonoContacto;
		protected int turnoSegundos;
		protected int IniTurnoSegundos;		
		protected boolean enTurno = false;
		protected boolean asignada = false;
		protected Date fechaAsignada = Date();

		
		/**
		 * Constructor EnfermeraNodo
		 * 
		 * @param nom Nombre
		 * @param tel Teléfono
		 * @param turnoMinutos minutos de turno
		 */
		public EnfermeraNodo(int id, String nom, long tel ,int turnoSg,int IniTurnoSg,boolean enTurno,boolean asignada, Date fechaAsignada) {
			this.idEnfermera = id;
			this.nombreCompleto = nom;
			this.telefonoContacto = tel;
			this.turnoSegundos = turnoSg;
			this.IniTurnoSegundos = IniTurnoSg;
			this.enTurno = enTurno;			
			this.asignada = asignada;
			this.fechaAsignada = fechaAsignada;
		}

		//Métodos

		private Date Date() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getNombreCompleto() {
			return nombreCompleto;
		}

		public int getId() {
			return idEnfermera;
		}

		public void setId(int id) {
			this.idEnfermera = id;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		public long getTelefonoContacto() {
			return telefonoContacto;
		}

		public void setTelefonoContacto(long telefonoContacto) {
			this.telefonoContacto = telefonoContacto;
		}

		public int getturnoSg() {
			return turnoSegundos;
		}

		public void setturnoSg(int turnoSg) {
			this.turnoSegundos = turnoSg;
		}		
		public int getIniTurnoSg() {
			return IniTurnoSegundos;
		}

		public void setIniTurnoSg(int IniTurnoSg) {
			this.IniTurnoSegundos = IniTurnoSg;
		}
		/**
		 * Muestra la información de una enfermera
		 */
		public String mostarInformacion(){
			if (asignada==true){
				return "ID: "+idEnfermera +"\nNombre Completo:" + " " + nombreCompleto + "\nTeléfono De Contacto: " + telefonoContacto
					+ " \nActiva: " + asignada  ;
			}
			else {
				return  "ID: "+idEnfermera +" ¡¡¡Esta Enfermera ha sido eliminada!!!";
			}
		}

		public boolean getAsignada() {
			return asignada;
		}

		public void setAsignada(boolean asignada) {
			this.asignada = asignada;
		}	
		public boolean getEnTurno() {
			return enTurno;
		}

		public void setEnTurno(boolean enTurno) {
			this.enTurno = enTurno;
		}	
		
		public Date getfechaAsignada() {
			return fechaAsignada;
		}

		public void setfechaAsignadao(Date fechaAsignada) {
			this.fechaAsignada = fechaAsignada;
		}			
		
		
	}


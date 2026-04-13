public class Reloj {

		private int segundos;
		private boolean formato24;
		
		
		Reloj ( int hora, int minutos, int segundos){
			this.segundos = hora*3600 + minutos*60 + segundos;
			this.formato24 = true;
		}
		
		
		// Mostrar la hora: genera un String con el  formado de hora  22:30:23
		// o 10:30:23 pm si el atributos Formato24 es falso 

		public String mostrar(){
			int fhoras = segundos / 3600;
			int fminutos = (segundos - (fhoras*3600))/60;
			int fsegundos = segundos - (fhoras*3600) - (fminutos*60);
			String resto ="";
			if  ( !formato24 ) {
				if (fhoras > 12 ) {
				   resto += " pm";
				} else {
					resto += " am";
				}	
			}
			if ( !this.formato24 && fhoras > 12 ) fhoras = fhoras -12;
			
			return String.format("%02d:%02d:%02d",fhoras,fminutos,fsegundos)+resto;
			
		}

		// Cambiar formato24, recibe un valor true si quiero formato de 
	      // 24 o falso si quiero de 12
		public void  cambiarFormato24( boolean formato24){
			this.formato24 = formato24;
		}
		
		// Incrementa en un segundo el valor de reloj
		public void tictac (){
			segundos++;
			// Mayor 3600 * 24
			if (segundos > 86400) segundos = 0;
		}
		
		// Comparar Hora, recibe como parámetro otro objeto Reloj 
		// y me devuelve el número de segundos que tienen de diferencia
		
		public int comparar ( Reloj otroreloj){
			
			return this.segundos - otroreloj.segundos;
		}


}

package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Contatto> contattiInRubrica = new LinkedList<Contatto>();
	int id=1;                                                                //nn ancora messo in lista ma appena inseirsco assume valore 1
	
	
	public void aggiungiContatto(Contatto contatto){                                           //"contatto" è dato dal kiamante
		boolean trovato=false;
		for(Contatto c : contattiInRubrica){                                                  //c è gia dentro la lista
			if((c.getNome().compareTo(contatto.getNome())==0 ) && c.getCognome().compareTo(contatto.getCognome())==0){
				trovato = true;
			}             
		                                                                         //	"else trovato = false; " --> false o true dipende solo da ultimo ele
		}
		
		if(trovato==false){                                                    //oppure  -->  if(!trovato)                              
		contattiInRubrica.add(contatto);  
		contatto.setId(id);
		id++;
		}
	
		
	}
	
	public List<Contatto> cerca(String nome, String cognome, String data, String telefono){     
		List<Contatto> trovati= new LinkedList<Contatto>();
		for(Contatto c : contattiInRubrica){
			if(c.getNome().equals(nome) || c.getCognome().equals(cognome) || c.getDataNascita().equals(data) || c.getTelefono().equals(telefono)){
				trovati.add(c);
			}
		}
		return trovati;                   //DEVONO PERO ESSERE STAMPATI CON ID PRIMA
	}
	
	
	public void cancella(int idContatto){
		for(Contatto c : contattiInRubrica){
			if(idContatto!=0 && c.getId()==idContatto){
				contattiInRubrica.remove(c) ;
			}
		}
	
		
		/*	if(trovato){
			contattiInRubrica.remove(idContatto);     //cosi remove crede ke l'id sia la posizione a interno di lista dove bisogna togliere
	
		
		}*/
		
	}
	
	public String cercaConId(int idContatto){                     //verifica ke l'ID passato dall'utente corrisponda ad un contatto e lo ritorna
		for(Contatto c : contattiInRubrica){
			if(c.getId()==idContatto)
				return c.toString();
		}
		return null;
	}
	
	public void modifica(String nomeM, String cognomeM, String dataM, String telefono){            //assegno valori nuovi
	
		
	}
	
	public void  stampaContatti(){                      //stampa in console
		 System.out.println(contattiInRubrica);
	}
	
	
	public boolean sonoNumeri(String telefono, String data){                                         //controlla ke data e tele siano numeri (inseriti da utente)
		for(int i =0; i<telefono.length(); i++){
			if(!Character.isDigit(telefono.charAt(i)) && ! Character.isDigit(data.charAt(i))){
				return false;	
			   }
		 }
		return true;
	}
	
	public static void main(String [ ] args){
		Model model = new Model();
		model.aggiungiContatto(new Contatto ("mario", "rossi", "1234", "1234", 0));    //aggiungo un contatto 
		//model.stampaContatti();                                                       //lo stampo
		
		model.aggiungiContatto(new Contatto ("luca", "bianco", "184", "184", 2));
		//model.stampaContatti();
		
		model.aggiungiContatto(new Contatto ("mario", "rossi", "1234", "1234", 0));
	//	model.stampaContatti();
		
		model.aggiungiContatto(new Contatto ("giuseppe", "bianco", "185", "185", 3));
	//	model.stampaContatti();
		
		model.aggiungiContatto(new Contatto ("fabio", "vario", "186", "186", 4));
	//	model.stampaContatti();
		
		model.aggiungiContatto(new Contatto ("filippo", "rossi", "187", "187", 5));
		model.stampaContatti();
		
		
		List<Contatto> trov = model.cerca(null, "bianco", null, null);
		System.out.println(trov);
		
		List<Contatto> trov1 = model.cerca("filippo", null, null, null);
		System.out.println(trov1);
		
		List<Contatto> trov2 = model.cerca("giappo", null, null, null);
		System.out.println(trov2);
		
		boolean trov3= model.contattoPresente(new Contatto("filippo", "rossi", null, null, 0));
		System.out.println(trov3);
		
		boolean trov4= model.contattoPresente(new Contatto("pippo", "pluto", null, null, 0));
		System.out.println(trov4);
		
		
		List<Contatto> trov5 = model.cerca("filippo", "rossi", null, null);
		System.out.println(trov5);
		
		model.cancella(5);
		model.stampaContatti();
		
		model.modifica(4);
		model.stampaContatti();
		
		Contatto trovato1 =model.cercaConId(2);
		System.out.println(trovato1);
		
		
		Contatto trovato4 =model.cercaConId(77);
		System.out.println(trovato4);
		
		
		
	}

}
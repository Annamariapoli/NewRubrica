package it.polito.tdp.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Contatto> contattiInRubrica = new LinkedList<Contatto>();
	int id=1;                                                                //nn ancora messo in lista ma appena inseirsco assume valore 1
	
	public void aggiungiContatto(Contatto contatto){    //ok                                       //"contatto" è dato dal kiamante
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
	
	public List<Contatto> cerca(String nome, String cognome, LocalDate data, String telefono){    //ok    
		List<Contatto> trovati = new LinkedList<Contatto>();
		for(Contatto c : contattiInRubrica){
			if(c.getNome().equals(nome) || c.getCognome().equals(cognome) || c.getDataNascita().equals(data) || c.getTelefono().equals(telefono)){
				trovati.add(c);
			}
		}
		System.out.println(trovati.toString());
		return trovati;                                  //DEVONO PERO ESSERE STAMPATI CON ID PRIMA
	}
	
	/*public void cancella(int idContatto){              //non funziona bene
		for(Contatto c : contattiInRubrica){
			if(c.getId()==idContatto){
				contattiInRubrica.remove(c) ;
				System.out.println("cancellato");
			}
		}
		/*	if(trovato){
			contattiInRubrica.remove(idContatto);     //cosi remove crede ke l'id sia la posizione a interno di lista dove bisogna togliere
		}*/
	
	public String cercaConId(int idContatto){                    //ok
		for(Contatto c : contattiInRubrica){
			if(c.getId()==idContatto){
				System.out.println(c.toString());
				return c.toString();
				}
		}
		System.out.println("non trovato");
		return null;
	}
	
	
/*	public void cancellaContatto(int idContatto){
		contattiInRubrica.remove(idContatto);
	}
	*/
	
	
	
	
	
	
	
	
	
	
	/*public void applicaModifica(int idContatto, String nomeNuovo, String cognomeNuovo, LocalDate dataNuova, String telefonoNuovo){
		//boolean trovato = false;
		for(Contatto c: contattiInRubrica){
			if(c.getId()==idContatto){
			//	trovato =true;
				c.setNome(nomeNuovo);
				c.setCognome(cognomeNuovo);
				c.setDataNascita(dataNuova);
				c.setTelefono(telefonoNuovo);
			}
		}
		//if(trovato){
			//Contatto c = new Contatto(nomeNuovo, cognomeNuovo, dataNuova, telefonoNuovo,id);
		
	}
	*/
	public void  stampaContatti(){                      //stampa in console
		 System.out.println(contattiInRubrica);
	}
	
	public void stampaPerRiga(){                                //stampare i contatti appartenenti alla lista uno per riga
		System.out.println(contattiInRubrica.toString());
	}
	
/*	public boolean sonoNumeri(String telefono, String data){          //non funziona                               //controlla ke data e tele siano numeri (inseriti da utente)
		for(int i =0; i<telefono.length(); i++)  for(int j=0; j<data.length(); j++){
				if(!Character.isDigit(telefono.charAt(i)) && !Character.isDigit(data.charAt(i))){
						System.out.println(false);
						return false;
						
					}
				}
			
		System.out.println(true);
		return true;
	}*/
	
/*	public boolean telefonoENumero(String telefono){               //funziona
		for(int i =0; i< telefono.length(); i++){
			if(!Character.isDigit(telefono.charAt(i))){
				System.out.println(false);
				return false;
			}
		}
		System.out.println(true);
		return true;
	}
	
	public boolean dataENumero(String data){               //funziona
		for(int i =0; i< data.length(); i++){
			if(!Character.isDigit(data.charAt(i))){
				System.out.println(false);
				return false;
			}
		}
		System.out.println(true);
		return true;
	}*/
	
	public static void main(String [ ] args){
		Model model = new Model();
		
		Contatto c1 = new Contatto("mario", "rossi",  null, "1234", 1);
		Contatto c2 = new Contatto("luca", "bianco", null, "184", 2);
		Contatto c3 = new Contatto("giuseppe", "bianco", null, "185", 3);
		Contatto c4 = new Contatto("mario", "rossi", null, "1234", 0);           //nn aggiunto
		Contatto c5 = new Contatto("fabio", "vario", null, "186", 4);
		
		model.aggiungiContatto(c1);
		model.aggiungiContatto(c2);
		model.aggiungiContatto(c3);
		model.aggiungiContatto(c4);
		model.aggiungiContatto(c5);
		
		model.stampaPerRiga();
		
		//model.cerca("mario","rossi" , null, "1234");     //non esiste 1999 ma lo ritorna lo stesso
		
	//	model.cancella(1);         //cancella mario
		//model.cancella(4);         //cancella giuseppe
		
		//model.stampaPerRiga();
		
	//	model.cercaConId(1);
	//	model.cercaConId(77);
	//	model.cancellaContatto(0);
		model.stampaPerRiga();
		
		
		/*model.aggiungiContatto(new Contatto ("mario", "rossi", "1234", "1234", 0));                                                        //lo stampo
		model.aggiungiContatto(new Contatto ("luca", "bianco", "184", "184", 2));
		model.aggiungiContatto(new Contatto ("mario", "rossi", "1234", "1234", 0));
		model.aggiungiContatto(new Contatto ("giuseppe", "bianco", "185", "185", 3));
		model.aggiungiContatto(new Contatto ("fabio", "vario", "186", "186", 4));
		
		 //model.aggiungiContatto(new Contatto ("filippo", "rossi", "187", "187", 5));
		//model.stampaContatti();
		model.stampaPerRiga();*/
		
		
	}

}
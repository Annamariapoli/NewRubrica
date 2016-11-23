package it.polito.tdp.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.model.Contatto;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RubricaController {
	
	private Model model = new Model();
	//private Contatto contatti;
	int id=1;

	public void setModel(Model model){
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnRicerca;

    @FXML
    private DatePicker txtDataNascita;

    @FXML
    private TextField txtId1;

    @FXML
    private Button btnModifica;

    @FXML
    private Button btnApplica;   //cancello
    
    @FXML
    private Button btnApplica1;   //modifica

    @FXML
    private TextField txttelefono;

    @FXML
    private TextField txtId2;

    @FXML
    private Button btnCancella;

    @FXML
    private TextArea txtResult;

    @FXML
    void doApplica(ActionEvent event) {                    //avviene la vera CANCELLAZIONE
    	                                                  //ho gia controllato ke l'id esiste
    //model.cancella(c);
    //txtResult.setText("La cancellazione è avvenuta con successo ! \n ");
    	
    }

    @FXML
    void doApplica1(ActionEvent event) {                             //avviene la MODIFICA //ora è abilitato
        model.modifica(txtNome.setText(nomeNuovo), txtCognome.setText(cognomeNuovo), txtDataNascita.setValue(dataNuova), txttelefono.setText(telefonoNuovo), idContatto);
    	txtResult.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {  	
    	int id = Integer.parseInt(txtId2.getText());          //prendo l'id inserito da utente e lo memorizzo in una variabile
    	Contatto c = null;
    	c= model.cercaConId(id);
    	if(c==null){
    		txtResult.appendText("Contatto non trovato ! \n ");
    		return;
    	}
    	else {                                                //se lo ha trovato
    		txtNome.setText(c.getNome());
    		txtCognome.setText(c.getCognome());
    		txtDataNascita.setValue(c.getDataNascita());
    		txttelefono.setText(c.getTelefono());

    		txtResult.appendText("Per confermare premi applica \n ");
    	
    		btnApplica.setDisable(false);                 //abilito applica??
    	}
      	
    }

    @FXML
    void doInserisci(ActionEvent event) {   //inserisco tutti i campi, assegno id, mess conferma//se nome e cogn gia presnti stampo mess errore
    	txtResult.clear();  	
    	String nome = txtNome.getText();
    	String cognome = txtCognome.getText();
    	String telefono = txttelefono.getText();
    	LocalDate data = txtDataNascita.getValue();
    	
    	//NON DEVONO ESSERE VUOTI             //ok
    	if(nome.length()==0){
    		txtResult.appendText("Inserisci il nome! \n ");
    		return;
    	}
    	if(cognome.length()==0){
    		txtResult.appendText("Inserisci il cognome! \n ");
    		return;
    	}	
    	if(telefono.length()==0){                                        
    		txtResult.appendText("Inserisci il telefono! \n ");
    		return ;
    	}
    	if(data==null){
    		txtResult.appendText("Inserisci la data! \n ");
    		return;
    	}
    	//DEVONO ESSERE LETTERE
    	for (int i = 0; i < nome.length(); i++) {    
            if (!Character.isLetter(nome.charAt(i))) {
            	txtResult.appendText("Caratteri non ammessi! \n" );
            	return;
            }
    	}
    	for (int i = 0; i < cognome.length(); i++) {    
            if (!Character.isLetter(cognome.charAt(i))) {
            	txtResult.appendText("Caratteri non ammessi! \n" );
            	return;
            }
    	}
    	//DEVE ESSERE NUMERO:	
    	boolean telefonoCorretto = model.telefonoNumero(telefono);            //ok
    	if(!telefonoCorretto){
    		txtResult.appendText("Il testo non è corretto! \n ");
    		return;
    	}
    	  	
    	Contatto c1 = model.cercaPerAdd(nome, cognome, data, telefono);
    	if(c1==null){
    		model.aggiungiContatto(c1);
    		id++;
    		txtResult.appendText("Contatto inserito ! \n ");
    	}
    	else {
    		    txtResult.appendText("Contatto gia presente ! \n ");              //genera eccez
    		    return;
    	}
    	
    	 
    /*	Contatto c = null;
        model.contattoPresente(nome, cognome, data, telefono);
    	if(model.contattoPresente(nome, cognome, data, telefono)){      // se è true
    		txtResult.appendText("Il contatto è gia presente! \n ");
    		return ;                  //questo funziona                                                        
    	}    
    	else { 
    		   if(!model.contattoPresente(nome, cognome, data, telefono))   //questo non funziona
    		       model.aggiungiContatto(c);
    	           id++;
    	           txtResult.appendText("contatto inserito! \n ");
             }*/
    	           //l'else non funziona nemmeno cosi:
    	          // model.aggiungiContatto(c);
                 //    id++;
                //   txtResult.appendText("contatto inserito! \n ");
   	}

    @FXML
    void doModifica(ActionEvent event) {                       //utente ha inserito l'ID // l' applicazione deve valorizzare i campi (di quell'ID)
    	int id= Integer.parseInt(txtId1.getText());
    	if(id==0){
    		txtResult.appendText("Contatto non trovato \n ");
    		return;
    	}	
    	Contatto c = null;
        c = model.cercaConId(id);                                       //se c'è mi ritorna un contatto  //senno ritorna null
    	if(c==null){
    		txtResult.appendText("Contatto non trovato ! \n ");
    		return;
    	}
    	else { 	
            	txtNome.setText(c.getNome());
    	        txtCognome.setText(c.getCognome());
    	        txtDataNascita.setValue(c.getDataNascita());
    	        txttelefono.setText(c.getTelefono());
    
    	        txtResult.appendText("Per confermare premi applica \n ");
    	
    	        btnApplica1.setDisable(false);           //lo abilito
    	}
    }

    @FXML
    void doRicerca(ActionEvent event) {	    //devo visualizzare l'ID nella textArea
      txtResult.clear();
        
        //utente puo inserire uno o piu campi per fare la ricerca
    	
    	String nome = txtNome.getText();
    	String cognome = txtCognome.getText();
    	String telefono = txttelefono.getText();
    	LocalDate data = txtDataNascita.getValue();
    	//una volta trovati nella text area devo stamparli tutti, ognuno preceduto dal suo ID
    	
    	List<Contatto> contattiTrovati = model.cerca(nome, cognome, data, telefono);
    	txtResult.appendText("I contatti trovati sono : " + contattiTrovati +  " \n ");
    	//txtResult.appendText(contattiTrovati);
    	return;
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtDataNascita != null : "fx:id=\"txtDataNascita\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtId1 != null : "fx:id=\"txtId1\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnModifica != null : "fx:id=\"btnModifica\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnApplica != null : "fx:id=\"btnApplica\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txttelefono != null : "fx:id=\"txttelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtId2 != null : "fx:id=\"txtId2\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rubrica.fxml'.";
        
        btnApplica.setDisable(true);
        btnApplica1.setDisable(true);

    }
}

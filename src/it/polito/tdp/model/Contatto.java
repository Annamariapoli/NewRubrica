package it.polito.tdp.model;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Contatto {  //ogg ke metto dentro la lista dei contatti
	
	 //NON POSSO CREARE LA LISTA QUI
	//XKE QUESTA CLASSE è COME SE FOSSE IL SINGOLO CONTATTO--> ES: GINO
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String telefono;
	private int id;
	
	public Contatto(String nome, String cognome, LocalDate dataNascita, String telefono, int id) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		String risultato= "";
		risultato= id+" "+nome+" "+cognome+" "+dataNascita+" "+telefono+ "\n";
		return risultato;
	}
}

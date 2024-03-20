package ensias.banque;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

abstract public class Compte {
	private int numero;
	private String nom;
	private double solde;
	private static int nbComptes; //0 par defaut
	private List<Operation> operations=new LinkedList<Operation>();
	
	
	public Compte(String nom,double solde) {
		if(nom==null){
			Scanner A=new Scanner(System.in);
		    System.out.println("Donner le nom:");
		    nom=A.next();
		}
		else this.nom=nom;
		this.solde=solde;
		nbComptes++;
		numero=nbComptes;//numero=++nbComptes	
	}
	public Compte()
	        {this(null,0.0);
	        }
	public Compte(Compte compte){
		    nom=compte.nom;
	        solde=compte.solde;
	        numero=++nbComptes;
	        }	
	
	public void deposer(final double montant)throws SoldeInsuffisantException {
		if (solde<0) throw new SoldeInsuffisantException(this,montant);
		this.solde+=montant; //this.solde+=montant;	
		add(new Operation(Operation.DEPOT,montant,new Date()));//date de systeme
	}
	
	public void retirer(double montant) throws SoldeInsuffisantException {
		if(montant>solde) {
			throw new SoldeInsuffisantException(this, montant);
		}
        this.solde -= montant;
		add(new Operation(Operation.RETRAIT,montant,new Date()));
    }
	
	public void virer(double montant,Compte compte)throws SoldeInsuffisantException {
		if (montant>solde) {
			throw new SoldeInsuffisantException(this, montant);
		}
        solde -= montant;
        compte.solde += montant;
    }
	

	public String toString() {
		return "Numero = "+ numero + "       Nom = " + nom + "     Solde = "+ solde;
		/* <=> String S="";
		 *     S+="Numero ="+numero;
		 *     S+="\tNom ="+nom;
		 *     S+="\tSolde ="+solde;
		 */
		
	}
	
	public boolean equals(Compte compte1,Compte compte2){
		return compte1.nom==compte2.nom && compte1.numero==compte2.numero ;	
	}
	
	public int getNumero() {
         return numero;
    }
	
	public String getNom() {
        return nom;
    }
	
	public double getSolde() {
	        return solde;
	}
	
	public void setNumero(int numero) {
         this.numero=numero;
    }
	
	public void setNom(String nom) {
           this.nom=nom;
    }
	
	public void setSolde(double solde) {
         this.solde = solde;
    }
	
	public boolean add(Operation op) {//add definie par l utilisateur
		return operations.add(op);//add predefinie dans List
	}
	
	public boolean remove(Operation op) {
		return operations.remove(op);
	}
	
	public String releve() {
		String S="";
		S+="Numero = "+numero + "\tNom = "+ nom ;
		S+="\n";
		
		/*for (int i=0;i<operations.size();i++) {
			S+="\n"+operations.get(i); //operations.get(i).toString()
		}*/
		
		for(Operation O:operations) {
			S+="\n"+O;
		}
		
		
		S+="\n\t\t\t\tSlode = "+solde;
		return S ;
		
	}
}
		










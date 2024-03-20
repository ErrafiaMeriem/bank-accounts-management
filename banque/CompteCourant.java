package ensias.banque;

import java.util.Date;
import java.util.Scanner;

public class CompteCourant extends Compte{
	private double decouvertAutorise;
	
	public CompteCourant(String nom, double solde, double decouvertAutorise) {
	    super(nom, solde);
	    this.decouvertAutorise = decouvertAutorise;
	}

	public void retirer(double montant) throws SoldeInsuffisantException {
	    if (montant > getSolde() + decouvertAutorise) { 
	        throw new SoldeInsuffisantException(this, montant);
	    }
	    setSolde(getSolde() - montant);
	    add(new Operation(Operation.RETRAIT, montant, new Date()));
	}

}

package ensias.banque;

public class SoldeInsuffisantException extends Exception{
	public SoldeInsuffisantException(Compte compte,double montant) {
		System.out.println("Impossible de retirer le montant :"
	                       + montant + " Solde ="+ compte.getSolde());
	}
}

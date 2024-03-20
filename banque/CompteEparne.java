package ensias.banque;

public class CompteEparne extends Compte{
	private double taux;
	
	public CompteEparne(String nom,double solde,double taux) {
		super(nom, solde);
		this.taux=taux;
	}
	

	public void deposer(double montant) throws SoldeInsuffisantException {
		super.deposer(montant*(1+taux));
		//setSolde(getSolde()+moantant*(1+taux));
		 }

}

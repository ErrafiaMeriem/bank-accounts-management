package ensias.banque;

import java.util.List;

public class Main3 {
	public static void main(String[] args) throws SoldeInsuffisantException {
	
	List<Compte> comptes= List.of (new CompteCourant("Karim",5000,1000),
			                       new CompteEparne("Nora",6000,0.05));
	
	for(int i=0;i<5;i++) {
		int i1=(int) (Math.random()*10)%2;
		int i2=1-i1;
		Compte compte1=comptes.get(i1);
		Compte compte2=comptes.get(i2);
		 double montant=Math.random()*5000;
		 int type= (int) ((Math.random()*100)%3);
		 switch(type){
	             case Operation.DEPOT : compte1.deposer(montant);break;
	             case Operation.RETRAIT : compte1.retirer(montant);break;
	             case Operation.VIREMENT : compte1.virer(montant,compte2);break;
	 }
	}
	
	for(Compte compte:comptes)
		System.out.println(compte.releve());
	}
}
	



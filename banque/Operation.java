package ensias.banque;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Operation {
	public static final int DEPOT=0, RETRAIT=1, VIREMENT=2;//convention constant en majiscule
	
    private int type;
    private double montant;
    public Date date;//package java.util
    
    public Operation(int type,double montant,Date date) {
    	this.type=type;
    	this.montant=montant;
    	this.date=date;
    }
    public boolean equals(Operation O) {
		return this.type==O.type && this.date.equals(O.date);
    }
    public int getType() {
        return type;
   }
	
	public double getMontant() {
       return montant;
   }
	
	public Date getDate() {
	        return date;
	}
	
	public void setType(int type) {
        this.type=type;
   }
	
	public void setMontant(double montant) {
          this.montant=montant;
   }
	
	public void setDate(Date date) {
        this.date = date;
   }
	
	public String toString() {
		String S="";
		S+=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",Locale.FRANCE).format(date);
		switch (type) {
		case Operation.DEPOT:
			S+="\tDepot\t"+new DecimalFormat("0.00").format(montant);
		    break;
		case Operation.RETRAIT:
			S+="\tRetrait\t\t\t"+new DecimalFormat("0.00").format(montant);
		    break;
		}
		return S;
	}
}

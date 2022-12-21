package bankPackage;

import java.util.Scanner;

public class Menu {
	
public static void options() {
	int option1;
	Scanner sc=new Scanner(System.in);
	do {
		
		System.out.println("Choose one option");
		System.out.println("1. Create bank account");
		System.out.println("2. Display account holder details");
		System.out.println("3. Deposit the amount");
		System.out.println("4. Withdraw the amount");
		System.out.println("5. Check Balance");
		System.out.println("6. Close the account");
		System.out.println("7. Exit");
		
		option1=sc.nextInt();
		switch(option1) {
		    case 1:
			//Operations.createAcc();
			    Operations.createAcc();
			    break;
		    case 2:
		    	Operations.diplayAccountholerDetails();
		    	break;
		    case 3:
		    	Operations.deposit();
		    	break;
		    case 4:
		    	Operations.withdraw();
		    	break;
		    case 5:
		    	Operations.checkBalance();
		    	break;
		   
		    case 6:
		    	Operations.closeAccount();
		    	break;
		    case 7:
		    	System.out.println("You successfully exit from this bank"+"\n"+"Thank you...Visit again");
		    	System.exit(0);
		
		}
		
	}while(option1<=7);
}
}

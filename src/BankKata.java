import Models.Account;

import java.util.Scanner;

public class BankKata {
    public static void main(String[] args) {


        Account account = new Account(12);
        Scanner scanner=new Scanner(System.in);

        while(true)
        {
            System.out.println("####  Bienvenue dans notre application  ####:");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Afficher le relevé de compte");
            System.out.println("4. Quitter L'application");
            System.out.print("Sélectionnez une option: ");

            int choix = scanner.nextInt();

            switch (choix)
            {
                case 1:
                    System.out.println("Entrez le montant à déposer: ");
                    int depositAmount  = scanner.nextInt();
                    account.deposit(depositAmount );
                    break;

                case 2:
                    System.out.println("Entrez le montant à retirer: ");
                    int withdrawAmount  = scanner.nextInt();
                    account.withdraw(withdrawAmount );
                    break;

                case 3:
                    account.printStatement();
                    break;

                case 4:
                    System.out.println("Merci d'avoir utilisé notre application.");
                    System.exit(0);


                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }


    }
}

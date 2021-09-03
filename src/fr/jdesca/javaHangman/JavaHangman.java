package fr.jdesca.javaHangman;


import java.util.Scanner;

public class JavaHangman {

	public static void main(String[] args) {
		String[] mots = {"programmation", "algorithme", "exception", "debugging"};
		boolean playing = true;
		int essai = 10;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenu notre jeu de pendu en java :");
		System.out.println("Tirage du mot....");
		String motADeviner = piocherMot(mots);
		System.out.println("Mot tiré ! Vous devez deviner un mot de " + motADeviner.length() + " caractère");
		String motMasque = "*".repeat(motADeviner.length());
		System.out.println("=================================================================");
		
		while(playing) {
			System.out.println(motMasque);
			System.out.println("Il vous reste " + essai + " tentatives");
			System.out.print("Veuillez saisir un caractère: ");
			char caractereSaisi = scan.nextLine().charAt(0);
			//on check si le caractère saisi est contenu dans la phrase 
			if(motADeviner.indexOf(caractereSaisi) != -1) {
				//on remplace les '*' par la lettre saisie
				for(int i = 0 ; i < motADeviner.length() ; i++) {
					if(motADeviner.charAt(i) == caractereSaisi) {
						motMasque = motMasque.substring(0, i) + caractereSaisi + motMasque.substring(i+1);
					}
				}
			}
			else {
				essai--; //equivalent essai = essai - 1 ;
			}
			
			if(motMasque.equals(motADeviner)) {
				System.out.println("Vous avez gagné !!! Youhooo !!!");
				playing = false;
			}
			else if(essai < 1) {
				System.out.println("Vous avez perdu !!! Looser !");
				System.out.println("Le mot à deviner était : " + motADeviner);
				playing = false;
			}
		}
		
		//une fois la boucle de jeu fini, on dit au revoir
		System.out.println("Merci d'avoir jouer avec nous !");
		System.out.println("A bientot !");
		
	}
	
	public static String piocherMot(String[] mots) {
		int index = (int)(Math.random() * (mots.length));
		return mots[index];
	}
}

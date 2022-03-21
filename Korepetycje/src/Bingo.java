import java.util.Arrays;
import java.util.Scanner;

public class Bingo {
	
	
	public static String bingo(int[][] tab1) {
		
		int bingo =0;
		String bingooo ="Bingo!";
		int i=0;
		int j=0;
		int a=0;
		int b=0;
		int numer;
		int taboznaczone[][] = new int[5][5];
		boolean bingoo=false;
		int tabLiczby[] = new int[75];
		int kolejnaTabLiczba =0;
		boolean kolejnaTabLiczbaa=false;
		int numertmp=0;
		int licznik=0;
		
		while(bingoo!=true) {
			//losowanie liczby bez powtarzania
			while(kolejnaTabLiczbaa==false) {
				numertmp=(int)(Math.random() *74+1);
				for(int z=0;z<75;z++) {
					if(tabLiczby[z]!=numertmp)
						licznik++;
					if (licznik==75) {
						tabLiczby[kolejnaTabLiczba]=numertmp;
						kolejnaTabLiczba++;
						kolejnaTabLiczbaa=true;
					}
				}
				licznik=0;
			}
			numer=numertmp;
			kolejnaTabLiczbaa=false;
			
			System.out.print(numer+",");
			//zaznaczanie czy jest bingo
			for(;i<5;i++) {
				for(;j<5;j++) {
					if(numer==tab1[i][j]) {
						taboznaczone[i][j]=1;
					}
				}
				j=0;
			}
			i=0;
			j=0;
			//sprawdzanie czy jest bingo
			//pionowo
			taboznaczone[2][2]=1;
			for(;a<5;a++) {
				for(;b<5;b++) {
					if(taboznaczone[a][b]==1) 
						bingo++;	
					if(bingo==5) 
							bingoo=true;
				}
				bingo=0;
				b=0;
			}
			bingo=0;
			b=0;
			a=0;
			//poziomo
			for(;a<5;a++) {
				for(;b<5;b++) {
					if(taboznaczone[b][a]==1) 
						bingo++;
					if(bingo==5) 
							bingoo=true;
				}
				bingo=0;
				b=0;
			}
			bingo=0;
			b=0;
			a=0;
			//ukosnie
			for(;a<5;a++) {
				for(;b<5;b++) {
					if(taboznaczone[a][b]==1 && a==b) {
						bingo++;
						if(bingo==5) {
							bingoo=true;
						}
					}
				}
				b=0;
			}
			bingo=0;
			b=0;
			a=4;
			//ukosnie w 2 strone
				for(;b<5;b++) {
					if(taboznaczone[a][b]==1) {
						bingo++;
						if(bingo==5) {
							bingoo=true;
						}
					}
					a--;
				}
			
			bingo=0;
			b=0;
			a=0;
		}
		//Bingo!
		if(bingoo==true)
			bingo=5;
		//Pisanie tabelki bingo
		System.out.println(" ");
		for(;a<5;a++) {
			for(;b<5;b++) {
				System.out.print("["+taboznaczone[a][b]+"]");
			}
			System.out.println(" ");
			b=0;
		}
		return bingooo;
	}
	
	
	public static void main(String[] args) {
		
		
		int tab1[][] = new int [5][5];
		//koncepcja na wiecej graczy
//		int tab2[][] = new int [5][5];
//		int tab3[][] = new int [5][5];
//		int[] tab4= {1,2,3,4,5,6};
		
		int liczba=0;
		int k=0;
		int l=0;
		int a=0;
		int b=0;
		int ileWpisanychWKolumnie=0;
		int ileWpisanychwwierszu=0;
		
		//losowanie liczb do tabelki bingo bez powtorzen
	    while(ileWpisanychWKolumnie<5){
			while(ileWpisanychwwierszu<5) {
				liczba=(int)(Math.random() *74+1);
				boolean czyWstawic= true;
				for(;k<5;k++) {
					for(;l<5;l++) {
						if(liczba==tab1[k][l]) {
							czyWstawic= false;
						}
					}
					l=0;
				}
				k=0;
				l=0;
				if(czyWstawic) {
					tab1[ileWpisanychWKolumnie][ileWpisanychwwierszu]=liczba;
					ileWpisanychwwierszu++;
				}
			}
			ileWpisanychwwierszu=0;
			ileWpisanychWKolumnie++;
	    }
	    //pisanie tabelki bingo
	    for(;a<5;a++) {
			for(;b<5;b++) {
				System.out.print("["+tab1[a][b]+"]");
			}
			System.out.println(" ");
			b=0;
		}
		System.out.println((bingo(tab1)));
	}

}

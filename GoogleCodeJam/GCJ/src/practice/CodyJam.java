package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CodyJam {
	public static void main(String[] args) throws FileNotFoundException {
		CodyJam cj = new CodyJam();
		cj.solve();
	}
	
	private void solve() throws FileNotFoundException {
		Scanner s = new Scanner(new File("CodyJam-Large.in"));
		int t = s.nextInt();
		
		for(int cases=1; cases<=t; cases++) {
			List<PriceObject> allPrices = new ArrayList<>();
			int n = s.nextInt();
			
			for (int i=0; i<(2*n); i++) {
				PriceObject priceObject = new PriceObject(s.nextInt());
				allPrices.add(priceObject);
			}
		
			Iterator<PriceObject> salePriceIterator = allPrices.iterator();
			Iterator<PriceObject> regularPriceIterator  = allPrices.iterator();
			
			System.out.print("Case #" + cases + ":");
			
			while(regularPriceIterator.hasNext()) {
				PriceObject priceObject = salePriceIterator.next();
				if (!priceObject.isVisited) {
					System.out.print(" " + priceObject.price);
					priceObject.isVisited = true;
					while(regularPriceIterator.hasNext()) {
						PriceObject regularPrice = regularPriceIterator.next();
						if (regularPrice.price == ((regularPrice.price - priceObject.price) * 4)
								&& !regularPrice.isVisited) {
							regularPrice.isVisited = true;
							break;
						}
					}
				}
			}
			System.out.println();
		}
			
		s.close();
	}
	
	class PriceObject {
		int price;
		boolean isVisited=false;
		
		public PriceObject(int price) {
			this.price = price;
		}
	}
}

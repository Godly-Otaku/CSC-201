package Lab19;

import java.util.*;
import java.io.*;

public class CookieDeals {
	public static void main(String[] args) {
		File file = new File(args[0]);
		Scanner scnr;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! but this file does not exist. Please check file name and try again");
			return;
		}
		while (scnr.hasNextLine()) {
			String[] NM = scnr.nextLine().split(" ");
			int numOfDeals = Integer.parseInt(NM[0]);
			int maxCookie = Integer.parseInt(NM[1]);
			if (numOfDeals == 0)
				continue;
			int[][] deals = new int[numOfDeals][2];
			for (int i = 0; i < numOfDeals; i++) {
				String[] line = scnr.nextLine().split(" ");
				int cookie = Integer.parseInt(line[0]);
				int dollar = Integer.parseInt(line[1]);
				deals[i][0] = cookie;
				deals[i][1] = dollar;
			}
			int[] bestDeal = deal(deals, maxCookie);
			if (bestDeal[0] != 0)
				System.out.println("Purchase " + bestDeal[0] + " cookies for $" + bestDeal[1]);
			else
				System.out.println("No good deals");
		}
		scnr.close();
	}

	public static int[] deal(int[][] deals, int maxCookie) {
		int[] best = new int[2];
		int closest = Integer.MAX_VALUE;
		int trackIndex = 0;
		boolean deal = false;
		for (int i = 0; i < deals.length; i++) {
			if (deals[i][0] > maxCookie)
				continue;
			if (maxCookie - deals[i][0] < closest) {
				closest = maxCookie - deals[i][0];
				trackIndex = i;
				deal = true;
			}
		}
		if (deal) {
			best[0] = deals[trackIndex][0];
			best[1] = deals[trackIndex][1];
		} else {
			best[0] = 0;
			best[1] = 0;
		}
		return best;
	}
}
package Lab18;

import java.util.*;
import java.io.*;

public class Payroll {
	public static void main(String[] args) {
		File file = new File(args[0]);
		Scanner scnr;
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry! but this file does not exist. Please check file name and try again");
			return;
		}
		Manager[] ms = new Manager[20000];
		CommissionEmployee[] cms = new CommissionEmployee[20000];
		HourlyWorker[] hws = new HourlyWorker[20000];
		int mcount = 0;
		int cmcount = 0;
		int hwcount = 0;
		while (scnr.hasNextLine()) {
			String next = scnr.nextLine();
			String clean = "";
			for (int j = 0; j < next.length(); j++) {
				if (next.charAt(j) != ' ')
					clean += next.charAt(j);
			}
			String type = clean.substring(0, 1);
			String[] values = clean.split(",");
			switch (type) {
			case "#":
				Manager m = new Manager(values[0].substring(1), values[1], Double.parseDouble(values[2]));
				ms[mcount] = m;
				mcount++;
				break;
			case "*":
				CommissionEmployee ce = new CommissionEmployee(values[0].substring(1), values[1],
						Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]));
				cms[cmcount] = ce;
				cmcount++;
				break;
			case "@":
				HourlyWorker hw = new HourlyWorker(values[0].substring(1), values[1], Double.parseDouble(values[2]),
						Double.parseDouble(values[3]));
				hws[hwcount] = hw;
				hwcount++;
				break;
			}
		}
		System.out.println("Manager: ");
		for (Manager emp : ms) {
			if (emp == null)
				continue;
			System.out.println(emp.toString());
		}
		System.out.println();
		System.out.println("Commission Employee: ");
		for (CommissionEmployee emp : cms) {
			if (emp == null)
				continue;
			System.out.println(emp.toString());
		}
		System.out.println();
		System.out.println("Hourly Worker: ");
		for (HourlyWorker emp : hws) {
			if (emp == null)
				continue;
			System.out.println(emp.toString());
		}
		scnr.close();
	}
}
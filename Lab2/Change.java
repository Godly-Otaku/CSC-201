package Lab2;

public class Change {
      public static void main(String[] args) {
            int amt = Integer.parseInt(args[0]);

            int dollars = (int) amt / 100;

            amt -= (100 * dollars);
            int quarters = amt / 25;
            amt -= (25 * quarters);
            int dimes = amt / 10;
            amt -= (10 * dimes);
            int nickels = amt / 5;
            amt -= (5 * nickels);

            if (dollars >= 1) {
                  String plurdol = (dollars > 1) ? " Dollars" : " Dollar";
                  System.out.println(dollars + plurdol);
            }
            if (quarters >= 1) {
                  String plurquar = (quarters > 1) ? " Quarters" : " Quarter";
                  System.out.println(quarters + plurquar);
            }
            if (dimes >= 1) {
                  String plurdime = (dimes > 1) ? " Dimes" : " Dime";
                  System.out.println(dimes + plurdime);
            }
            if (nickels >= 1) {
                  String plurnick = (nickels > 1) ? " Nickels" : " Nickel";
                  System.out.println(nickels + plurnick);
            }
            if (amt >= 1) {
                  String plurpen = (amt > 1) ? " Pennies" : " Penny";
                  System.out.println(amt + plurpen);
            }
            if (amt < 1) {
                  System.out.println("No change");
            }
      }
}
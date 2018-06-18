package algorithms.implementation.bon_appetit;

import java.util.Scanner;

public class BonAppetit {

    /*
     * The first line contains two space-separated integers  and , the number of items ordered and the -based index of the item that Anna did not eat.
The second line contains  space-separated integers  where .
The third line contains an integer, , the amount of money that Brian charged Anna for her share of the bill.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int k = in.nextInt();

        int[] bill = new int[n];
        for (int i = 0; i < n; i++)
            bill[i] = in.nextInt();

        int charged = in.nextInt();

        int totalCost = 0;
        for (int i = 0; i < bill.length; i++) {
            totalCost += bill[i];
        }

        if (charged == (Math.abs(totalCost - bill[k]) / 2))
            System.out.println("Bon Appetit");
        else
            System.out.println(Math.abs(charged - ((totalCost - bill[k]) / 2)));
    }
}



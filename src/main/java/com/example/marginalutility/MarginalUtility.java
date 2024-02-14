package com.example.marginalutility;
import java.util.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;


public class MarginalUtility {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        System.out.println("Enter -1 to stop the entries");
        System.out.println("Lets start with Total Utility of Tees in utils");
        double[] Tees = new double[20];
        int t = 0;
        do {
            System.out.println("Enter Total Utility" + t + " :");
            Tees[t] = scanf.nextDouble();
            t++;
        }
        while (Tees[t - 1] != -1);
        int sizeT = t - 1;
        System.out.println(sizeT);

        System.out.println("Now turn for Total Utility of Moviesin utils");
        double[] Movies = new double[20];
        int m = 0;
        do {
            System.out.println("Enter Total Utility" + m + " :");
            Movies[m] = scanf.nextDouble();
            m++;
        } while (Movies[m - 1] != -1);
        int sizeM = m - 1;
        System.out.println(sizeM);
        System.out.println("Enter the amount given to spend: $");
        double balance = scanf.nextDouble();
        System.out.println("Enter the unit price of Tees: $");
        double Tunit = scanf.nextDouble();
        System.out.println("Enter the unit price of Movies: $ ");
        double Munit = scanf.nextDouble();
        double div1 = balance / Tunit;
        int maxT = (int) Math.floor(div1);
        double div2 = balance / Munit;
        int maxM = (int) Math.floor(div2);
//Creating ArrayList Object
        ArrayList<Combination> AL = new ArrayList<>();
        for (int n_t = 0; n_t <= maxT; n_t++) {
            double Texpense = n_t * Tunit;
            int n_m = (int) Math.floor((balance - Texpense) / Munit);
            double ctu = Tees[n_t] + Movies[n_m];

            AL.add(new Combination(n_t, n_m, ctu));
        }
        for (Combination i : AL) {
//           lets print all the combiantions
            System.out.println("The combination is: " + i.getT() + " Tshirts " + " and " + i.getM() + " Movies " + " with  combined total utility( ctu) " + i.getCTU());
        }
        double max = 0;
        for (Combination j : AL) {
            double val = j.getCTU();
            if (val > max) {
                max = val;
            }
        }
        System.out.println("the maximum is " + max);

    }




}
/*I dont want to enter the value again and again in every run , since the value I am entering is always same, why not
write the values somewhere and store them in a file maybe and let the program get the datas from that file.
The case is same in GUI too, i dont want user to reenter the value again, say they entered the value and computed and system
gives the answer and it deletes all the datas then user say wanted to check whether the value he/she stored maybe incorrect,
now all datas are erased then it will  be tedius to reenter the value, so why not have a retrieve button, that basically retireves
the previous entries from  a storage(that can be simple file (clipboard) or advanced database ) ,
 */







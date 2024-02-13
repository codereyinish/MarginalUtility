package com.example.marginalutility;
import java.util.*;


public class MarginalUtility {
    public static void main(String[] args)
    {
//        MarginalUtility MU = new MarginalUtility();, no methods and class to access inside main static so didnt find it necessary to instantiate this class
//        created this because to access the non private methods, members or class(Combination) inside it
//        Scanner scanf = new Scanner(System.in);
//        System.out.println("Enter STOP to stop the entries");
//        double [] Tees = new double[20];
//        String cmd;
//        while(cmd.equalsIgnoreCase("STOP"))
//        {
//            System.out.println("Enter next Total Utility: ");
//            cmd = scanf.nextLine();
//        }
        Scanner scanf = new Scanner(System.in);
        System.out.println("Enter -1 to stop the entries");
        System.out.println("Lets start with Total Utility of Tees in utils");
        double [] Tees = new double[20];
        /* not good because total utility can be negative too */
        int t = 0;
        do
        {
            System.out.println("Enter Total Utility" + t  + " :");
            Tees[t] = scanf.nextDouble();
            t++;
        }
        while(Tees[t-1]!= -1);// you check for previous index, bcoz index is already incremente
        int sizeT = t - 1; //not i -2, because, i is initially 0.
//        size of array and size or number of Total Utilities are not meant to be same ;
        System.out.println(sizeT);

        /* Problem is all process need to be continued in one single run, if the program quits say after printing
         * 12 values, and in next section it quits, the data wont get stored somewhere, user agian has to enter the
         * value from start, if we store then user can again go backwards and edit the value in another run too */

        System.out.println("Now turn for Total Utility of Moviesin utils");
        double [] Movies = new double[20];
        int m = 0;
        do
        {
            System.out.println("Enter Total Utility" + m + " :");
            Movies[m] = scanf.nextDouble();
            m++;
        }while(Movies[m-1]!= -1);
        int sizeM = m -1;
        System.out.println(sizeM);

        /* Lets find combined total utility
    * Thought process:
    * find max number of tees that can be purchased with given balance..floor
    * iterate n(t)-- number of tees that can be bought and find corresponding n(m)--number of movies that can be bought
    * calculate combined total utility(clt) by adding corresponding  total utility Array value of both n(t) and n(m),
    update maximum value with clt*
     */
        System.out.println("Enter the amount given to spend: $");
        double balance = scanf.nextDouble();
        System.out.println("Enter the unit price of Tees: $");
        double Tunit =  scanf.nextDouble();
        System.out.println("Enter the unit price of Movies: $ ");
        double Munit =  scanf.nextDouble();
//        Since I didnt see Math.floorDiv(with double arguments)
        double div1 = balance/Tunit;
        int maxT = (int) Math.floor(div1);
        double  div2 = balance/Munit;
        int maxM = (int) Math.floor(div2);
//Creating ArrayList Object
         ArrayList<Combination> AL = new ArrayList<>();
        for(int n_t = 0; n_t<= maxT; n_t++ ) //variable name can't be special character like (), underscore _ allowed
        {
            double  Texpense = n_t * Tunit;
            int n_m = (int) Math.floor((balance - Texpense)/Munit);
//            //Lets assume for now , user is going to fill  up all total utilitis, so Array wont be out of bound
            double ctu = Tees[n_t] + Movies[n_m];
//            adding combination and total utility sum(ctu)  to ArrayList, then later finding max ct from list

//          this object is created inside object of non static parent  class"MarginalUtility"
            AL.add(new Combination(n_t, n_m, ctu));
        }
//        Now accessing the combination through ArrayList methods(this is why I preffered Array over Arraylist)
//      now we have all the combination and sum, lets find the max
       for(Combination i : AL) {
//           lets print all the combiantions
           System.out.println("The combination is: " + i.getT() + " Tshirts " + " and " + i.getM() + " Movies " + " with  combined total utility( ctu) " + i.getCTU());
       }
// The reason I didn't put "Tshirts" and  " and " together is because, name of the quantity can be different too. I will store it as variable based on the user input of name of items or choices.
//let's find the maximum ctu:
           double max = 0;
           for(Combination j : AL)
           {
             double val = j.getCTU();
              if(val>max)
               {
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







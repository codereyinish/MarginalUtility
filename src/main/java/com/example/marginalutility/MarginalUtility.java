package com.example.marginalutility;
import java.util.*;

public class MarginalUtility {
    public static void main(String[] args)
    {
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
//        maxCTU = maximum CTU, where CTU = combined TU, where TU is total utilties of both respective quantities
        double maxCTU = 0;
        //            Let o_t and o_m be the optimal combination
        int o_t = 0;
        int o_m = 0; //because  0 means no purchase at all initially for balance = $0
//              to find size of combination array, we need size. For this .  we have maxT, lets find maxN
        double  div2 = balance/Munit;
        int maxM = (int) Math.floor(div2);

        for(int n_t = 0; n_t<= maxT; n_t++ ) //variable name can't be special character like (), underscore _ allowed
        {
            double  Texpense = n_t * Tunit;
            int n_m = (int) Math.floor((balance - Texpense)/Munit);
//            Storing combination after calculating n_m;

            double CTU = Tees[n_t] + Movies[n_m];
            if(CTU>maxCTU)
            {
                maxCTU = CTU;
                o_t = n_t;
                o_m = n_m;
            }

        }
        System.out.println("The maximum  total utility that can be gained by purchased by buying set of Tees and movies is:  " + maxCTU);
//    best combination of Tees and Movies


    }
    public class Combination {
        private int T;
        private int M;

        public Combination(int T, int M) {
            this.T = T;
            this.M = M;
        }

        //I am not gonna change the 'T' and 'M' in the near future, so no need of Set(.....);
        public int getT() {
            return T;
        }

        public int getM() {
            return M;
        }

        /*Deep cloning of complex object is resource intensive(time and memory). THough it is not complex
        what we are doing, we still dont use it for minimalism.. See  objects are not going to be modified later
        intentionally , and top of that we have set instance variables(T and M) as private so we need set(..args) methods
         */
    }




    }





}

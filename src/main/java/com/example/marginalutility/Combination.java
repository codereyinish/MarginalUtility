package com.example.marginalutility;

public class Combination {
        private int T;
        private int M;
        private double CTU;

        public Combination(int n_t, int n_m, double ctu ) {
            T = n_t;
            M = n_m;
            CTU = ctu;
        }

        //I am not gonna change the 'T' and 'M' in the near future, so no need of Set(.....);
        public int getT() {

            return T;
        }

        public int getM() {
            return M;
        }
        public double getCTU()
    {
    return CTU;
    }

        /*Deep cloning of complex object is resource intensive(time and memory). THough what we are doing is not complex
     , we still dont use it to enhance minimalism.. See ,objects are not going to be modified later
        intentionally , and top of that we have set instance variables(T and M) as private so we need set(..args) methods
         */
    }
}

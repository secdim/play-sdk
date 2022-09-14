using System;

namespace program
{
    public class Program
    {
        private static int surcharge = 10;
        private static int threshold = 1000;

        static void Main(string[] args)
        {
            Console.WriteLine("[?] Enter an amount (e.g. 10, 1000):");
            int amount = Convert.ToInt32(Console.ReadLine());

            if (approval(amount))
            {
                Console.WriteLine("[i] The amount requires approval");
            } 
            else
            {
                Console.WriteLine("[i] The amount does not require approval");
            }
        }

        /**
         * Checks if a given ammount requires approval
         * Return true if a given amount is bigger than a given threshold
         * @return boolean
         */
        public static bool approval(int value)
        {
            int amount = value + Program.surcharge;
            if (amount >= Program.threshold)
            {
                return true;
            }
            return false;
        }
    }
}

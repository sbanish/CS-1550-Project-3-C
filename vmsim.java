// Shawn Banish Project 3 CS 1550

public class vmsim {

   public static void main(String[] args) {
      int numframes = 0;
      String algorithm = "";
      int refresh = 0;
      int tau = 0;
      String filename = "";

      for (int i=0; i<args.length; ++i) {
         if (args[i].equals("-n")) {
            try {
               numframes = Integer.parseInt(args[1]);
            } catch (Exception e) {
               printErrorMsg();
               System.out.println("\n*Please enter an integer for the numframes parameter.\n");
               System.exit(0);
            }
            if (numframes!=8 && numframes!=16 && numframes!=32 && numframes!=64 && numframes!=128 ) {
               printErrorMsg();
               System.out.println("\n*Please enter 8, 16, 32, 64, or 128 for the numframe parameter.\n");
               System.exit(0);
            }
         } else if (args[i].equals("-a")) { algorithm = args[i+1]; }
         else if (args[i].equals("-r")) { refresh = Integer.parseInt(args[i+1]); }
         else if (args[i].equals("-t")) { tau = Integer.parseInt(args[i+1]); }
         else if (i == args.length-1) { filename = args[i]; }
      }

      if (algorithm.toLowerCase().equals("opt")) {
        Opt o = new Opt(filename, numframes);
      } else if (algorithm.toLowerCase().equals("clock")) {
         Clock c = new Clock(filename, numframes);
      } else if (algorithm.toLowerCase().equals("work")) {
		  System.out.println();
         Work w = new Work(filename, numframes, refresh, tau);
      } else if (algorithm.toLowerCase().equals("aging")) {
         Aging a = new Aging(filename, numframes, refresh);
      } else {
         printErrorMsg();
         System.out.println("\n*Please enter opt|clock|aging|work for command-line parameter 3.\n");
         System.exit(0);
      }
   }

   public static void printErrorMsg() {
      System.out.println("Incorrect usage of the command-line parameters. Please enter one of the following:");
      System.out.println("java vmsim –n <numframes> -a <opt> <tracefile>");
      System.out.println("java vmsim –n <numframes> -a <clock> <tracefile>");
      System.out.println("java vmsim –n <numframes> -a <aging> -r <refresh> <tracefile>");
      System.out.println("java vmsim –n <numframes> -a <work> -r <refresh> -t <tau> <tracefile>");
   }
}
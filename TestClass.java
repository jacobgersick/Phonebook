import java.util.Scanner;
public class TestClass {

   public static void main(String[] args) {
      String response = "";
      Scanner console = new Scanner(System.in);    
      PhonebookManager phonebook = new PhonebookManager();
         
      System.out.println("Welcome to your phone book, "
         + "please select from the menu.\n"); 
   
      do {
         response = menu();
         switch (response) {
            case "a":
               phonebook.append();
               break;
            case "i":
               if (phonebook.getSize() == 0) {
                  System.out.println("Use 'a' to add an entry first.");
                  break;
               } else {              
                  phonebook.printOut();
                  System.out.println("Insert before which entry?");
                  int num = console.nextInt();
                  console.nextLine();               
                  phonebook.insert(phonebook.getNodeAt(num));
                  break; }
            case "d":
               if (phonebook.getSize() == 0) {
                  System.out.println("Nothing to delete! ^\\_(o_o)_/^");
                  break;
               } else {
                  phonebook.printOut();
                  System.out.println("Which entry to delete?");
                  int num = console.nextInt();
                  console.nextLine();
                  phonebook.delete(phonebook.getNodeAt(num));
                  break;
               }
            case "e":
               if (phonebook.getSize() == 0) {
                  System.out.println("Use 'a' to add an entry first.");
                  break;
               } else { 
                  phonebook.printOut();
                  System.out.println("Select which No: entry to edit:");
                  int num = console.nextInt();
                  if (num < 1 || num > phonebook.getSize()) {
                     System.out.println("Invalid selection");
                     break;
                  }else{
                     console.nextLine();
                     System.out.println("Select which field to edit:");
                     choices();
                     int field = console.nextInt();
                     console.nextLine();
                     phonebook.edit(phonebook.getNodeAt(num),field); 
                  }           
                  break;
               }         
            case "p":
               phonebook.printOut();
               break;
            case "q":
               break;
            default:
               System.out.println("\nWrong entry, please try again.\n");
         } //end switch/case
      } //end do/while
      while (!response.equals("q")); //ends program when q is pressed
      System.out.print("\n\n Goodbye.");
   
   }//end main 
   
   public static String menu() {
      Scanner console = new Scanner(System.in);
      System.out.println("Would you like to:\n"); 
      System.out.println("(a)ppend an entry to the end of the list\n");
      System.out.println("(i)nsert an entry at a point in the list\n");
      System.out.println("(d)elete an entry\n"); 
      System.out.println("(e)dit fields in an entry\n");
      System.out.println("(p)rint your phonebook\n"); 
      System.out.println("(q)uit\n");
      System.out.print("Enter your selection:");   
      return console.nextLine();  
   } // end menu
   
   public static void choices() {
      System.out.println("1\t First Name");
      System.out.println("2\t Last Name");
      System.out.println("3\t Address");
      System.out.println("4\t City");
      System.out.println("5\t Phone Number");
   
   }
      
}//end class
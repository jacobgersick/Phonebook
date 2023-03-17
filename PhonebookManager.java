import java.util.Scanner;
public class PhonebookManager {
   
   private int size; 
   private ListNode head; //keeps track of the list start
    
   public PhonebookManager() { //constructor for the manager
      this.head = null;
      this.size = 0; 
   }//end constructor
   
   //creates a node at end, makes it the head if no other nodes are created 
   public void append() {
      ListNode newNode = new ListNode();
      dataFill(newNode);
      if (head == null) { //replaces head with newNode if there isn't one yet
         size++;
         newNode.entryNo = size;
         head = newNode;
         return;
      } else {
         ListNode current = head;
         while (current.next != null) { //cycles through to find a node that's null
            current = current.next;
         }//end while
         current.next = newNode;// replaces found node
      }//end if/else
      size++;
      newNode.entryNo = size;
   }//end add method
   
   //takes in a node to delete, finds it and removes from list
   public void delete(ListNode deleteMe) {
      if (head == deleteMe) {
         head = head.next;
         size--;
         ListNode current = head;
         while (current != null) {
            current.entryNo--;
            current = current.next;   
         }   
      } else {
         ListNode current = head;
         while (current.next != deleteMe) {
            current = current.next;
         }
         current.next = current.next.next;
         size--;
         current= current.next;
         while (current != null) {
            current.entryNo--;
            current = current.next; 
         }
      }
   }//end delete method   
   

   //prints a header and then each node's contents
   public void printOut() {
      ListNode current = head;
      System.out.printf("%4s%15s%15s%15s%15s%15s\n","No:",
      "First Name:","Last Name:"
         ,"Address:","City:","Phone:");
      while (current != null) {
         System.out.printf("%4d%15s%15s%15s%15s%15d",
         current.entryNo,current.first," " +
            current.last,current.address,current.city,current.phone);
         System.out.println();
         current = current.next;
      }    
   }//end printOut  
   
   //takes the target node and edits information within it
   public void edit(ListNode target,int selection) {
      Scanner console = new Scanner(System.in);
      ListNode current = head;
      while (current != target) {
         current = current.next;
      }
      switch (selection) {
         case 1:
            System.out.println("Current value: " + current.first);
            System.out.print("Enter the new value: ");
            current.first = console.nextLine();
            break;
         case 2:
            System.out.println("Old value: " + current.last);
            System.out.print("Enter the new value: ");
            current.last = console.nextLine();
            break;
         case 3:
            System.out.println("Old value: " + current.address);
            System.out.print("Enter the new value: ");
            current.address = console.nextLine();
            break;
         case 4:
            System.out.println("Old value: " + current.city);
            System.out.print("Enter the new value: ");
            current.city = console.nextLine();
            break;
         case 5:
            System.out.println("Old value: " + current.phone);
            System.out.print("Enter the new value: ");
            current.phone = console.nextInt();
            console.nextLine();
            break;
         default:
            System.out.println("Not a valid selection");
      }
   
   }//end edit method
   
   
   //fills fields of the entry  
   public void dataFill(ListNode target) {
      Scanner console = new Scanner(System.in);
      
      System.out.println("Enter first name: ");
      target.first = console.nextLine();
      
      System.out.println("Enter last name: ");
      target.last = console.nextLine(); 
          
      System.out.println("Enter Address: ");
      target.address = console.nextLine();
      
      System.out.println("Enter City: ");
      target.city = console.nextLine();
      
      System.out.println("Enter Phone Number: ");
      target.phone= console.nextInt();
      
      console.nextLine();
      
   }//end dataFill
   
   //creates a new node in front of a node
   public ListNode createBefore(ListNode preceding) {
      ListNode newOne = new ListNode(preceding);
      dataFill(newOne);
      return newOne;
   }//end createBefore method

   //inserts a node before a specific selected node
   public void insert(ListNode preceding) {
      if (preceding == head) {
         head = createBefore(preceding);
         size++;
         head.entryNo = 1;
         ListNode current = head;
         while (current.next != null){
            current = current.next;
            current.entryNo++;
         } //end while
      } else {
         ListNode current = head;   
         while (current.next != preceding) {
            current = current.next;
         }
         ListNode newNode = new ListNode(preceding);
         dataFill(newNode);
         newNode.entryNo = preceding.entryNo - 1;
         current.next = newNode;
         size++;
         while (current.next != null) {
            current = current.next;
            current.entryNo++;
         }//end while
      }
   }//end insert method
   
   //takes an int for EntryNo and returns the corresponding ListNode
   public ListNode getNodeAt(int num) {
      ListNode current = head;
      while (current.entryNo != num){
         current = current.next;
      }//end while
      return current;
   }//end getNodeAt method
   
   //returns current size
   public int getSize() {
      return size;
   }//end getsize method   
   
   
   //updates the entryNo field in the list
   //not used.
   public void updateEntries() {
      ListNode current = head;
      int count = 1; 
      while (current != null) {
         current.entryNo = count;
         count++;
      }//end while
   }//end updateEntries method

}//end class
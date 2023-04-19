import java.util.*;
public class Library2
{
    public static void main(String args[])
    {
        System.out.println("Welcome to the Library Management Software!");
        Library2 get = new Library2();
        get.displayMenu();
    }
    public void displayMenu()
    {
        Scanner key = new Scanner(System.in);
        Member2 link1 = new Member2();
        Book2 link2 = new Book2();
        int choice, backCount = 0, error = 0;//backCount - Variable for going back to previous menu
        do
        {
            backCount = 0;
            System.out.printf("\n1)Members \n2)Books \n3)EXIT \n");
            System.out.print("Choose your option number: ");
            choice = key.nextInt();
            System.out.print("\u000C");//Clears up terminal window
            switch(choice)
            {
                case 1:
                    System.out.printf("\n1.Display all records \n2.Insert a record \n3.Delete a record \n4.Search a record \n5.Exit \n");
                    System.out.print("Choose your option number: ");
                    int choice1 = key.nextInt();
                    System.out.print("\u000C");
                    switch(choice1)
                    {
                        case 1:
                            link1.display();
                            backCount = link1.postMenu();
                            System.out.print("\u000C");
                            break;
                        
                        case 2:
                            error = link1.create();
                            if(error != 1)//Exits out of program if there are any errors
                            {
                                backCount = link1.postMenu();
                                System.out.print("\u000C");
                            }
                            break;
                            
                        case 3:
                            backCount = link1.deleteRecord();
                            link1.copyBack();
                            if(backCount != 1 && backCount != 0)
                            {
                                backCount = link1.postMenu();
                            }
                            System.out.print("\u000C");
                            break;
                            
                        case 4:
                            backCount = link1.searchRecord();
                            if(backCount != 1 && backCount != 0)
                            {
                                backCount = link1.postMenu();
                            }
                            System.out.print("\u000C");
                            break;
                            
                        case 5:
                            backCount = 0;
                            break;
                        
                        default:
                            System.out.printf("\nSorry! Wrong option. Restart the program and try again");
                    }
                    break;
                    
                case 2:
                    System.out.printf("\n1.Display all books \n2.Add Book \n3.Remove Book \n4.Search Book(s) \n5.Borrow a book \n6.Return a book \n7.Borrowed Books \n8.Exit \n");
                    System.out.print("Choose your option number: ");
                    choice1 = key.nextInt();
                    System.out.print("\u000C");
                    switch(choice1)
                    {
                        case 1:
                            link2.display();
                            backCount = link2.postMenu();
                            System.out.print("\u000C");
                            break;
                        
                        case 2:
                            error = link2.create();
                            if(error != 1)
                            {
                                backCount = link2.postMenu();
                                System.out.print("\u000C");
                            }
                            break;
                            
                        case 3:
                            backCount = link2.deleteRecord();
                            link2.copyBack(0);
                            if(backCount != 1 && backCount != 0)
                            {
                                backCount = link2.postMenu();
                            }
                            System.out.print("\u000C");
                            break;
                            
                        case 4:
                            backCount = link2.searchRecord();
                            if(backCount != 1 && backCount != 0)
                            {
                                backCount = link2.postMenu();
                            }
                            System.out.print("\u000C");
                            break;
                            
                        case 5:
                            link2.borrowBook();
                            backCount = link2.postMenu();
                            System.out.println("\u000C");
                            break;
                            
                        case 6:
                            link2.returnBook();
                            link2.copyBack(1);
                            backCount = link2.postMenu();
                            System.out.println("\u000C");
                            break;
                            
                        case 7:
                            link2.displayBorrowedBooks();
                            backCount = link2.postMenu();
                            System.out.println("\u000C");
                            break;
                            
                        case 8:
                            backCount = 0;
                            break;
                        
                        default:
                            System.out.printf("\nSorry! Wrong option. Restart the program and try again");
                    }
                    break;
                    
                case 3:
                    backCount = 0;
                    break;
                    
                default:
                    System.out.printf("\nSorry! Wrong option. Restart the program and try again");
            }
        }while(backCount == 1);
        System.out.println("Thank you!\nClick on the cross at the top-right corner to exit");
    }
}

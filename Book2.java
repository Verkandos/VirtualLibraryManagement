import java.util.*;
import java.io.*;
public class Book2
{
    Scanner key1 = new Scanner(System.in);
    Scanner key2 = new Scanner(System.in);
    
    int backCount = 0, copied = 0;
    public int checkNum()
    {
        int bookCount = 0;
        try
        {
            Scanner rd = new Scanner(new File("book2.txt"));
            while(rd.hasNext())
            {
                if(rd.hasNext("BOOK"))
                {
                    rd.next();
                    bookCount = rd.nextInt();
                }
                else
                {
                    rd.next();
                }
            }
            rd.close();
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
        return bookCount;
    }
    public int create()
    {
        int error = 0, count1 = 0, count2 = 0;
        try
        {
            while(count1 == 0)
            {
                count1 = 0;
                count2 = 0;
                FileWriter fw = new FileWriter("book2.txt", true);
                Formatter fm = new Formatter(fw);
                int bookCount = checkNum();
                
                System.out.println("BOOK "+(bookCount+1)+"\r\n");
                fm.format("\r\nBOOK %d \r\n\r\n", (bookCount+1));
                
                System.out.print("Accession_Number: ");
                int book_acc_num = key1.nextInt();
                fm.format("Accession_Number: %d \r\n", book_acc_num);
                
                System.out.print("Title: ");
                String book_title = key2.nextLine();
                fm.format("Title: %s \r\n", book_title);
                
                System.out.print("Author: ");
                String book_author = key2.nextLine();
                fm.format("Author: %s \r\n", book_author);
                
                System.out.print("Price: Rs.");
                float book_price = key1.nextFloat();
                fm.format("Price: Rs.%f \r\n", book_price);
                
                System.out.print("Quantity: ");
                int book_quan = key1.nextInt();
                fm.format("Quantity: %d \r\n", book_quan);
                
                fm.close();
                fw.close();
                
                System.out.print("\nDo you want to insert another record? Yes/No? \nChoose: ");
                while(count2 == 0)
                {
                    String ch = key2.nextLine();
                    if(ch.equalsIgnoreCase("Yes"))
                    {
                        count1 = 0;
                        count2 = 1;
                    }
                    else if(ch.equalsIgnoreCase("No"))
                    {
                        count1 = 1;
                        count2 = 1;
                    }
                    else
                    {
                        System.out.print("Try again. 'Yes' or 'No'. \nChoose: ");
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("There was an error. Restart the program");
            error = 1;
        }
        return error;
    }
    public void display()
    {
        try
        {
            Scanner sf = new Scanner(new File("book2.txt"));
            while(sf.hasNext())
            {
                System.out.println(sf.nextLine());
            }
            sf.close();
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
    }
    public int postMenu()
    {
        backCount = 0;
        System.out.print("\n1.Back to main menu \n2.Exit \nChoose: ");
        int count1 = key1.nextInt();
        switch(count1)
        {
            case 1:
                backCount = 1;
                break;
                
            case 2:
                backCount = 0;
                break;
                
            default:
                System.out.println("\nWrong option");
        }
        return backCount;
    }
    public int searchRecord()
    {
        backCount = -1;
        int count;
        System.out.print("\n1.Search by Accession Number \n2.Search by title \n3.Search by author \n4.Back to main menu \n5.Exit \nChoose your option number: ");
        int choice  = key1.nextInt();
        
        try
        {
            Scanner read2 = new Scanner(new File("book2.txt"));
            Scanner read1 = new Scanner(new File("book2.txt"));
            int pCount = 0, check = 0;
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter Accession Number: ");
                    int id = key1.nextInt();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("BOOK"))
                        {
                            read1.next();
                            read2.next();
                            pCount = read1.nextInt();
                            read2.nextInt();
                        }  
                        else  
                        {
                            read1.nextLine();
                            //read2.next();
                        }
                        if(read1.hasNext("Accession_Number:"))
                        {
                            read1.next();
                            if(read1.nextInt() == id)
                            {
                                System.out.println("\r\nBOOK "+pCount);
                                read2.nextLine();
                                while(read2.hasNext("BOOK") == false)
                                {
                                    System.out.println(read2.nextLine());
                                }
                                check = 1;
                            }
                            else
                            {
                                for(count = 1; count<=7; count++)
                                 {
                                     read2.nextLine();
                                 }
                            }
                        }  
                    }
                    if(check == 0)
                    {
                        System.out.println("No results found");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter title: ");
                    String name = key2.nextLine();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("BOOK"))
                        {
                            read1.next();
                            read2.next();
                            pCount = read1.nextInt();
                            read2.nextInt();
                        }  
                        else  
                        {
                            read1.nextLine();
                            //read2.next();
                        }
                        if(read1.hasNext("Title:"))
                        {
                            read1.next();
                            if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                            {
                                System.out.println("\r\nBOOK "+pCount);
                                read2.nextLine();
                                while(read2.hasNext("BOOK") == false)
                                {
                                    System.out.println(read2.nextLine());
                                }
                                check = 1;
                            }
                            else
                            {
                                 for(count = 1; count<=7; count++)
                                 {
                                     read2.nextLine();
                                 }
                            }
                        }  
                    }
                    if(check == 0)
                    {
                        System.out.println("No results found");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter author: ");
                    String auth = key2.nextLine();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("BOOK"))
                        {
                            read1.next();
                            read2.next();
                            pCount = read1.nextInt();
                            read2.nextInt();
                        }  
                        else  
                        {
                            read1.nextLine();
                            //read2.next();
                        }
                        if(read1.hasNext("Author:"))
                        {
                            read1.next();
                            if(read1.nextLine().equalsIgnoreCase(" "+auth+" "))
                            {
                                System.out.println("\r\nBOOK "+pCount);
                                read2.nextLine();
                                while(read2.hasNext("BOOK") == false)
                                {
                                    System.out.println(read2.nextLine());
                                }
                                check = 1;
                            }
                            else
                            {
                                 for(count = 1; count<=7; count++)
                                 {
                                     read2.nextLine();
                                 }
                            }
                        }
                    }
                    if(check == 0)
                    {
                        System.out.println("No results found");
                    }
                    break;
                    
                case 4:
                    backCount = 1;
                    break;
                    
                case 5:
                    backCount = 0;
                    break;
                    
                default:
                    System.out.println("Wrong option");
            }
            read1.close(); 
            read2.close();
        }
        catch(Exception e)
        {
            
        }
        return backCount;
    }
    public int deleteRecord()
    {
        backCount = -1;
        copied = 0;
        int personCount = 0, count, done = 0, check = 0;
        System.out.print("\n1.Delete by Accession Number \n2.Delete by title \n3.Back to main menu \n4.Exit \nChoose your option number: ");
        int choice  = key1.nextInt();
        
        try
        {
            Scanner read2 = new Scanner(new File("book2.txt"));
            Scanner read1 = new Scanner(new File("book2.txt"));
            FileWriter file = new FileWriter("copyBook2.txt", false);
            Formatter wr = new Formatter(file);
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter Accession Number: ");
                    int id = key1.nextInt();
                    System.out.println();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("BOOK"))
                        {
                            read1.next();
                            read2.next();
                            if(done == 0)
                            {
                                personCount = read1.nextInt();
                            }
                            else
                            {
                                personCount = read1.nextInt() - 1;
                            }
                            read2.nextInt();
                        }  
                        else  
                        {
                            read1.nextLine();
                            //read2.next();
                        }
                        if(read1.hasNext("Accession_Number:"))
                        {
                            read1.next();
                            if(read1.nextInt() == id)
                            {
                                for(count = 1; count<=7; count++)
                                {
                                     read2.nextLine();
                                }
                                done = 1;
                                check = 1;
                            }
                            else
                            {
                                wr.format("\r\nBOOK %d\r\n", personCount);
                                read2.nextLine();
                                while(read2.hasNext("BOOK") == false && read2.hasNextLine())
                                {
                                    wr.format("%s\r\n", read2.nextLine());
                                }
                            }
                        }  
                    }
                    if(check == 0)
                    {
                        System.out.println("No results found");
                    }
                    else
                    {
                        System.out.println("Record deleted successfully");
                    }
                    copied = 1;
                    break;
                    
                case 2:
                    System.out.print("Enter title: ");
                    String name = key2.nextLine();
                    System.out.println();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("BOOK"))
                        {
                            read1.next();
                            read2.next();
                            if(done == 0)
                            {
                                personCount = read1.nextInt();
                            }
                            else
                            {
                                personCount = read1.nextInt() - 1;
                            }
                            read2.nextInt();
                        }  
                        else  
                        {
                            read1.nextLine();
                            //read2.next();
                        }
                        if(read1.hasNext("Title:"))
                        {
                            read1.next();
                            if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                            {
                                for(count = 1; count<=7; count++)
                                {
                                     read2.nextLine();
                                }
                                done = 1;
                                check = 1;
                            }
                            else
                            {
                                wr.format("\r\nBOOK %d\r\n", personCount);
                                read2.nextLine();
                                while(read2.hasNext("BOOK") == false && read2.hasNextLine())
                                {
                                    wr.format("%s\r\n", read2.nextLine());
                                }
                            }
                        }  
                    }
                    if(check == 0)
                    {
                        System.out.println("No results found");
                    }
                    else
                    {
                        System.out.println("Record deleted successfully");
                    }
                    copied = 1;
                    break;
                    
                case 3:
                    backCount = 1;
                    break;
                    
                case 4:
                    backCount = 0;
                    break;
                    
                default:
                    System.out.println("Wrong option");
            }
            read1.close();
            read2.close();
            wr.close();
            file.close();
        }
        catch(Exception e)
        {
            
        }
        return backCount;
    }
    public void copyBack(int poly)
    {
        try
        {
            Scanner rd = new Scanner(new File("copyBook2.txt"));
            FileWriter file;
            if(poly == 1)
            {
               file = new FileWriter("bookBorrow2.txt", false);
               Formatter wr = new Formatter(file);
               while(rd.hasNext())
               {
                    wr.format("%s\r\n", rd.nextLine());
               }
               wr.close();
               file.close();
            }
            else if(copied == 1)
            {
                file = new FileWriter("book2.txt", false);
                Formatter wr = new Formatter(file);
                while(rd.hasNext())
                {
                    wr.format("%s\r\n", rd.nextLine());
                }
                wr.close();
                file.close();
            }
            rd.close();
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
    }
    public void borrowBook()
    {
        backCount = 0;
        int count;
        
        try
        {
            Scanner read2 = new Scanner(new File("book2.txt"));
            Scanner read1 = new Scanner(new File("book2.txt"));
            FileWriter file = new FileWriter("bookBorrow2.txt", true);
            Formatter wr = new Formatter(file);
            
            int pCount = 0, check = 0;
            
            System.out.print("Enter title of the book to be borrowed: ");
            String name = key2.nextLine();
            System.out.println();
            while(read1.hasNext() && read2.hasNext())
            {
                if(read1.hasNext("BOOK"))
                {
                    read1.next();
                    read2.next();
                    pCount = read1.nextInt();
                    read2.nextInt();
                }  
                else  
                {
                    read1.nextLine();
                    //read2.next();
                }
                if(read1.hasNext("Title:"))
                {
                    read1.next();
                    if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                    {
                        wr.format("\r\nBOOK %d\r\n", pCount);
                        read2.nextLine();
                        while(read2.hasNext("BOOK") == false && read2.hasNextLine())
                        {
                            wr.format("%s\r\n", read2.nextLine());
                        }
                        check = 1;
                    }
                    else
                    {
                         for(count = 1; count<=7; count++)
                         {
                             read2.nextLine();
                         }
                    }
                }  
            }
            if(check == 0)
            {
                System.out.println("No results found");
            }
            else
            {
                System.out.println("Kindly return the book within 7 days.");
            }
            read1.close(); 
            read2.close();
            wr.close();
            file.close();
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
    }
    public void returnBook()
    {
        backCount = 0;
        copied = 0;
        int personCount = 0, count, done = 0, check = 0;
        
        try
        {
            Scanner read2 = new Scanner(new File("bookBorrow2.txt"));
            Scanner read1 = new Scanner(new File("bookBorrow2.txt"));
            FileWriter file = new FileWriter("copybook2.txt", false);
            Formatter wr = new Formatter(file);
            
            System.out.print("Enter title of the book to be returned: ");
            String name = key2.nextLine();
            System.out.println();
            while(read1.hasNext() && read2.hasNext())
            {
                if(read1.hasNext("BOOK"))
                {
                    read1.next();
                    read2.next();
                    personCount = read1.nextInt();
                }  
                else  
                {
                    read1.nextLine();
                    //read2.next();
                }
                if(read1.hasNext("Title:"))
                {
                    read1.next();
                    if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                    {
                        for(count = 1; count<=7; count++)
                        {
                             read2.nextLine();
                        }
                        check = 1;
                    }
                    else
                    {
                        wr.format("\r\nBOOK %d\r\n", personCount);
                        read2.nextLine();
                        while(read2.hasNext("BOOK") == false && read2.hasNextLine())
                        {
                            wr.format("%s\r\n", read2.nextLine());
                        }
                    }
                }  
            }
            if(check == 0)
            {
                System.out.println("No results found");
            }
            else
            {
                System.out.println("Thank you!");
            }                   
            
            read1.close();
            read2.close();
            wr.close();
            file.close();
        }
        catch(Exception e)
        {
            
        }
    }
    public void displayBorrowedBooks()
    {
        try
        {
            Scanner sf = new Scanner(new File("bookBorrow2.txt"));
            while(sf.hasNext())
            {
                System.out.println(sf.nextLine());
            }
            sf.close();
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
    }
}
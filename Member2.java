import java.util.*;
import java.io.*;
public class Member2
{
    Scanner key1 = new Scanner(System.in);
    Scanner key2 = new Scanner(System.in);
    
    int backCount = 0, copied = 0;
    public int checkNum()
    {
        int personCount = 0;
        try
        {
            Scanner rd = new Scanner(new File("member2.txt"));
            while(rd.hasNext())
            {
                if(rd.hasNext("MEMBER"))
                {
                    rd.next();
                    personCount = rd.nextInt();
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
            System.out.println("File not created yet");
        }
        return personCount;
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
                FileWriter fw = new FileWriter("member2.txt", true);
                Formatter fm = new Formatter(fw);
                int personCount = checkNum();
                
                System.out.println("MEMBER "+(personCount+1)+"\r\n");
                fm.format("\r\nMEMBER %d \r\n\r\n", (personCount+1));
                
                System.out.print("ID: ");
                int mem_ID = key1.nextInt();
                fm.format("ID: %d \r\n", mem_ID);
                
                System.out.print("Name: ");
                String mem_name = key2.nextLine();
                fm.format("Name: %s \r\n", mem_name);
                
                System.out.print("Address: ");
                String mem_add = key2.nextLine();
                fm.format("Address: %s \r\n", mem_add);
                
                System.out.print("Phone Number: ");
                String mem_phone = key2.nextLine();
                fm.format("Mobile Number: %s \r\n", mem_phone);
                
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
            Scanner sf = new Scanner(new File("member2.txt"));
            while(sf.hasNext())
            {
                System.out.println(sf.nextLine());
            }
            sf.close();
        }
        catch(Exception e)
        {
            System.out.println("No records here");
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
        System.out.print("\n1.Search by ID \n2.Search by name \n3.Back to main menu \n4.Exit \nChoose your option number: ");
        int choice  = key1.nextInt();
        
        try
        {
            Scanner read2 = new Scanner(new File("member2.txt"));
            Scanner read1 = new Scanner(new File("member2.txt"));
            int pCount = 0, check = 0;
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter ID: ");
                    int id = key1.nextInt();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("MEMBER"))
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
                        if(read1.hasNext("ID:"))
                        {
                            read1.next();
                            if(read1.nextInt() == id)
                            {
                                System.out.println("\r\nMEMBER "+pCount);
                                read2.nextLine();
                                while(read2.hasNext("MEMBER") == false && read2.hasNextLine())
                                {
                                    System.out.println(read2.nextLine());
                                }
                                check = 1;
                            }
                            else
                            {
                                for(count = 1; count<=6; count++)
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
                    System.out.print("Enter name: ");
                    String name = key2.nextLine();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("MEMBER"))
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
                        if(read1.hasNext("Name:"))
                        {
                            read1.next();
                            if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                            {
                                System.out.println("\r\nMEMBER "+pCount);
                                read2.nextLine();
                                while(read2.hasNext("MEMBER") == false && read2.hasNextLine())
                                {
                                    System.out.println(read2.nextLine());
                                }
                                check = 1;
                            }
                            else
                            {
                                 for(count = 1; count<=6; count++)
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
        }
        catch(Exception e)
        {
            System.out.println("\nNothing here");
        }
        return backCount;
    }
    public int deleteRecord()
    {
        backCount = -1;
        copied = 0;
        int personCount = 0, count, done = 0, check = 0;
        System.out.print("\n1.Delete by ID \n2.Delete by name \n3.Back to main menu \n4.Exit \nChoose your option number: ");
        int choice  = key1.nextInt();
        
        try
        {
            Scanner read2 = new Scanner(new File("member2.txt"));
            Scanner read1 = new Scanner(new File("member2.txt"));
            FileWriter file = new FileWriter("copyMem2.txt", false);
            Formatter wr = new Formatter(file);
            
            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter ID: ");
                    int id = key1.nextInt();
                    System.out.println();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("MEMBER"))
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
                        if(read1.hasNext("ID:"))
                        {
                            read1.next();
                            if(read1.nextInt() == id)
                            {
                                for(count = 1; count<=6; count++)
                                {
                                     read2.nextLine();
                                }
                                done = 1;
                                check = 1;
                            }
                            else
                            {
                                wr.format("\r\nMEMBER %d\r\n", personCount);
                                read2.nextLine();
                                while(read2.hasNext("MEMBER") == false && read2.hasNextLine())
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
                    System.out.print("Enter name: ");
                    String name = key2.nextLine();
                    System.out.println();
                    while(read1.hasNext() && read2.hasNext())
                    {
                        if(read1.hasNext("MEMBER"))
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
                        if(read1.hasNext("Name:"))
                        {
                            read1.next();
                            if(read1.nextLine().equalsIgnoreCase(" "+name+" "))
                            {
                                for(count = 1; count<=6; count++)
                                {
                                     read2.nextLine();
                                }
                                done = 1;
                                check = 1;
                            }
                            else
                            {
                                wr.format("\r\nMEMBER %d\r\n", personCount);
                                read2.nextLine();
                                while(read2.hasNext("MEMBER") == false && read2.hasNextLine())
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
            System.out.println("Nothing here");
        }
        return backCount;
    }
    public void copyBack()
    {
        try
        {
            if(copied == 1)
            {
                Scanner rd = new Scanner(new File("copyMem2.txt"));
                FileWriter file = new FileWriter("member2.txt", false);
                Formatter wr = new Formatter(file);
                
                while(rd.hasNext())
                {
                    wr.format("%s\r\n", rd.nextLine());
                }
                rd.close();
                wr.close();
                file.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Nothing here");
        }
    }
}
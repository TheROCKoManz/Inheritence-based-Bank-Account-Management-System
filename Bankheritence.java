import java.io.DataInputStream;
import java.io.IOException;

public class Bankheritence
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream inp = new DataInputStream(System.in);
        Account acc = new Account("SBI","SBIN01542",69420.00);
        acc.display();

        while(true)
        {
            System.out.println("\n");
            System.out.println("1. Deposit.");
            System.out.println("2. Withdraw.");
            System.out.println("0. Logout.");
            System.out.print("\nEnter Choice: ");
            int ch = Integer.parseInt(inp.readLine());

            switch (ch) {
                case 1: {
                    acc.deposit();
                    acc.display();
                    break;
                }

                case 2: {
                    acc.withdraw();
                    acc.display();
                    break;
                }

                case 0:{
                    System.exit(0);
                }
                default:
                {
                    System.out.println("\n\nTry Again>..");
                }
            }
        }
    }
}
class Bank
{
    String Name;
    String Account_No;
    double p;


    Bank(String Name, String Account_No, double p)
    {
        this.Name = Name;
        this.Account_No = Account_No;
        this.p = p;
    }
    void display()
    {
        System.out.println("\n\nBank Name: " + Name);
        System.out.println("Account No: "+Account_No);
        System.out.println("Principal: "+p);
    }
};

class Account extends Bank
{
    double amt;
    boolean transac;
    Account(String Name, String Account_No, double p)
    {
        super(Name, Account_No, p);
        amt=0;
        transac=true;
    }

    void deposit() throws IOException
    {
        DataInputStream inp = new DataInputStream(System.in);
        System.out.print("\n\nEnter amount to deposit: ");
        amt = Double.parseDouble(inp.readLine());
        p+=amt;
        transac = true;
    }

    void withdraw() throws IOException
    {
        DataInputStream inp = new DataInputStream(System.in);
        System.out.print("\n\nEnter amount to withdraw: ");
        amt = Double.parseDouble(inp.readLine());
        if(amt>p)
        {
            System.out.println("\nInsufficient Balance\n\n");
            amt=0;
        }
        else
        {
            p -= amt;
            if (p < 500)
                p -= ((500 - p) / 10);
        }

        transac = false;
    }

    @Override void display()
    {
        super.display();
        char sign;
        if(transac)
            sign = '+';
        else
            sign = '-';

        System.out.println("Last successful transaction Amount: "+sign+amt);
    }
};

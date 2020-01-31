package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action; int check = 0;
        Magic machine = new Magic();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        while(check == 0)
        {
            action = scanner.nextLine();
            check = machine.condition(action);

        }


    }
}

class Magic
{
    static int water = 400, milk = 540, beans = 120, cups = 9 , money = 550;
    int check = 0;
    String[] myArray = new String[1] ;
    int filling_check = 0 , overdose;
    public int condition(String move)
    {
        move = move.toUpperCase();
        if((move.equals("TAKE"))||(move.equals("REMAINING"))||(move.equals("EXIT")))
        {
            switch (move)
            {
                case "TAKE":
                    take();
                    break;

                case "REMAINING":
                    remain();
                    break;

                case "EXIT":
                    exit();
                    break;
            }

        }else if((move.equals("BUY"))||(move.equals("FILL")))
        {
            switch (move)
            {
                case "BUY":
                    myArray[0] = move;
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    break;


                case "FILL":
                    myArray[0] = move;
                    System.out.println("Write how many ml of water do you want to add:");
                    break;

                default:
                    break;
            }

        }else
        {
            switch (myArray[0])
            {
                case "BUY":
                    switch (move)
                    {
                        case "1":
                            buy(move);
                            break;
                        case "2":
                            buy(move);
                            break;
                        case "3":
                            buy(move);
                            break;

                        default:
                            break;
                    }
                    break;

                case "FILL":
                    overdose = Integer.parseInt(move);
                    switch (filling_check)
                    {
                        case 0:
                            water += overdose;
                            System.out.println("Write how many ml of milk do you want to add:");
                            break;
                        case 1:
                            milk += overdose;
                            System.out.println("Write how many grams of coffee beans do you want to add:");
                            break;
                        case 2:
                            beans += overdose;
                            System.out.println("Write how many disposable cups of coffee do you want to add:");
                            break;
                        case 3:
                            cups += overdose;
                            break;

                    }
                    filling_check++;
                    if(filling_check == 4)
                    {
                        filling_check = 0;
                        System.out.println("Write action (buy, fill, take, remaining, exit):");
                    }

            }
        }

        return check;
    }

    public void buy(String type)
    {
        switch (type){
            case "1":
                if(water < 250)
                {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(beans < 16)
                {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }else if (cups == 0)
                {
                    System.out.println("Sorry, not enough coffee cups!");
                } else {
                    water -= 250; beans -= 16; money +=4; cups -=1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if(water < 350)
                {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(milk < 75)
                {
                    System.out.println("Sorry, not enough milk!");
                    break;}
                else if(beans < 20)
                {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }else if (cups == 0)
                {
                    System.out.println("Sorry, not enough coffee cups!");
                }else
                {
                    water -= 350; milk -= 75; beans -= 20; money +=7; cups -=1;
                    System.out.println("I have enough resources, making you a coffee!");

                }
                break;
            case "3":
                if(water < 200)
                {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(milk < 100)
                {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }
                else if(beans < 12)
                {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }else if (cups == 0)
                {
                    System.out.println("Sorry, not enough coffee cups!");
                }else {
                    water -= 200; milk -= 100; beans -= 12; money +=6; cups -=1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;

            case "back":
            {
                break;
            }


        }
        System.out.println("Write action (buy, fill, take, remaining, exit):");

    }
    public void remain()
    {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
    public void take() {
        System.out.println("I gave you $" + money);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        money = 0;
    }

    public void exit()
    {
        this.check = 1;

    }

}

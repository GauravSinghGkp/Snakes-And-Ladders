package Challenge;
import java.util.Random;
import java.util.Scanner;

public class SnakesAndLadders {
    public static int snake(int num){
        if (num == 17){
            return 7;
        }
        if (num == 60){
            return 18;
        }
        if (num == 68){
            return 49;
        }
        if (num == 87){
            return 24;
        }
        if (num == 93){
            return 73;
        }
        if (num == 99){
            return 46;
        }
        return num;
    }
    public static int ladder(int num){
        if (num == 4){
            return 14;
        }
        if (num == 9){
            return 31;
        }
        if (num == 20){
            return 38;
        }
        if (num == 29){
            return 84;
        }
        if (num == 40){
            return 59;
        }
        if (num == 63){
            return 81;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int num = 0;
        int computer = 0;
        int user = 0;
        int computerPosition = 0;
        int userPosition = 0;

        int board[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                num++;
                board[i][j] = num;
            }
        }
        System.out.println("Snake 1 : 17 to 7     Ladder 1 : 4  to 14");
        System.out.println("Snake 2 : 60 to 18    Ladder 2 : 9  to 31");
        System.out.println("Snake 3 : 68 to 49    Ladder 3 : 20 to 38");
        System.out.println("Snake 4 : 87 to 24    Ladder 4 : 29 to 24");
        System.out.println("Snake 5 : 93 to 73    Ladder 5 : 40 to 59");
        System.out.println("Snake 6 : 99 to 46    Ladder 6 : 63 to 81\n");

        for (int i = 9; i >= 0; i--) {
            if (i==1 || i==3 || i==5 || i==7 || i==9){
                for (int j = 9; j >= 0; j--) {
                    if (board[i][j]<=9){
                        System.out.print("0"+board[i][j]+" ");
                    } else {
                        System.out.print(board[i][j]+" ");
                    }
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    if (board[i][j]<=9){
                        System.out.print("0"+board[i][j]+" ");
                    } else {
                        System.out.print(board[i][j]+" ");
                    }
                }
            }
            System.out.println("");
        }
        Boolean home = true;
        while (home){
            if (computerPosition>=100){
                home = false;
            }
            if (userPosition>=100){
                home = false;
            }
            if (home){
                System.out.print("\nYour Turn enter 1 to roll : ");
                int userRoll = sc.nextInt();
                if (userRoll==1){
                    user = random.nextInt(1,6);
                }
                computer = random.nextInt(1,6);
                userPosition += user;
                computerPosition +=computer;
                System.out.println("\nUser : "+user);
                System.out.println("Computer : "+computer+"\n");
                for (int i = 9; i >= 0; i--) {
                    if (i==1 || i==3 || i==5 || i==7 || i==9){
                        for (int j = 9; j >= 0; j--) {
                            userPosition = snake(userPosition);
                            userPosition = ladder(userPosition);
                            computerPosition = snake(computerPosition);
                            computerPosition = ladder(computerPosition);
                            if (board[i][j]<=9){
                                if (userPosition==board[i][j]){
                                    System.out.print("(A)");
                                } else {
                                    System.out.print("0"+board[i][j]+" ");
                                }
                                if (computerPosition==board[i][j]){
                                    System.out.print("(B)");
                                } else {
                                    System.out.print("0"+board[i][j]+" ");
                                }
                            } else {
                                if (userPosition==board[i][j]){
                                    System.out.print("(A)");
                                } else {
                                    System.out.print(board[i][j]+" ");
                                }
                                if (computerPosition==board[i][j]){
                                    System.out.print("(B)");
                                }
                            }
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            if (board[i][j]<=9){
                                if (userPosition==board[i][j]){
                                    System.out.print("(A)");
                                }
                                if (computerPosition==board[i][j]){
                                    System.out.print("(B)");
                                }
                                System.out.print("0"+board[i][j]+" ");
                            } else {
                                if (userPosition==board[i][j]){
                                    System.out.print("(A)");
                                }
                                if (computerPosition==board[i][j]){
                                    System.out.print("(B)");
                                }
                                System.out.print(board[i][j]+" ");
                            }
                        }
                    }
                    System.out.println("");
                }
            } else {
                if (userPosition>=100){
                    System.out.println("You Win");
                } else {
                    System.out.println("Computer Win");
                }
            }
            System.out.println("\nUser Current Position : "+userPosition);
            System.out.println("Computer Current Position : "+computerPosition+"\n");
        }
    }
}

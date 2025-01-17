import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NGuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎来到新猜数字游戏！");
        while(true){
            ArrayList<Integer> answers = new ArrayList<>();
            while(answers.size() < 4) {
                int answer = (int)(Math.random() * 10);
                if(!answers.contains(answer)){
                    answers.add(answer);
                }
            }
            while(true){
                System.out.println("请输入4个0-9之间不重复的整数:");
                ArrayList<Integer> guesses = new ArrayList<>();
                while(guesses.size() < 4) {
                    int guess;
                    try{
                        guess = scanner.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("请输入数字！");
                        scanner.next();
                        continue;
                    }
                    if(guess < 0 || guess > 9){
                        System.out.println("请输入0-9之间的整数！");
                        continue;
                    }
                    if(!guesses.contains(guess)){
                        guesses.add(guess);
                    }else {
                        System.out.println("数字已经存在！");
                    }
                }

                int a = 0;
                for(int i = 0; i < 4; i++){
                    if(answers.get(i) == guesses.get(i)){
                        a = a + 1;
                    }
                }

                int b = 0;
                for(int i = 0; i < 4; i++){
                    if(answers.contains(guesses.get(i)) && answers.get(i) != guesses.get(i)){
                        b = b + 1;
                    }
                }

                System.out.println(a+"A"+b+"B");
                if ( a == 4 && b == 0){
                    System.out.println("恭喜你！猜对啦！");
                    break;
                }
            }
            System.out.println("再玩儿一次吗？（y/n）");
            String again = scanner.next();
            if(!again.equalsIgnoreCase("y")){
                break;
            }
        }


    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BaseBall {

    private static List<String> randomNumbers = new ArrayList<>();


    public void makeRandomNumber() {
        resetNumbers();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(String.valueOf(random.nextInt(9)));
        }
    }

    public void resetNumbers() {
        randomNumbers.clear();
    }

    public boolean checkNumber(int number) {

        String[] inputs = String.valueOf(number).split("");

        int strike = checkStrike(inputs);
        int ball = checkBall(inputs);

        return IsCorrect(strike,ball);

    }

    public boolean IsCorrect(int strike, int ball) {
        if (strike == 3) {
            return true;
        }
        if (ball == 3) {
            System.out.println("낫싱");
            return false;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(String.format("%d 볼 %d 스트라이크",ball,strike));
            return false;
        }
        if (strike == 0) {
            System.out.println(String.format("%d 볼",ball));
            return false;
        }
        System.out.println(String.format("%d 스트라이크",strike));
        return false;
    }

    public int checkStrike(String[] inputs) {
        int strike =0;
        for (int i = 0; i < 3; i++) {
            if (inputs[i].equals(randomNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(String[] inputs) {
        int ball =0;

        for (int i = 0; i < 3; i++) {
            for (int j = i; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (inputs[i].equals(randomNumbers.get(j))) {
                    ball++;
                }
            }
        }
        return ball;
    }

    public static void main(String[] args) {

        BaseBall baseBall = new BaseBall();
        Scanner sc = new Scanner(System.in);
        boolean isQuit =false;
        boolean init = false;

        while (!isQuit) {

            if (!init) {
                baseBall.makeRandomNumber();
                init =true;
            }
            System.out.println("숫자를 입력해주세요 : ");
            int input = sc.nextInt();
            boolean correct =baseBall.checkNumber(input);
            if (correct) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int endNum = sc.nextInt();
                if (endNum == 2) {
                    isQuit=true;
                }
                init =false;
            }
        }

    }
}

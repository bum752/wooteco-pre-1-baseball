import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BaseballGame {

    private List<Integer> computerNumbers;

    public static BaseballGame startGame() {
        return new BaseballGame();
    }

    private BaseballGame() {
        this.computerNumbers = generateThreeIntegerList();
    }

    public List<Integer> generateThreeIntegerList() {
        Random random = new Random();
        List<Integer> randomIntegerList = new ArrayList<>();
        while (randomIntegerList.size() < 3) {
            int randomInt = random.nextInt(8) + 1;
            addListIfNotContainsNumber(randomIntegerList, randomInt);
        }
        return randomIntegerList;
    }

    public void addListIfNotContainsNumber(List<Integer> integerList, int number) {
        if (!integerList.contains(number)) {
            integerList.add(number);
        }
    }

    public int convertIntegerListToInt(List<Integer> integerList) {
        return Integer.parseInt(
                integerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining())
        );
    }

}

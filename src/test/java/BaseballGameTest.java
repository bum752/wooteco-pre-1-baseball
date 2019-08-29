import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

// 숫자야구게임 - 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임
//
// 1. 컴퓨터는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 만든다.
// 2. 사용자는 3자리의 숫자를 입력하고, 컴퓨터의 숫자와 비교하여 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 포볼(낫싱)을 출력해준다.
// 3. 사용자가 숫자를 맞출때까지 해당 기능을 반복한다.
// 4. 사용자가 숫자를 맞췄을 시 게임을 다시 시작하거나, 완전히 종료할 수 있다.
public class BaseballGameTest {

    private final static BaseballGame baseballGame = BaseballGame.startGame();

    @Test
    public void 서로_다른_수_3개_만들기() {
        List<Integer> randomIntegerList = baseballGame.generateThreeIntegerList();

        Assertions.assertThat(randomIntegerList).hasSize(3);
        Assertions.assertThat(randomIntegerList.get(0)).isNotEqualTo(randomIntegerList.get(1));
        Assertions.assertThat(randomIntegerList.get(1)).isNotEqualTo(randomIntegerList.get(2));
        Assertions.assertThat(randomIntegerList.get(2)).isNotEqualTo(randomIntegerList.get(0));
    }

    @Test
    public void 숫자_리스트를_숫자로_만들기() {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        int number = baseballGame.convertIntegerListToInt(integerList);

        Assertions.assertThat(number).isBetween(123, 987);
    }

}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallUtilsTest {

    @Test
    @DisplayName("1~9 공 숫자 검증")
    void IsValidNumber() {
        boolean result = BaseBallUtils.isValid(9);
        assertThat(result).isTrue();

    }
}

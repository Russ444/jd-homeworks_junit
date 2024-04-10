import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {
    public PasswordChecker passwordChecker;

    @BeforeEach
    public void setUp() {
        passwordChecker = new PasswordChecker();
    }

    // Проверяем, что метод verify корректно обрабатывает правильный пароль
    @Test
    public void testVerifyValidPasswordSuccess() {
        // given:
        passwordChecker.setMinLength(6);
        passwordChecker.setMaxRepeats(2);
        String password = "AbCdEf";

        // when:
        boolean result = passwordChecker.verify(password);

        // then:
        Assertions.assertTrue(result);
    }

    // Проверяем, что метод verify возвращает false для пароля, который слишком короткий.
    @Test
    public void testVerifyPasswordTooShortFail() {
        // given:
        passwordChecker.setMinLength(8);
        passwordChecker.setMaxRepeats(2);
        String password = "abc123";

        // when:
        boolean result = passwordChecker.verify(password);

        // then:
        Assertions.assertFalse(result);
    }

    //Проверяем, что метод verify возвращает false для пароля, содержащего слишком много повторяющихся символов.
    @Test
    public void testVerifyPasswordContainsExcessiveRepeatsFail() {
        // given:
        passwordChecker.setMinLength(6);
        passwordChecker.setMaxRepeats(2);
        String password = "aabbcc";

        // when:
        boolean result = passwordChecker.verify(password);

        // then:
        Assertions.assertTrue(result);
    }

    // Проверяем, что метод корректно отработал пустую строку
    @Test
    public void testVerify_emptyPassword_fail() {
        // given:
        passwordChecker.setMinLength(6);
        passwordChecker.setMaxRepeats(2);
        String password = "";

        // when:
        boolean result = passwordChecker.verify(password);

        // then:
        Assertions.assertFalse(result);
    }

}

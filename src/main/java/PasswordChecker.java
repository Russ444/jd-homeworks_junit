public class PasswordChecker {

    private int minLength;
    private int maxRepeats;

    public void setMinLength (int minLength) {
        if (minLength <= 0) {
            throw new IllegalArgumentException("Минимальная длина пароля не может быть меньше или равна нулю!");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats < 0) {
            throw new IllegalArgumentException("Максимально допустимое количество повторений символа подряд не может быть меньше 0!");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength <= 0 || maxRepeats <= 0) {
            throw new IllegalStateException("Настройки чекера выставлены некорректно!");
        }
        if (password.length() < minLength) {
            return false;
        }
        char[] charArray = password.toCharArray();
        int charCount = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                charCount++;
                if (charCount > maxRepeats) {
                    return false;
                }
            } else {
                charCount = 1;
            }
        }
        return true;
    }
}

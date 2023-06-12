package data;

import lombok.Value;

public class DataGenerator {
    private DataGenerator() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getValidInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getInvalidInfo(AuthInfo original) {
        return new AuthInfo("kolya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardNumber {
        private String cardNumber;
    }

    public static CardNumber getFirstCardNumber() {
        return new CardNumber( "5559 0000 0000 0001" );
    }

    public static CardNumber getSecondCardNumber() {
        return new CardNumber( "5559 0000 0000 0002" );
    }
}

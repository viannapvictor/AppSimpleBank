package br.edu.infnet.AppSimpleBank.domain.user;

public enum UserTypeEnum {
    CLIENT ("Cliente"),
    MERCHANT ("Lojista");

    private final String userType;
    UserTypeEnum(String userType) {
        this.userType = userType;
    }

    public String getUserType () {
        return userType;
    }

    @Override
    public String toString() {
        return getUserType();
    }
}

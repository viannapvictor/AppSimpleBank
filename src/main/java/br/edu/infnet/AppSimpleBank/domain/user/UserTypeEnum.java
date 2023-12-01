package br.edu.infnet.AppSimpleBank.domain.user;

import lombok.Getter;

@Getter
public enum UserTypeEnum {
    CLIENT ("Cliente"),
    MERCHANT ("Lojista");

    private final String userType;
    UserTypeEnum(String userType) {
        this.userType = userType;
    }
    @Override
    public String toString() {
        return getUserType();
    }
}

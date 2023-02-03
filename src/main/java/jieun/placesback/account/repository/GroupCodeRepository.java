package jieun.placesback.account.repository;

import org.springframework.stereotype.Repository;

@Repository
public class GroupCodeRepository {
    public Boolean isUsedCode(String code) {

        return false;
    }
}

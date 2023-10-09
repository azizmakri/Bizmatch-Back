package com.esprit.bizmatch.repositories;

import com.esprit.bizmatch.persistence.entity.UserMail;

public interface IUserEmailRepository {
    public void sendCodeByMail(UserMail mail);
}

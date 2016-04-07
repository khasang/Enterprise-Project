package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.SuperUser;

public interface SuperUserDao {
    SuperUser findByLogin(String login);
}

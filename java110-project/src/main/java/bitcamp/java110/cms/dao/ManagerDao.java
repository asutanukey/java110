package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.dao.impl.DuplicationDaoException;
import bitcamp.java110.cms.dao.impl.MandatoryValueDaoException;
import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    int insert(Manager manager)
            throws DuplicationDaoException, MandatoryValueDaoException;
    List<Manager> findAll();
    Manager findByEmail(String email);
    int delete(String email);
}

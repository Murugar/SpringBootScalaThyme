package com.iqmsoft.service

import com.iqmsoft.dao.UserDao
import com.iqmsoft.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import collection.JavaConverters._

@Service
@Transactional
class UserService {
  @Autowired var userDao: UserDao = _

  def getAll: Iterable[User] = userDao.findAll.asScala

  def getUserList(page:Pageable) :  Iterable[User] = userDao.findAll(page).asScala

  def getUserByUsername(username: String): User = userDao.getUserByUsername(username)


}

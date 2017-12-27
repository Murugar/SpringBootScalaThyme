package com.iqmsoft.dao

import com.iqmsoft.model.User
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
trait UserDao extends JpaRepository[User, java.lang.Long]   {
  def getUserByUsername(username: String): User
}

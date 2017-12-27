package com.iqmsoft.controller

import java.util

import com.iqmsoft.WordUtils
import com.iqmsoft.model.User
import com.iqmsoft.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView

import collection.JavaConverters._



@RestController
@EnableAutoConfiguration
class HelloController {

  @Autowired var userService: UserService = _
  val logger = LoggerFactory.getLogger(classOf[HelloController])

  @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  @ResponseBody
  def randomLong( @PageableDefault(value=20,page=0)  page :Pageable ): ModelAndView = {
    val userList: java.util.Collection[User] = userService.getAll.asJavaCollection
    val map = Map[String,java.util.Collection[User]]("userList"-> userList)
    new ModelAndView("index",map.asJava)

  }

   
  @RequestMapping(value = Array("/hello"), method = Array(RequestMethod.GET))
  @ResponseBody
  def initial = {
    Map[String, String]("Hello" -> "world")
  }
  
  
  @RequestMapping(value = Array("/welcome"), method = Array(RequestMethod.GET))
  @ResponseBody
  def hello = {
    Map[String, String]("Hello" -> "world")
  }


}

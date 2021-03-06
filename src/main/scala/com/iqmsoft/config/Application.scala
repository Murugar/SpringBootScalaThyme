package com.iqmsoft.config

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@Configuration
@EnableAutoConfiguration
@ComponentScan(value = Array("com.iqmsoft"))
@EntityScan(value = Array("com.iqmsoft.model"))
@EnableJpaRepositories(value = Array("com.iqmsoft.dao"))
class Application extends SpringBootServletInitializer {
  override def configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = builder.sources(classOf[Application])

}

object Application extends App {
  SpringApplication.run(classOf[Application], args: _*)
}
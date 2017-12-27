package com.iqmsoft.config

import java.nio.charset.Charset
import java.util
import javax.servlet.Filter

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.core.annotation.Order
import org.springframework.http.MediaType
import org.springframework.http.converter.{StringHttpMessageConverter, HttpMessageConverter}
import org.springframework.http.converter.json.{Jackson2ObjectMapperBuilder, MappingJackson2HttpMessageConverter}
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.{ViewResolver, DispatcherServlet}
import org.springframework.web.servlet.config.annotation._
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver


@Configuration
@EnableWebMvc
class WebMvcConfiguration extends WebMvcConfigurerAdapter{
  val CLASSPATH_RESOURCE_LOCATIONS = Array("classpath:/META-INF/resources/", "classpath:/resources/",
    "classpath:/static/", "classpath:/public/")

  override def configureMessageConverters(converters: util.List[HttpMessageConverter[_]]): Unit = {
    converters.add(mappingJackson2HttpMessageConverter)

  }

  override def configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer): Unit = configurer.enable()






  @Bean def mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter ={


    val converter: MappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    converter.setObjectMapper(mapper)
        val lists =   new util.ArrayList[MediaType]()
        lists.add(new MediaType("text", "html", Charset.forName("UTF-8")))
        lists.add(new MediaType("text", "plain", Charset.forName("UTF-8")))
        lists.add(new MediaType("application", "json", Charset.forName("UTF-8")))
    converter.setSupportedMediaTypes(lists)
    converter
  }

  @Bean def dispatcherServlet:DispatcherServlet = new DispatcherServlet()

  @Bean def characterEncodingFilter:Filter = {
    val characterEncodingFilter = new CharacterEncodingFilter()
    characterEncodingFilter.setEncoding("UTF-8")
    characterEncodingFilter.setForceEncoding(true)
    characterEncodingFilter
 }
}

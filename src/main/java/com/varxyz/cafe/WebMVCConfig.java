package com.varxyz.cafe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//WebMvcConfigurer가 interface임에도 불구하고 아무것도 채우지 않아도 에러가 뜨지 않는다 --> 여기엔 이야기가 담겨있음
//    ==>사용하지 않는 것들을 다 구현해야하기에 많은 에러사항이 있었음  ==> 그래서 아에 처음부터 null값으로 해두고 연결해서 사용할 것만 오버라이딩해서 사용 , 이를 Adapter라고 부른다.
//웹 프로젝트 할 시 필요한 configuration파일 단 하나를 지정해놓는것 ( 사실 여러개로 쪼개놔도 상관없지만 원칙적으로는 프로젝트당 하나의 config만 있으면 된다 ), 설정파일
//가장 기본적인 형태
@Configuration
@EnableWebMvc  //웹으로 들어갈거라 달아줌, 스프링 MVC 설정에 대한 기본 구성 제공
@ComponentScan(basePackages= "com.varxyz.cafe")
public class WebMVCConfig implements WebMvcConfigurer{
	
	
	/*
	 * DispatcherServlet의 매핑 경로를 "/"로 주었을 때, JSP/HTML/CSS 등을 바르게 처리하도록 하는 역할.
	 * xml의 <mvc:default-servlet-handler> 를 대체함
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
	/*
	 * 컨트롤러의 처리 결과를 jsp로 표시하기 위한 설정  ==> 컨트롤러를 통해서만 jsp연결이 가능하게 해둔것, jsp로 바로 접속은 따로 설정은 가능하긴 함
	 * 화면에 보이는것 조차, 모든게 컨트롤러 중심으로 돌아가게 하겠다.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	
	
	/*
	 * src/main/webapp/resources 위치의 정적 리소스를 설
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
}

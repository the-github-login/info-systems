package ru.kpfu.legalaid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.validation.Validator;
import java.nio.charset.Charset;

/**
 * Created by Rail on 17.05.2015.
 */
@Configuration
@ComponentScan("ru.kpfu.legalaid")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("access_denied");
        registry.addViewController("/about").setViewName("static/about");
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

  /*  @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(publishingHouseGenericConverter());
        formatterRegistry.addConverter(userAuthorityGenericConverter());
    }

    @Bean
    public StringToEntityConverter publishingHouseGenericConverter(){
        return new StringToEntityConverter(PublishingHouse.class);
    }
    @Bean
    public StringToEntityConverter userAuthorityGenericConverter(){
        return new StringToEntityConverter(UserAuthority.class);
    }*/
}

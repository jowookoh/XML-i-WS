package sesta.projekat;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }
	@Bean(name = "login")
	public DefaultWsdl11Definition login(XsdSchema loginResponseSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("LoginPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://xml/ws/login");
		wsdl11Definition.setSchema(loginResponseSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema loginResponseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("seme/login.xsd"));
	}


    @Bean(name = "kategorijaSmestaja")
    public DefaultWsdl11Definition kategorijaSmestaja(XsdSchema kategorijaSmestajaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("KategorijSmestajaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/kategorijaSmestaja");
        wsdl11Definition.setSchema(kategorijaSmestajaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema kategorijaSmestajaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/kategorijaSmestaja.xsd"));
    }

    @Bean(name = "usluga")
    public DefaultWsdl11Definition usluga(XsdSchema uslugaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UslugaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/usluga");
        wsdl11Definition.setSchema(uslugaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema uslugaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/usluga.xsd"));
    }

    @Bean(name = "rezervacija")
    public DefaultWsdl11Definition rezervacija(XsdSchema rezervacijaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RezervacijaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/rezervacija");
        wsdl11Definition.setSchema(rezervacijaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema rezervacijaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/rezervacija.xsd"));
    }

    @Bean(name = "poruka")
    public DefaultWsdl11Definition poruka(XsdSchema porukaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PorukaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/poruka");
        wsdl11Definition.setSchema(porukaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema porukaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/poruka.xsd"));
    }
}

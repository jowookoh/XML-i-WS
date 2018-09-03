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

    @Bean(name = "lokacija")
    public DefaultWsdl11Definition lokacija(XsdSchema lokacijaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("LokacijaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/lokacija");
        wsdl11Definition.setSchema(lokacijaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema lokacijaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/lokacija.xsd"));
    }

    @Bean(name = "cena")
    public DefaultWsdl11Definition cena(XsdSchema cenaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CenaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/cena");
        wsdl11Definition.setSchema(cenaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema cenaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/cena.xsd"));
    }

    @Bean(name = "porukaSend")
    public DefaultWsdl11Definition porukaSend(XsdSchema porukaSendResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PorukaSendPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/porukaSend");
        wsdl11Definition.setSchema(porukaSendResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema porukaSendResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/porukaSend.xsd"));
    }

    @Bean(name = "rezervacijaFejk")
    public DefaultWsdl11Definition rezervacijaFejk(XsdSchema rezervacijaFejkResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RezervacijaFejkPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/rezervacijaFejk");
        wsdl11Definition.setSchema(rezervacijaFejkResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema rezervacijaFejkResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/rezervacijaFejk.xsd"));
    }

    @Bean(name = "rezervacijaRealizovana")
    public DefaultWsdl11Definition rezervacijaRealizovana(XsdSchema rezervacijaRealizovanaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RezervacijaRealizovanaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/rezervacijaRealizovana");
        wsdl11Definition.setSchema(rezervacijaRealizovanaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema rezervacijaRealizovanaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/rezervacijaRealizovana.xsd"));
    }

    @Bean(name = "smestaj")
    public DefaultWsdl11Definition smestaj(XsdSchema smestajResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SmestajPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/smestaj");
        wsdl11Definition.setSchema(smestajResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema smestajResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/smestaj.xsd"));
    }

    @Bean(name = "uslugaSmestaj")
    public DefaultWsdl11Definition uslugaSmestaj(XsdSchema uslugaSmestajResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UslugaSmestajPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/uslugaSmestaj");
        wsdl11Definition.setSchema(uslugaSmestajResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema uslugaSmestajResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/uslugaSmestaj.xsd"));
    }

    @Bean(name = "slika")
    public DefaultWsdl11Definition slika(XsdSchema slikaResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SlikaPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://xml/ws/slika");
        wsdl11Definition.setSchema(slikaResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema slikaResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("seme/slika.xsd"));
    }
}

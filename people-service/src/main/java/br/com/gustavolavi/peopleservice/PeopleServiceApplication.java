package br.com.gustavolavi.peopleservice;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class PeopleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleServiceApplication.class, args);
	}
	
	@Bean
	public Docket api() throws IOException, XmlPullParserException {
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model model = reader.read(new FileReader("pom.xml"));
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.gustavolavi.peopleservice.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfo("People Service Api Documentation", "Documentation automatically generated",
						model.getParent().getVersion(), null,
						new Contact("Gustavo Laviola", "gustavolaviola.com.br", "gustavolaviolasanches@gmail.com"),
						null, null));
	}
}

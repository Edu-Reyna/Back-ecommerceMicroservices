package com.MGoldenPearl.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
        info = @Info(title = "API Order Microservice",
                    description = "Our app provides the process for make a buy",
                    version = "1.0.0",
                    contact = @Contact(name = "Eduardo Reyna",
                                email = "eduardo.reyna.g1999@gmail.com"
                    ),
                license = @License(name = "Standard Software Use for Eduardo Reyna",
                                    url = ""
                )
        ),
        servers = {
                @Server(
                        description = "Dev Server",
                        url = "http://localhost:9090"
                )
        }
)
public class SwaggerConfig {
}

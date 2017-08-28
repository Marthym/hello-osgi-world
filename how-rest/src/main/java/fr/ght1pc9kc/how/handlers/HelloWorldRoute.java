package fr.ght1pc9kc.how.handlers;


import fr.ght1pc9kc.how.controller.Route;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.osgi.service.component.annotations.Component;

@Component
public class HelloWorldRoute implements Route {
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello OSGi World");
    }

    @Override
    public String getRoute() {
        return "/hello";
    }
}

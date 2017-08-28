package fr.ght1pc9kc.how;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xnio.Xnio;

@Component(name = "http-server", immediate = true)
public final class HttpServerComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerComponent.class);
    private static final int HTTP_PORT = 8080;

    private Undertow server;

    public HttpServerComponent() {
        this.server = Undertow.builder()
                .addHttpListener(HTTP_PORT, "localhost")
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello OSGi World");
                }).build();
    }

    @Activate
    private void startHttpServer() {
        server.start();
        LOGGER.info("HTTP Server started on port {}", HTTP_PORT);
    }

    @Deactivate
    private void stopHttpServer() {
        server.stop();
        LOGGER.info("HTTP Server stopped !");
    }

    @Reference
    private void waitForXnio(Xnio xnio) {
        LOGGER.debug("XNIO Implementation found: {}", xnio);
    }
}

package fr.ght1pc9kc.how;

import fr.ght1pc9kc.how.controller.Route;
import io.undertow.Undertow;
import io.undertow.server.RoutingHandler;
import org.osgi.service.component.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xnio.Xnio;

@Component(name = "http-server", immediate = true)
public final class HttpServerComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerComponent.class);
    private static final int HTTP_PORT = 8080;

    private final Undertow server;
    private final RoutingHandler routingHandler;

    public HttpServerComponent() {
        routingHandler = new RoutingHandler(true);
        server = Undertow.builder()
                .setHandler(routingHandler)
                .addHttpListener(HTTP_PORT, "localhost")
                .build();
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

    @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    private void addHttpHandler(Route handler) {
        routingHandler.get(handler.getRoute(), handler);
    }

    private void removeHttpHandler(Route handler) {
        routingHandler.remove(handler.getRoute());
    }

    @Reference
    private void waitForXnio(Xnio xnio) {
        LOGGER.debug("XNIO Implementation found: {}", xnio);
    }
}

package fr.ght1pc9kc.how;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(name = "http-server", immediate = true)
public final class HttpServerComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerComponent.class);

    @Activate
    private void startHttpServer() {
        LOGGER.info("HTTP Server started on port {}", 8888);
    }
}

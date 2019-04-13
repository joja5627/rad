package io.rad.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

@Component
public class TomcatPortConfig implements
        WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Value("${tomcat.portRangeStart}")
    private int portRangeStart;

    @Value("${tomcat.portRangeEnd}")
    private int portRangeEnd;

    private int port;

    private int getAvailablePort() {
        return SocketUtils.findAvailableTcpPort(portRangeStart, portRangeEnd);
    }

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        port = getAvailablePort();
        factory.setPort(port);
        factory.setContextPath("");
    }

    public int getPort() {
        return port;
    }
}
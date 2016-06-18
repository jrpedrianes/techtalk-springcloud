package com.jrpedrianes.techtalk.springcloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("tech-talk")
public class ApplicationProperties {

    private String message;
    private GraphiteProperties graphite = new GraphiteProperties();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GraphiteProperties getGraphite() {
        return graphite;
    }

    public static class GraphiteProperties {
        private String host;
        private int port = -1;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}

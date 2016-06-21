package com.jrpedrianes.techtalk.springcloud;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.jrpedrianes.techtalk.springcloud.core.domain.ReservationDomain;
import com.jrpedrianes.techtalk.springcloud.core.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public CommandLineRunner runner(ReservationRepository rr) {
        return args -> {
            rr.deleteAll();

            Arrays.asList("Dr. Rod, Dr. Syer, Juergen, Spencer, Phillip, ALL THE COMMUNITY, Josh".split(","))
                  .forEach(x -> rr.save(new ReservationDomain(x.trim())));
            rr.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public HealthIndicator healthIndicator() {
        return () -> Health.status("I <3 Spring Boot Cloud!").build();
    }

    @ConditionalOnProperty(prefix = "tech-talk.graphite", name = "host", matchIfMissing = true)
    @Bean
    public GraphiteReporter graphiteReporter(MetricRegistry registry) {
        Graphite graphite = new Graphite(applicationProperties.getGraphite().getHost(), applicationProperties.getGraphite().getPort());

        GraphiteReporter reporter = GraphiteReporter.forRegistry(registry)
                .prefixedWith("techtalks")
                .build(graphite);
        reporter.start(2, TimeUnit.SECONDS);
        return reporter;
    }
}

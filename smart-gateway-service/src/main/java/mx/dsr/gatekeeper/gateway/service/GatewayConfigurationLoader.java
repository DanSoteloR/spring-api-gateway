package mx.dsr.gatekeeper.gateway.service;

import mx.dsr.gatekeeper.gateway.client.ManagementApiClient;
import mx.dsr.gatekeeper.gateway.dto.GatewayRoute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GatewayConfigurationLoader implements ApplicationRunner {

    private final ManagementApiClient managementApiClient;

    public GatewayConfigurationLoader(ManagementApiClient managementApiClient) {
        this.managementApiClient = managementApiClient;
    }

    @Override
    public void run(ApplicationArguments arguments) {
        refresh();
    }

    public void refresh() {
        List<GatewayRoute> routes = managementApiClient.fetchActiveRoutes();

        //demo, not actually needed
        for(GatewayRoute route : routes) {
            System.out.println("Route : " + route.getTargetPathPrefix());
        }
    }
}

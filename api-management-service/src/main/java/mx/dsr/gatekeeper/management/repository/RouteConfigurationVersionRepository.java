package mx.dsr.gatekeeper.management.repository;

import mx.dsr.gatekeeper.management.entity.RouteConfigurationVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteConfigurationVersionRepository extends JpaRepository<RouteConfigurationVersion, Long> {

    List<RouteConfigurationVersion> findAllByOrganizationIdAndRouteIdOrderByVersionNumberDesc(Long organizationId,
                                                                                              String routeId);

}

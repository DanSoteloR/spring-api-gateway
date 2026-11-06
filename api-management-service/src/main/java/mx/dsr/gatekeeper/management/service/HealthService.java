package mx.dsr.gatekeeper.management.service;

import lombok.RequiredArgsConstructor;
import mx.dsr.gatekeeper.management.dto.responseDto.HealthResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final JdbcTemplate jdbcTemplate;

    public String getHealth() {
        String databaseStatus = "INACTIVE";

        try {
            Integer res = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (Integer.valueOf(1).equals(res)) {
                databaseStatus = "ACTIVE";
            }
        }
        catch(Exception e) {
            System.out.println("MySQL Health check failed : " + e.getMessage());
        }

        return databaseStatus;
    }
}

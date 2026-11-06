package mx.dsr.gatekeeper.management.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mx.dsr.gatekeeper.management.entity.ManagementUser;

@Getter
@AllArgsConstructor
public class TenantAdminResponse {

    private Long id;
    private Long organizationId;
    private String username;
    private boolean enabled;

    public static TenantAdminResponse from(ManagementUser user) {
        return new TenantAdminResponse(user.getId(), user.getOrganization().getId(), user.getUsername(),
                user.isEnabled());
    }
}

package io.gravitee.oauth2.server.core.spring;

import io.gravitee.oauth2.server.core.AuthorizationServerConfiguration;
import io.gravitee.oauth2.server.core.OAuth2SecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@Configuration
@Import({
        AuthorizationServerConfiguration.class,
        OAuth2SecurityConfiguration.class
})
public class CoreConfiguration {
}

/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.am.gateway.jetty.spring;

import io.gravitee.am.gateway.jetty.JettyConfiguration;
import io.gravitee.am.gateway.jetty.JettyServerFactory;
import io.gravitee.am.gateway.jetty.handler.security.SecurityDomainHandlerCollection;
import io.gravitee.am.gateway.jetty.handler.security.SecurityDomainHandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@Configuration
public class JettyContainerConfiguration {

    @Bean
    public JettyConfiguration jettyConfiguration() {
        return new JettyConfiguration();
    }

    @Bean
    public JettyServerFactory server() {
        return new JettyServerFactory();
    }

    @Bean
    public SecurityDomainHandlerCollection domainHandlerCollection() {
        return new SecurityDomainHandlerCollection();
    }

    @Bean
    public SecurityDomainHandlerFactory domainHandlerFactory() {
        return new SecurityDomainHandlerFactory();
    }
}

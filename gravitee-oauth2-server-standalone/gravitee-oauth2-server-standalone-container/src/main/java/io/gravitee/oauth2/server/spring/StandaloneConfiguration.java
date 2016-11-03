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
package io.gravitee.oauth2.server.spring;

import io.gravitee.common.node.Node;
import io.gravitee.oauth2.server.core.spring.CoreConfiguration;
import io.gravitee.oauth2.server.jetty.JettyConfiguration;
import io.gravitee.oauth2.server.jetty.JettyEmbeddedContainer;
import io.gravitee.oauth2.server.jetty.JettyServerFactory;
import io.gravitee.oauth2.server.node.ServerNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
@Configuration
@Import({PropertiesConfiguration.class, CoreConfiguration.class})
public class StandaloneConfiguration {

    @Bean
    public Node node() {
        return new ServerNode();
    }

    @Bean
    public JettyConfiguration jettyConfiguration() {
        return new JettyConfiguration();
    }

    @Bean
    public JettyServerFactory server() {
        return new JettyServerFactory();
    }

    @Bean
    public JettyEmbeddedContainer container() {
        return new JettyEmbeddedContainer();
    }
}
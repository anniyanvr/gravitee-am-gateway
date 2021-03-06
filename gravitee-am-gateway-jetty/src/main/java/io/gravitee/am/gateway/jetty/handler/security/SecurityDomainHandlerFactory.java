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
package io.gravitee.am.gateway.jetty.handler.security;

import io.gravitee.am.definition.Domain;
import io.gravitee.am.gateway.core.context.Context;
import io.gravitee.am.gateway.core.context.ContextFactoryRegistry;
import io.gravitee.am.gateway.core.context.servlet.ServletContext;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class SecurityDomainHandlerFactory {

    @Autowired
    private ContextFactoryRegistry contextFactoryRegistry;

    public ContextHandler create(Domain domain) {
        Context context = contextFactoryRegistry.create(domain);
        if (context instanceof ServletContext) {
            return new SecurityDomainHandler((ServletContext) context);
        }

        throw new IllegalStateException();
    }
}

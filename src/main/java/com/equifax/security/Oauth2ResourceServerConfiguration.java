package com.equifax.security;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
@Profile("secure")
public class Oauth2ResourceServerConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(Oauth2ResourceServerConfiguration.class);
    private TokenExtractor tokenExtractor = new BearerTokenExtractor();

    @Bean
    @Order(1)
    public ResourceServerConfigurer resourceServerConfigurer() {
        return new ResourceServerConfigurer() {
            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

                //This is used by the oauth2 library as a unique identifier of your microservice.
                // It is used to verify that your service is the intended audience of a given JWT access token.
                resources.resourceId("users");
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {

                //The scopes specified here should begin with your resourceId from above.
//                http.authorizeRequests()
//                    .antMatchers("/country-greeting/v1/*").access("#oauth2.hasScope('equifax_system')")
//                    .and()
//                    .addFilterAfter(new OncePerRequestFilter() {
//
//                        @Override
//                        protected void doFilterInternal(HttpServletRequest request,
//                                                        HttpServletResponse response, FilterChain filterChain)
//                            throws ServletException, IOException {
//                            // Do not allow access to a resource with no token so clear
//                            // the security context in case it is actually an OAuth2Authentication
//                            Authentication authentication = tokenExtractor.extract(request);
//                            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//                            authorities.stream().forEach(a -> LOG.info("Authority: " + ((GrantedAuthority) a).getAuthority()));
//                            if (authentication == null) {
//                                SecurityContextHolder.clearContext();
//                            }
//                            filterChain.doFilter(request, response);
//                        }
//                    }, AbstractPreAuthenticatedProcessingFilter.class)
//                    .requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
//                    .authorizeRequests()
//                    .anyRequest()
//                    .fullyAuthenticated();
//

                http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("ADMIN");
            }

        };
    }


}

package com.example.immoluxe.Config;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeyCloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt source) {

        return new JwtAuthenticationToken(source,
                Stream.concat(new JwtGrantedAuthoritiesConverter().convert(source).stream(),
                        extractRessourceRoles(source).stream()).collect(Collectors.toSet()));


    }
    private Collection<? extends GrantedAuthority> extractRessourceRoles(Jwt jwt) {
        var ressourceAccess = new HashMap<>(jwt.getClaim("resource_access"));
        var eternal=(Map<String, List<String>>) ressourceAccess.get("account") ;
        var roles=(Set<String>) eternal.get("roles");
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.replace("-","_")))
                .collect(Collectors.toSet());
    }

}

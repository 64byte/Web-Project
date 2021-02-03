package com.story.backend.authentication.filter;
;
import com.story.backend.authentication.provider.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class JwtFilter extends GenericFilterBean {
    private static final String authorizationHeaderName = "Authorization";
    private static final String authorizationHeaderPrefix = "Bearer ";

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        resolveAuthorizationHeader(request)
                .ifPresent((token) -> {
                    if (JwtProvider.validateToken(token)) {
                        Authentication auth = jwtProvider.getAuthentication(token);
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                });

        filterChain.doFilter(request, response);
    }

    private Optional<String> resolveAuthorizationHeader(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String headerContent = httpServletRequest.getHeader(authorizationHeaderName);

        if (!hasAuthorizationHeaderAndValue(headerContent)) {
            return Optional.empty();
        }

        return Optional.of(headerContent.substring(authorizationHeaderPrefix.length()));
    }

    private boolean hasAuthorizationHeaderAndValue(String headerContent) {
        return StringUtils.hasText(headerContent) && headerContent.startsWith(authorizationHeaderPrefix);
    }
}

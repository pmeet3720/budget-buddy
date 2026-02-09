package com.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class JWTFilter extends OncePerRequestFilter{
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// allow public APIs without token
        if (request.getRequestURI().contains("/public/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            sendError(response, "Authorization header missing or invalid");
            return;
        }

        String token = authHeader.substring(7); // remove "Bearer "

        try {
            Claims claims = jwtUtil.validateToken(token);
            request.setAttribute("userId", claims.getSubject());
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            sendError(response, "Invalid or expired token");
        }
		
	}
	
	private void sendError(HttpServletResponse res, String msg) throws IOException {
        res.setStatus(HttpStatus.UNAUTHORIZED.value());
        res.setContentType("application/json");

        Map<String, Object> map = new HashMap<>();
        map.put("status", 401);
        map.put("error", "Unauthorized");
        map.put("message", msg);

        res.getWriter().write(objectMapper.writeValueAsString(map));
    }

}

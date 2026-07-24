package ec.edu.uteq.inventario.service;

import ec.edu.uteq.inventario.dto.ApiResponse;
import ec.edu.uteq.inventario.dto.LoginRequest;
import ec.edu.uteq.inventario.dto.LoginResponse;
import ec.edu.uteq.inventario.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public ApiResponse<LoginResponse> login(LoginRequest request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String rol = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER");

        String token = jwtService.generateToken(user.getUsername(), rol);
        return ApiResponse.ok(
                new LoginResponse(token, user.getUsername(), rol),
                "Autenticacion exitosa"
        );
    }
}

package taller.controllers.publics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import taller.dtos.auth.AuthenticationReq;
import taller.dtos.auth.TokenInfo;
import taller.services.impls.auth.JwtUtilService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class AuthController {

    private static final Logger _logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtilService jwtUtilService;

    @PostMapping("/public/authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {

        _logger.info("Autenticando al usuario {}", authenticationReq.getUsername());

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationReq.getUsername(),
                authenticationReq.getPassword()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
            authenticationReq.getUsername());

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenInfo(jwt));
    }
}

package io.javabrains.springsecurityjwt.Web;

import io.javabrains.springsecurityjwt.security.MyUserDetailsService;
import io.javabrains.springsecurityjwt.dto.NewUserDTO;
import io.javabrains.springsecurityjwt.dto.UserDTO;
import io.javabrains.springsecurityjwt.security.jwt.models.AuthenticationRequest;
import io.javabrains.springsecurityjwt.security.jwt.models.AuthenticationResponse;
import io.javabrains.springsecurityjwt.usecase.AddNewUserUseCase;
import io.javabrains.springsecurityjwt.security.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private MyUserDetailsService userDetailsService;
    private final AddNewUserUseCase registrationPort;

    @Autowired
    public RegistrationController(AddNewUserUseCase registrationPort) {
        this.registrationPort = registrationPort;
    }


    @PostMapping(value = "/registration", headers = "Accept=application/json")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody NewUserDTO newUserDTO) {
        return new ResponseEntity<>(registrationPort.create(newUserDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}

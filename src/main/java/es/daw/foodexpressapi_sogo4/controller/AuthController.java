package es.daw.foodexpressapi_sogo4.controller;



import es.daw.foodexpressapi_sogo4.dto.AuthRequest;
import es.daw.foodexpressapi_sogo4.dto.AuthResponse;
import es.daw.foodexpressapi_sogo4.repository.UserRepository;
import es.daw.foodexpressapi_sogo4.security.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        /*
        authenticationManager.authenticate(...) es el punto central de validación en Spring Security.
        Internamente llama al UserDetailService.loadUserByUsername().
        Compara la contraseña ingresada con la almacenada (mediante el PasswordEncoder).
        Si las credenciales son correctas, devuelve un Authentication lleno de datos del usuario.
        Si no lo son, lanza una excepción (BadCredentialsException).
         */
        //Pendiente controlar la excepcion BadCredentialsException y el autenticacion
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    ));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(new AuthResponse(token));
    }
}

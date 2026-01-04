package es.daw.foodexpressapi_sogo4.controller;

import es.daw.foodexpressapi_sogo4.dto.UserResponseDTO;
import es.daw.foodexpressapi_sogo4.entity.User;
import es.daw.foodexpressapi_sogo4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
//        List<UserResponseDTO> users = userRepository.findAll().stream()
//                .map(user -> UserResponseDTO.builder()
//                        .id(user.getId())
//                        .username(user.getUsername())
//                        .fullName(user.getFullName())
//                        .email(user.getEmail())
//                        .roleName(user.getRole() != null ? user.getRole().getName() : null)
//                        .build())
//                .toList();

        List<UserResponseDTO> users = userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername()))
                .toList();
        return ResponseEntity.ok(users);
    }
}

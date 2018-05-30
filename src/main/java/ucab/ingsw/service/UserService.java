package ucab.ingsw.service;

import ucab.ingsw.command.UserSignUpCommand;
import ucab.ingsw.command.UserLoginCommand;
import ucab.ingsw.command.UserChangingAttributesCommand;
import ucab.ingsw.model.User;
import ucab.ingsw.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ucab.ingsw.response.NotifyResponse;
import ucab.ingsw.repository.UserRepository;

import java.time.LocalDateTime;


import java.util.List;

@Slf4j

@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;





    public ResponseEntity<Object> login(UserLoginCommand command) {
        log.debug("About to process [{}]", command);
        User u = userRepository.findFirstByEmailIgnoreCaseContaining(command.getEmail());
        if (u == null) {
             log.info("Cannot find user with email={}", command.getEmail());

            return ResponseEntity.badRequest().body(buildNotifyResponse("Dirección de correo no válida."));
        } else {
            if (u.getPassword().equals(command.getPassword())) {
                  log.info("Successful login for user={}", u.getId());



                UserResponse respuesta = new UserResponse();
                respuesta.setFirstName(u.getFirstName());
                respuesta.setLastName(u.getLastName());
                respuesta.setEmail(u.getEmail());
                respuesta.setId(u.getId());
                respuesta.setDateOfBirth(u.getDateOfBirth());
                return ResponseEntity.ok(respuesta);
            } else {
                log.info("{} is not valid password for user {}", command.getPassword(), u.getId());

                return ResponseEntity.badRequest().body(buildNotifyResponse("Proceso no válido. "));
            }
        }

    }


//-----------------------------------------------------------------------------------------------------------


    public ResponseEntity<Object> register(UserSignUpCommand command) { //SE ENCARGA DE REGISTRAR TODOS LOS USUARIOS
        log.debug("About to be processed [{}]", command);

        if (userRepository.existsByEmail(command.getEmail())) {
            log.info("La dirección de correo {} ya se encuentra en la base de datos.", command.getEmail());

            return ResponseEntity.badRequest().body(buildNotifyResponse("El usuario ya se encuentra registrado en el sistema."));
        } else {
            if (!command.getPassword().equals(command.getConfirmationPassword())) {
                    log.info("The passwords are not equal");
                return ResponseEntity.badRequest().body(buildNotifyResponse("Las contrasenas no coinciden"));
            } else {
                User user = new User();


                user.setId(System.currentTimeMillis());
                user.setFirstName(command.getFirstName());
                user.setLastName(command.getLastName());
                user.setEmail(command.getEmail());
                user.setPassword(command.getPassword());
                user.setDateOfBirth(command.getDateOfBirth());

                userRepository.save(user);

                  log.info("Registered user with ID={}", user.getId());

                return ResponseEntity.ok().body(buildNotifyResponse("Usuario registrado."));
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------



    public ResponseEntity<Object> update(UserChangingAttributesCommand command, String id) {
        log.debug("About to process [{}]", command);
        if (!userRepository.existsById(Long.parseLong(id))) {
            log.info("Cannot find user with ID={}", id);
            return ResponseEntity.badRequest().body(buildNotifyResponse("id invalido"));
        } else {
            User user = new User();

            user.setId(Long.parseLong(id));
            user.setFirstName(command.getFirstName());
            user.setLastName(command.getLastName());
            user.setEmail(command.getEmail());
            user.setPassword(command.getPassword());
            user.setDateOfBirth(command.getDateOfBirth());
            userRepository.save(user);

            log.info("Updated user with ID={}", user.getId());

            return ResponseEntity.ok().body(buildNotifyResponse("La operación ha sido exitosa."));
        }
    }






    public List<User> searchByName(String name){
        List<User> u = userRepository.findByFirstNameIgnoreCaseContaining(name);
        if(u==null){
            log.info("No se encontraros usuarios con el nombre : ",name);

        }else
        log.info("Cantidad de Usuarios encontrados={}", u.size(), name);



        return u;
    }



    public ResponseEntity<Object> delete(UserLoginCommand command,String id) {
        log.debug("About to process [{}]", command);

        if (userRepository.existsById(Long.parseLong(id))) {

            userRepository.deleteById(Long.parseLong(id));
            return  ResponseEntity.ok().body(buildNotifyResponse("La operación ha sido exitosa."));

        } else {
            log.info("Cannot find user with Id={}", id);

            return ResponseEntity.badRequest().body(buildNotifyResponse("Id no válido."));
            }
        }






    //-----------------------------------------------------------------------------------------------------------

    private NotifyResponse buildNotifyResponse(String message) { //MUESTRA UN MENSAJE DE NOTIFICACIÓN
        NotifyResponse respuesta = new NotifyResponse();
        respuesta.setMessage(message);
        respuesta.setTimestamp(LocalDateTime.now());
        return respuesta;
    }

}




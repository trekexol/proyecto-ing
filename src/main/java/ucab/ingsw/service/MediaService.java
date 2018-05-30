package ucab.ingsw.service;

import ucab.ingsw.command.MediaSignUpCommand;
import ucab.ingsw.model.Media;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ucab.ingsw.response.NotifyResponse;
import ucab.ingsw.repository.UserRepository;
import ucab.ingsw.repository.MediaRepository;

import java.time.LocalDateTime;

@Slf4j

@Service("MediaService")


public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private UserRepository userRepository;



    public ResponseEntity<Object> registerMedia(MediaSignUpCommand command, String id) { //SE ENCARGA DE REGISTRAR TODOS LOS Albunes


        if (!userRepository.existsById(Long.parseLong(id))) {
            log.info("Debe Iniciar Sesion");

            return ResponseEntity.badRequest().body(buildNotifyResponse("Debe Iniciar Sesion"));
        } else  {


            Media user = new Media();

            user.setId(System.currentTimeMillis());
            user.setIdentificador(Long.parseLong(id));
            user.setNombreAlbum(command.getNombreAlbum());
            user.setDescripcion(command.getDescripcion());



            mediaRepository.save(user);

            log.info("Registered Media with ID={}", user.getId());

            return ResponseEntity.ok().body(buildNotifyResponse("Album registrado."));

        }
    }

    private NotifyResponse buildNotifyResponse(String message) { //MUESTRA UN MENSAJE DE NOTIFICACIÓN
        NotifyResponse respuesta = new NotifyResponse();
        respuesta.setMessage(message);
        respuesta.setTimestamp(LocalDateTime.now());
        return respuesta;
    }


}

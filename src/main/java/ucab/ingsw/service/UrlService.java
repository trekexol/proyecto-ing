package ucab.ingsw.service;




import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucab.ingsw.repository.MediaRepository;
import ucab.ingsw.response.NotifyResponse;
import ucab.ingsw.model.Url;
import ucab.ingsw.command.UrlSignUpCommand;
import ucab.ingsw.repository.UrlRepository;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;




@Slf4j

@Service("UrlService")


public class UrlService {


        @Autowired
        private MediaRepository mediaRepository;

        @Autowired
        private UrlRepository urlRepository;



        public ResponseEntity<Object> register(UrlSignUpCommand command,String id) { //SE ENCARGA DE REGISTRAR TODOS LOS USUARIOS
            log.debug("About to be processed [{}]", command);

            if (!mediaRepository.existsById(Long.parseLong(id))) {
                log.info("El album no se reconoce ");

                return ResponseEntity.badRequest().body(buildNotifyResponse("El Album no se Reconoce"));
            } else {

                Url url = new Url();

                url.setId(System.currentTimeMillis());
                url.setIdentificador(Long.parseLong(id));
                url.setUrl(command.getUrl());

                urlRepository.save(url);

                log.info("Registered URL with ID={}", url.getId());

                return ResponseEntity.ok().body(buildNotifyResponse("Url registrado."));
            }

        }



        private NotifyResponse buildNotifyResponse(String message) { //MUESTRA UN MENSAJE DE NOTIFICACIÓN
            NotifyResponse respuesta = new NotifyResponse();
            respuesta.setMessage(message);
            respuesta.setTimestamp(LocalDateTime.now());
            return respuesta;
        }


    }



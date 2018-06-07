package ucab.ingsw.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucab.ingsw.model.Url;
import ucab.ingsw.repository.MediaRepository;
import ucab.ingsw.response.NotifyResponse;
import ucab.ingsw.repository.UrlRepository;

import java.time.LocalDateTime;
import java.util.*;




@Slf4j

@Service("InstagramService")
public class InstagramService {


        @Autowired
        private MediaRepository mediaRepository;

        @Autowired
        private UrlRepository urlRepository;


    public List<Url> search(String tag){

        ArrayList<Url> url = new ArrayList<Url>();


           log.info("el tag es: {}",tag);



        return url;
    }


        private NotifyResponse buildNotifyResponse(String message) { //MUESTRA UN MENSAJE DE NOTIFICACIÓN
            NotifyResponse respuesta = new NotifyResponse();
            respuesta.setMessage(message);
            respuesta.setTimestamp(LocalDateTime.now());
            return respuesta;
        }


    }





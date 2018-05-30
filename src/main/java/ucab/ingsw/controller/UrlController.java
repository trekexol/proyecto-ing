package ucab.ingsw.controller;



import ucab.ingsw.command.UserChangingAttributesCommand;
import ucab.ingsw.command.UrlSignUpCommand;
import ucab.ingsw.model.User;
import ucab.ingsw.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import ucab.ingsw.command.UserLoginCommand;

@Slf4j

@CrossOrigin
@RestController
@RequestMapping(value = "/Url", produces = "application/json")

public class UrlController {



        @Autowired
        private UrlService urlService;



        @RequestMapping(value = "/register/{id}", consumes = "application/json", method = RequestMethod.POST)
        public ResponseEntity register(@Valid @RequestBody UrlSignUpCommand command, @PathVariable("id") String id) {
            return urlService.register(command,id);
        }


    }



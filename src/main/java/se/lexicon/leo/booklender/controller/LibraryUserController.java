package se.lexicon.leo.booklender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.leo.booklender.exception.ObjectNotFoundException;
import se.lexicon.leo.booklender.model.dto.LibraryUserDto;
import se.lexicon.leo.booklender.service.LibraryUserService;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/api/library-user")
@RestController
public class LibraryUserController {
    private final LibraryUserService libraryUserService;

    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDto> findById(@PathVariable("id") Integer personId) throws ObjectNotFoundException {
        LibraryUserDto libraryUserDto = libraryUserService.findById(personId);
        return ResponseEntity.ok().body(libraryUserDto);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<LibraryUserDto> findByEmail(@PathVariable("email") String email) throws ObjectNotFoundException {

            LibraryUserDto libraryUserDto = libraryUserService.findByEmail(email);
            return ResponseEntity.ok().body(libraryUserDto);
    }



    @GetMapping("/all")
    public ResponseEntity<List<LibraryUserDto>> getAll() {
        return ResponseEntity.ok().body(libraryUserService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<LibraryUserDto> create(@RequestBody @Valid LibraryUserDto libraryUserDto){
        LibraryUserDto createdUser = libraryUserService.create(libraryUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping()
    public ResponseEntity<LibraryUserDto> update(@RequestBody @Valid LibraryUserDto libraryUserDto) throws ObjectNotFoundException {
        libraryUserService.update(libraryUserDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
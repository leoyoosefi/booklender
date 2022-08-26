package se.lexicon.leo.booklender.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.leo.booklender.exception.ObjectNotFoundException;
import se.lexicon.leo.booklender.model.dto.LibraryUserDto;
import se.lexicon.leo.booklender.model.entity.LibraryUser;
import se.lexicon.leo.booklender.model.repository.LibraryUserRepository;

import java.util.List;

@Service
public class LibraryUserImpl implements LibraryUserService{


     LibraryUserRepository libraryUserRepository;
     ModelMapper modelMapper;

    @Autowired
    public LibraryUserImpl(LibraryUserRepository libraryUserRepository, ModelMapper modelMapper) {
        this.libraryUserRepository = libraryUserRepository;
        this.modelMapper = modelMapper;
    }

    public LibraryUserDto findById(int id) throws ObjectNotFoundException {
        if (id < 0) throw new IllegalArgumentException("id should be zero or more");
        LibraryUser user = libraryUserRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("user not found"));
        return modelMapper.map(user, LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto findByEmail(String email) throws ObjectNotFoundException {
        if (email == null || email.equals("")) throw new IllegalArgumentException("email is null/empty");
        LibraryUser user = libraryUserRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("user not found"));
        return modelMapper.map(user, LibraryUserDto.class);
    }

    @Override
    public List<LibraryUserDto> findAll() {
        return modelMapper.map(libraryUserRepository.findAll(),
                new TypeToken<List<LibraryUserDto>>() {
                }.getType());
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {
        if (libraryUserDto == null) throw new IllegalArgumentException("libraryUserDto is null");
        LibraryUser userSave = modelMapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser savedUser = libraryUserRepository.save(userSave);
        return modelMapper.map(savedUser, LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) throws ObjectNotFoundException {
        if (libraryUserDto == null) throw new IllegalArgumentException("libraryUserDto is null");
        if (!libraryUserRepository.existsById(libraryUserDto.getId()))
            throw new ObjectNotFoundException("User with email:" + libraryUserDto.getEmail() + " not found");
        LibraryUser userToSave = modelMapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser savedUser = libraryUserRepository.save(userToSave);
        return modelMapper.map(savedUser, LibraryUserDto.class);
    }

    @Override
    public boolean delete(int id) throws ObjectNotFoundException {
        if (id < 0) throw new IllegalArgumentException("id should be zero or more");
        if (!libraryUserRepository.existsById(id))
            throw new ObjectNotFoundException("User not found");
        libraryUserRepository.deleteById(id);
        return true;
    }
}

package se.lexicon.leo.booklender.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import se.lexicon.leo.booklender.exception.ObjectNotFoundException;
import se.lexicon.leo.booklender.model.dto.LoanDto;
import se.lexicon.leo.booklender.model.entity.Loan;
import se.lexicon.leo.booklender.model.repository.LoanRepository;

import java.util.List;


@Service
public class LoanServiceImpl implements LoanService {


    private LoanRepository loanRepository;
    private ModelMapper modelMapper;


    public LoanServiceImpl(LoanRepository loanRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanDto findById(long id) throws ObjectNotFoundException {
        if (id < 0) throw new IllegalArgumentException("id should be zero or more");
        Loan loan = loanRepository.findById(id);
        if (loan == null) throw new ObjectNotFoundException("object not found");
        return modelMapper.map(loan, LoanDto.class);
    }

    @Override
    public List<LoanDto> findByBookId(int bookId) throws ObjectNotFoundException {
        if (bookId < 0) throw new IllegalArgumentException("bookId should be zero or more");
        List<Loan> list = loanRepository.findByBookBookId(bookId);
        if (list.isEmpty()) throw new ObjectNotFoundException("object not found");
        return modelMapper.map(list, new TypeToken<List<LoanDto>>() {
        }.getType());
    }

    @Override
    public List<LoanDto> findByUserId(int id) {

        if (id < 0) throw new IllegalArgumentException("user id should be zero or more");
        List<Loan> list = loanRepository.findAllByLoanTakerId(id);

        return modelMapper.map(list, new TypeToken<List<LoanDto>>() {
        }.getType());
    }

    @Override
    public List<LoanDto> findByConcluded(boolean status) {
        List<Loan> list = loanRepository.findByConcluded(status);

        return modelMapper.map(list, new TypeToken<List<LoanDto>>() {
        }.getType());
    }

    @Override
    public List<LoanDto> findAll() {
        List<Loan> list = loanRepository.findAll();
        return modelMapper.map(list, new TypeToken<List<LoanDto>>() {
        }.getType());
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        if (loanDto == null) throw new IllegalArgumentException("loanDto is null");
        Loan loan = modelMapper.map(loanDto, Loan.class);
        Loan savedLoan = loanRepository.save(loan);

        return modelMapper.map(savedLoan, LoanDto.class);
    }

    @Override
    public LoanDto update(LoanDto loanDto) throws ObjectNotFoundException {
        if (loanDto == null) throw new IllegalArgumentException("loanDto is null");
        if (!loanRepository.existsById(loanDto.getId()))
            throw new ObjectNotFoundException("loan id not found");
        Loan toUpdate = modelMapper.map(loanDto, Loan.class);
        Loan updatedLoan = loanRepository.save(toUpdate);

        return modelMapper.map(updatedLoan, LoanDto.class);
    }

    @Override
    public boolean deleteById(long id) throws ObjectNotFoundException {
        if (!loanRepository.existsById(id)) throw new ObjectNotFoundException("loan id not found");
        loanRepository.deleteById(id);
        return true;
    }
}

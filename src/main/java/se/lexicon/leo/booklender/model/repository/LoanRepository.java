package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.Loan;

import java.util.List;


public interface LoanRepository extends CrudRepository<Loan, Long> {


    List<Loan> findAll();

    List<Loan> findAllByLoanTakerId(int id);

    List<Loan> findByConcluded(boolean concluded);

    List<Loan> findByBookBookId(int id);

}

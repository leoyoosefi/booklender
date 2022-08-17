package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.Loan;



public interface LoanRepository extends CrudRepository<Loan, Integer> {

}

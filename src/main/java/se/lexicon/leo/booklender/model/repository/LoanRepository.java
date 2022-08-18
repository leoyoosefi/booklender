package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.leo.booklender.model.entity.Loan;

import java.util.List;
import java.util.Optional;


public interface LoanRepository extends CrudRepository<Loan, Integer> {


    @Query("SELECT loan " +
            "FROM Loan loan " +
            "JOIN FETCH loan.book book " +
            "WHERE book.bookId = :bookId")
    Optional<Loan> findByBookId(@Param("bookId") int bookId);

    @Query("SELECT loan " +
            "FROM Loan loan " +
            "JOIN FETCH loan.loanTaker loanTaker " +
            "WHERE loanTaker.userId = :userId")
    Optional<Loan> findByUserId(@Param("userId") int userId);

    List<Loan> findByConcluded(boolean concluded);

}

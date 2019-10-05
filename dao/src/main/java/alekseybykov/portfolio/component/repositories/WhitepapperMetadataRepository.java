//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.repositories;

import alekseybykov.portfolio.component.entities.WhitePapperMetadata;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Repository
public interface WhitepapperMetadataRepository extends WhitepapperMetadataRegistry, JpaRepository<WhitePapperMetadata, Long> {
    @Query(value = "select wm " +
            "from WhitePapperMetadata wm " +
            "where wm.registrationNumber = :registration_number " +
            "and wm.registrationDate = :registration_date " +
            "and wm.whitePapper.id <> :id"
    )
    Optional<WhitePapperMetadata> findExistingWhitePapperMetadata(@Param("id") Long id,
                                                                  @Param("registration_number") String registrationNumber,
                                                                  @Param("registration_date") LocalDate registrationDate
    );
}

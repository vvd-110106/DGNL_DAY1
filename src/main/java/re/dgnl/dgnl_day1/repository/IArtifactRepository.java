package re.dgnl.dgnl_day1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.dgnl.dgnl_day1.model.Artifact;


@Repository
public interface IArtifactRepository extends JpaRepository<Artifact,Long> {

    // Timf kieems theo tên - origin
   Page<Artifact> findAllByNameContainingIgnoreCaseOrOriginContainingIgnoreCase(String name,String origin, Pageable pageable);

}

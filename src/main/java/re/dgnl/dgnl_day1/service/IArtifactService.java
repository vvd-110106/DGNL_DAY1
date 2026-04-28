package re.dgnl.dgnl_day1.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import re.dgnl.dgnl_day1.model.Artifact;



public interface IArtifactService {
    Page<Artifact> getAllArtifacts(String search, Pageable pageable);
    void save(Artifact artifact);
    Artifact findById(Long id);
    void delete(Long id);
}

package re.dgnl.dgnl_day1.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.dgnl.dgnl_day1.model.Artifact;
import re.dgnl.dgnl_day1.repository.IArtifactRepository;
import re.dgnl.dgnl_day1.service.IArtifactService;


@Service
@RequiredArgsConstructor
public class IArtifactServiceImpl  implements IArtifactService {
    private final IArtifactRepository artifactRepository;

    @Override
    public Page<Artifact> getAllArtifacts(String search, Pageable pageable) {
        return artifactRepository.findAllByNameContainingIgnoreCaseOrOriginContainingIgnoreCase(search,search,pageable);
    }

    @Override
    public void save(Artifact artifact) {
        artifactRepository.save(artifact);
    }

    @Override
    public Artifact findById(Long id) {
        return artifactRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        artifactRepository.deleteById(id);
    }
}

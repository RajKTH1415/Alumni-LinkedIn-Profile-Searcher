package com.backend.service;

import com.backend.model.Alumni;
import com.backend.repository.AlumniRepository;
import com.backend.request.AlumniSearchRequest;
import com.backend.response.AlumniResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlumniService {

    private final AlumniRepository alumniRepository;
    private final PhantomBusterService phantomService;


    public List<AlumniResponse> searchAndSaveAlumni(AlumniSearchRequest request) {
        log.info("Starting alumni search for university: {}", request.getUniversity());

        List<AlumniResponse> fetchedAlumni = phantomService.fetchAlumniFromPhantomBuster(request);
        log.info("Fetched {} alumni from PhantomBuster for university: {}", fetchedAlumni.size(), request.getUniversity());

        List<Alumni> entities = fetchedAlumni.stream().map(a ->
                new Alumni(null, a.getName(), a.getCurrentRole(), a.getUniversity(),
                        a.getLocation(), a.getLinkedinHeadline(), a.getPassoutYear())
        ).toList();

        alumniRepository.saveAll(entities);
        log.info("Saved {} alumni records to the database.", entities.size());

        return fetchedAlumni;
    }

    public List<AlumniResponse> getAllAlumni() {
        log.info("Fetching all alumni from the database.");

        List<AlumniResponse> alumniResponses = alumniRepository.findAll().stream().map(alumni ->
                new AlumniResponse(alumni.getName(), alumni.getCurrentRole(),
                        alumni.getUniversity(), alumni.getLocation(),
                        alumni.getLinkedinHeadline(), alumni.getPassoutYear())
        ).toList();

        log.info("Retrieved {} alumni from the database.", alumniResponses.size());
        return alumniResponses;
    }
}
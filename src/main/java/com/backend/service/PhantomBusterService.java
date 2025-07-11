package com.backend.service;

import com.backend.request.AlumniSearchRequest;
import com.backend.response.AlumniResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhantomBusterService {

    public List<AlumniResponse> fetchAlumniFromPhantomBuster(AlumniSearchRequest request) {
        List<AlumniResponse> results = new ArrayList<>();

        results.add(new AlumniResponse("John Doe", "Software Engineer", request.getUniversity(),
                "New York, NY", "Passionate Software Engineer at XYZ Corp", 2020));
        results.add(new AlumniResponse("Jane Smith", "Data Scientist", request.getUniversity(),
                "San Francisco, CA", "Data Scientist | AI Enthusiast", 2019));


        return results;
    }
}

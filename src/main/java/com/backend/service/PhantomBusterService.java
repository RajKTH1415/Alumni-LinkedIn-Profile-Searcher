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
        results.add(new AlumniResponse("Michael Johnson", "Product Manager", request.getUniversity(),
                "Seattle, WA", "Driving innovation and product growth at TechNova", 2018));
        results.add(new AlumniResponse("Emily Davis", "UX Designer", request.getUniversity(),
                "Austin, TX", "Creative UX/UI Designer at DesignCraft", 2021));
        results.add(new AlumniResponse("Robert Lee", "DevOps Engineer", request.getUniversity(),
                "Denver, CO", "Building scalable infrastructure at CloudNest", 2017));
        results.add(new AlumniResponse("Sophia Wilson", "Cybersecurity Analyst", request.getUniversity(),
                "Boston, MA", "Security-first mindset, protecting systems at SafeNet", 2019));
        results.add(new AlumniResponse("David Martinez", "Mobile App Developer", request.getUniversity(),
                "Los Angeles, CA", "Android/iOS Developer passionate about sleek UIs", 2022));
        results.add(new AlumniResponse("Olivia Brown", "AI Researcher", request.getUniversity(),
                "Chicago, IL", "Exploring machine learning at DeepThink Labs", 2020));
        results.add(new AlumniResponse("Daniel Kim", "Cloud Solutions Architect", request.getUniversity(),
                "Atlanta, GA", "Designing cloud-native systems at SkyCompute", 2016));
        results.add(new AlumniResponse("Isabella Clark", "Business Analyst", request.getUniversity(),
                "Miami, FL", "Turning data into actionable insights at FinScope", 2018));

        return results;
    }
}

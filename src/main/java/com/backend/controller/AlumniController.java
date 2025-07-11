package com.backend.controller;

import com.backend.request.AlumniSearchRequest;
import com.backend.response.AlumniResponse;
import com.backend.service.AlumniService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/alumni")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Alumni Controller", description = "APIs for searching and retrieving LinkedIn alumni profiles")
public class AlumniController {

    private final AlumniService alumniService;

    @Operation(
            summary = "Search LinkedIn alumni profiles",
            description = "Searches alumni profiles by university name, current designation, and optional pass-out year using the PhantomBuster API and saves them to the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved and saved alumni profiles"),
            @ApiResponse(responseCode = "400", description = "Invalid input request"),
            @ApiResponse(responseCode = "500", description = "Server error while processing the search")
    })
    @PostMapping("/search")
    public ResponseEntity<?> searchAlumni(@Valid @RequestBody AlumniSearchRequest request) {
        log.info("Received alumni search request for university: {}", request.getUniversity());

        List<AlumniResponse> results = alumniService.searchAndSaveAlumni(request);

        log.info("Returning {} alumni results for university: {}", results.size(), request.getUniversity());
        return ResponseEntity.ok(Map.of("status", "success", "data", results));
    }

    @Operation(
            summary = "Get all saved alumni profiles",
            description = "Fetches all previously saved alumni profiles from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all alumni profiles"),
            @ApiResponse(responseCode = "500", description = "Server error while fetching alumni profiles")
    })
    @GetMapping("/all")
    public ResponseEntity<?> getAllAlumni() {
        log.info("Fetching all alumni records from database.");

        List<AlumniResponse> results = alumniService.getAllAlumni();

        log.info("Returning {} total alumni records.", results.size());
        return ResponseEntity.ok(Map.of("status", "success", "data", results));
    }
}

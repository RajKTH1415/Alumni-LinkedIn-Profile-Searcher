package com.backend.AlumniServiceTest;

import com.backend.model.Alumni;
import com.backend.repository.AlumniRepository;
import com.backend.request.AlumniSearchRequest;
import com.backend.response.AlumniResponse;
import com.backend.service.AlumniService;
import com.backend.service.PhantomBusterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlumniServiceTest {

    @Mock
    private AlumniRepository alumniRepository;

    @Mock
    private PhantomBusterService phantomService;

    @InjectMocks
    private AlumniService alumniService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test for searchAndSaveAlumni
    @Test
    void testSearchAndSaveAlumni() {
        // Arrange
        AlumniSearchRequest request = new AlumniSearchRequest();
        request.setUniversity("Test University");

        List<AlumniResponse> mockResponses = Arrays.asList(
                new AlumniResponse("John Doe", "Engineer", "Test University", "New York", "Software Dev", 2015),
                new AlumniResponse("Jane Smith", "Analyst", "Test University", "Chicago", "Data Analyst", 2016)
        );

        when(phantomService.fetchAlumniFromPhantomBuster(request)).thenReturn(mockResponses);

        // Act
        List<AlumniResponse> result = alumniService.searchAndSaveAlumni(request);

        // Assert
        assertEquals(2, result.size());
        verify(phantomService, times(1)).fetchAlumniFromPhantomBuster(request);
        verify(alumniRepository, times(1)).saveAll(anyList());
    }

    // Test for getAllAlumni
    @Test
    void testGetAllAlumni() {
        // Arrange
        List<Alumni> mockEntities = Arrays.asList(
                new Alumni(1L, "John Doe", "Engineer", "Test University", "New York", "Software Dev", 2015),
                new Alumni(2L, "Jane Smith", "Analyst", "Test University", "Chicago", "Data Analyst", 2016)
        );

        when(alumniRepository.findAll()).thenReturn(mockEntities);

        // Act
        List<AlumniResponse> result = alumniService.getAllAlumni();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());
        verify(alumniRepository, times(1)).findAll();
    }
}

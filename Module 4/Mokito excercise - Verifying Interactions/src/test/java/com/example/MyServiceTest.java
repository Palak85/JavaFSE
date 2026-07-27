package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest { 

    @Test 
    public void testVerifyInteraction() { 
        // 1. Create a mock object.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        
        // 2. Call the method with specific arguments / interactions.
        MyService service = new MyService(mockApi); 
        service.fetchData(); 
        
        // 3. Verify the interaction.
        verify(mockApi).getData(); 
    } 
}

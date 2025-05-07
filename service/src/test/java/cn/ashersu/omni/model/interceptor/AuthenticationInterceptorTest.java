package cn.ashersu.omni.model.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationInterceptorTest {

    @Mock
    private Interceptor.Chain chain;

    @Mock
    private Request originalRequest;

    @Mock
    private Request.Builder requestBuilder;

    @Mock
    private Request modifiedRequest;

    @Mock
    private Response expectedResponse;

    @BeforeEach
    void setUp() throws IOException {
//        MockitoAnnotations.openMocks(this);
        when(chain.request()).thenReturn(originalRequest);
        when(originalRequest.newBuilder()).thenReturn(requestBuilder);
        when(requestBuilder.header(anyString(), anyString())).thenReturn(requestBuilder);
        when(requestBuilder.build()).thenReturn(modifiedRequest);
        when(chain.proceed(modifiedRequest)).thenReturn(expectedResponse);
    }

    @Test
    void addsAuthorizationHeaderWithBearerToken() throws IOException {
        // Arrange
        String token = "abc123";
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);

        // Act
        Response response = interceptor.intercept(chain);

        // Assert
        verify(requestBuilder).header("Authorization", "Bearer abc123");
        assertEquals(expectedResponse, response);
    }

    @Test
    void throwsNullPointerExceptionWhenTokenIsNull() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> new AuthenticationInterceptor(null));
    }

    @Test
    void verifyCorrectRequestIsProceedWithAfterModification() throws IOException {
        // Arrange
        String token = "xyz789";
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);

        // Act
        interceptor.intercept(chain);

        // Assert
        verify(chain).proceed(modifiedRequest);
    }

    @Test
    void propagatesIOExceptionFromChainProceed() throws IOException {
        // Arrange
        when(chain.proceed(any())).thenThrow(new IOException("Network error"));
        String token = "test-token";
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(token);

        // Act & Assert
        assertThrows(IOException.class, () -> interceptor.intercept(chain));
    }
}

/*
 * Nctu Software Testing  2020 Lab 3 Test
 * */
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SoftwareTesting2020Test {

//    @Mock
//    Date DateMock;
//
//    @InjectMocks
//    SoftwareTesting2020 testing2020;

    @Test
    void test_a() {
        SoftwareTesting2020 testing2020 = Mocktio.mock(SoftwareTesting2020.class);
        when(testing2020.get).thenReturn(4);
    }

    @Test
    void test_b() {
    }

    @Test
    void test_c() {
    }

    @Test
    void test_d() {
    }

    @Test
    void test_e() {
    }
}

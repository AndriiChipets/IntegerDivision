package ua.prom.roboticsdmc.integerdevision.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.prom.roboticsdmc.integerdivision.domain.DivisionResult;
import ua.prom.roboticsdmc.integerdivision.domain.DivisionStep;
import ua.prom.roboticsdmc.integerdivision.provider.DivisionMathProviderImpl;

class DivisionMathProviderImplTest {

    DivisionMathProviderImpl divisionMathProviderImpl = new DivisionMathProviderImpl();
  
    @Test
    void provideMathDivision_shouldReturnQuotientEqualsOneAndRemainderEquelsZero_whenInputDivisionEqualsDivisor() {
        List<DivisionStep> steps = new ArrayList<>();
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(78, 78);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(78)
                                .withDivision(78)
                                .withQuotient(1)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnRamainderAndQuotientEqualsZero_whenInputDivisionIsZero() {
        List<DivisionStep> steps = new ArrayList<>();
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(0, 7);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(7)
                                .withDivision(0)
                                .withQuotient(0)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnCorrectExpression_whenDivisionBiggerThenDivisor() {

        List<DivisionStep> steps = new ArrayList<>(Arrays.asList(new DivisionStep(38, 36), new DivisionStep(29, 28),
                new DivisionStep(14, 12), new DivisionStep(25, 24)));
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(78945, 4);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(4)
                                .withDivision(78945)
                                .withQuotient(19736)
                                .withRemainder(1).build();

        assertEquals(expected, actual);
    }

    @Test
    void provideMathDivision_shouldReturnRamainderAndQuotientEqualsZero_whenInputDivisorBiggerThenDivision() {
        
        List<DivisionStep> steps = new ArrayList<>();
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(14, 124);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(124)
                                .withDivision(14)
                                .withQuotient(0)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnRamainderAndQuotientEqualsZero_whenInputDivisorLittleBiggerThenDivision() {
        
        List<DivisionStep> steps = new ArrayList<>();
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(123456789, 1234567890);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(1234567890)
                                .withDivision(123456789)
                                .withQuotient(0)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }

    @Test
    void provideMathDivision_shouldReturnshouldReturnCorrectExpression_whenInputDivisionMuchBiggerThenDivisor() {
        List<DivisionStep> steps = new ArrayList<>();
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(100003, 5);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(5)
                                .withDivision(100003)
                                .withQuotient(20000)
                                .withRemainder(3).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnshouldReturnCorrectExpression_whenInputDivisionAndDivisorBigNumber() {
        List<DivisionStep> steps = new ArrayList<>(Arrays.asList(new DivisionStep(365, 246),
                new DivisionStep(1194, 1107), new DivisionStep(873, 861), new DivisionStep(1221, 1107)));
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(987654321, 123);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(123)
                                .withDivision(987654321)
                                .withQuotient(8029709)
                                .withRemainder(114).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnshouldReturnCorrectExpression_whenInputDivisionAndDivisorLookSame() {
        List<DivisionStep> steps = new ArrayList<>(Arrays.asList(new DivisionStep(10, 10),
                new DivisionStep(10, 10), new DivisionStep(10, 10), new DivisionStep(10, 10)));
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(1010101010, 10);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(10)
                                .withDivision(1010101010)
                                .withQuotient(101010101)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }
    
    @Test
    void provideMathDivision_shouldReturnshouldReturnCorrectExpression_whenInputDivisionAndDivisor() {
        List<DivisionStep> steps = new ArrayList<>(Arrays.asList(new DivisionStep(8, 8), new DivisionStep(8, 8),
                new DivisionStep(8, 8), new DivisionStep(8, 8), new DivisionStep(8, 8), new DivisionStep(8, 8),
                new DivisionStep(8, 8)));
        DivisionResult actual = divisionMathProviderImpl.provideMathDivision(88888888, 4);
        DivisionResult expected = DivisionResult.builder()
                                .withSteps(steps)
                                .withDivisor(4)
                                .withDivision(88888888)
                                .withQuotient(22222222)
                                .withRemainder(0).build();

        assertEquals(expected, actual);
    }
}

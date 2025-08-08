import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

@Mock
    Feline feline;

@Test
    public void testKittens() throws Exception {
    int countExpected = 1;
    Mockito.when(feline.getKittens()).thenReturn(countExpected);

    Lion lion = new Lion("Самец", feline);
    assertEquals(countExpected, lion.getKittens(),"Количество котят неверно");
}
    @Test
    public void testFood() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);

        Lion lion = new Lion("Самец", feline);
        assertEquals(expectedList, lion.getFood(), "Список еды неправильный");
    }

    @Test
    public void exceptionSex(){
        Exception exception = assertThrows(Exception.class, () -> new Lion("Альфа-самец", feline));
        String expectedException = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expectedException, exception.getMessage());
    }
}


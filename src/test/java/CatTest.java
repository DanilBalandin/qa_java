import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTestCat() {
    Cat cat = new Cat(feline);
    String result = "Мяу";
    assertEquals(result, cat.getSound(), "Кошка может говорить только мяу");
    }

    @Test
    public void testEat() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedList);

        Cat cat = new Cat(feline);
        assertEquals(expectedList, cat.getFood(), "Неверный список Еды");
    }
}

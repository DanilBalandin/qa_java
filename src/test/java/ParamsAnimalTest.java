import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class ParamsAnimalTest {

    Animal animal = new Animal();
    private final String typeOfAnimal;
    private final List<String> expectedTypeOfFood;

    public ParamsAnimalTest(String typeOfAnimal, List<String> expectedTypeOfFood) {
        this.typeOfAnimal = typeOfAnimal;
        this.expectedTypeOfFood = expectedTypeOfFood;
    }

    @Parameterized.Parameters
    public static Object[][] getTypeOfFoodForAmimal() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void getFoodForHerbivoreCorrectValue() throws Exception {
        List<String> actualType = animal.getFood(typeOfAnimal);

        assertEquals(expectedTypeOfFood, actualType, "Метод getFood возвращает неправильное значение");
    }

    @Test
    public void getFoodException() {
        String invalidAnimalKind = "Всеядное";
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";


        Exception exception = assertThrows(Exception.class,
                () -> animal.getFood(invalidAnimalKind)
        );


        assertEquals(expectedMessage, exception.getMessage(), "Текст исключения некорректен");
    }

    @Test
    public void getFamilyCorrectValue(){
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();

        assertEquals(expectedFamily, actualFamily, "Метод getFamily возвращает некорректное значение");
    }

}
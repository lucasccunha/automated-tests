package br.com.fiap;

import br.com.fiap.model.Person;
import br.com.fiap.service.IPersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.fiap.service.PersonService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonServiceTest {

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSucess_ShouldReturnPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();
        Person person = new Person (
                "Keith",
                "Moon",
                "teste@teste.com.br",
                "Wembley - UK ",
                "Male"
        );
        // When / Act
        Person actual = service.createPerson(person);
        // Then / Assert
        assertNotNull(actual,() -> "The createPerson() should not have returned null!");
    }
}
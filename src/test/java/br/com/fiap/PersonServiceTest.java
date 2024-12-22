package br.com.fiap;

import br.com.fiap.model.Person;
import br.com.fiap.service.IPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.fiap.service.PersonService;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
        person = new Person(
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main St, Anytown, USA",
                "Masculino"
        );
    }

    @DisplayName("Quando criar uma pessoa com sucesso, deve retornar um objeto Pessoa")
    @Test
    void testCreatePerson_QuandoSucesso_DeveRetornarObjetoPessoa() {

        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "O método createPerson() não deveria ter retornado null!");
    }

    @DisplayName("Quando criar uma pessoa com sucesso, deve conter os atributos corretos no objeto retornado")
    @Test
    void testCreatePerson_QuandoSucesso_DeveConterAtributosCorretosNoObjetoRetornado() {

        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "O método createPerson() não deveria ter retornado null!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "O primeiro nome do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "O sobrenome do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "O email do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "O endereço do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getGender(), actual.getGender(), () -> "O gênero do objeto retornado não corresponde ao esperado!");
    }
}

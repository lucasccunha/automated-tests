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
    IPersonService service;

    @BeforeEach
    void setup() {
        service = new PersonService();
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

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "O método createPerson() não deveria ter retornado null!");
    }

    @DisplayName("Quando criar uma pessoa com sucesso, deve conter os atributos corretos no objeto retornado")
    @Test
    void testCreatePerson_QuandoSucesso_DeveConterAtributosCorretosNoObjetoRetornado() {

        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(person.getId(), () -> "ID da pessoa está faltando");
        assertNotNull(actual, () -> "O método createPerson() não deveria ter retornado null!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "O primeiro nome do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "O sobrenome do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "O email do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "O endereço do objeto retornado não corresponde ao esperado!");
        assertEquals(person.getGender(), actual.getGender(), () -> "O gênero do objeto retornado não corresponde ao esperado!");
    }


    @DisplayName("Ao criar uma pessoa com e-mail nulo deve lançar uma exceção")
    @Test
    void testCreatePerson_Com_Email_Nulo_Develancar_IlegalArgumentException() {
        // Given / Arrange
        person.setEmail(null);

        var expectedMessage = "O e-mail da pessoa é nulo ou vazio!";

        // When / Act & Then / Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Um e-mail vazio deve ter causado uma IllegalArgumentException!"
        );
        // Then / Assert
        assertEquals(
                expectedMessage,
                exception.getMessage(),
        () -> "A mensagem de erro de exceção está incorreta!");
    }

}

package br.com.fiap.service;

import br.com.fiap.model.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService{
    @Override
    public Person createPerson(Person person) {
        if (person.getEmail() == null || person.getEmail().isBlank())
            throw new IllegalArgumentException("O e-mail da pessoa é nulo ou vazio!");

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}

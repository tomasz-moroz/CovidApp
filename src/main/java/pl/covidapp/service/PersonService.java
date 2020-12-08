package pl.covidapp.service;

import pl.covidapp.dao.Dao;
import pl.covidapp.dto.PersonDto;
import pl.covidapp.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class PersonService {

    @Inject
    Dao<Person> personDao;

    @Transactional
    public PersonDto savePerson(PersonDto personDto) {

        Person person = PersonDto.dtoToPerson.apply(personDto);
        Person savePerson = personDao.save(person);

        return PersonDto.personToDto.apply(savePerson);
    }

    @Transactional
    public PersonDto getPersonById(Integer id) {

        Person person = personDao.get(id);

        if (person != null) {
            return PersonDto.personToDto.apply(person);
        }
        return null;
    }

    @Transactional
    public List<PersonDto> findByName(String name) {

        List<Person> byName = personDao.getByName(name);

        return byName.stream().map(person -> PersonDto.personToDto.apply(person)).collect(Collectors.toList());
    }

    @Transactional
    public PersonDto update(Integer id, PersonDto personDto) {

        Person apply = PersonDto.dtoToPerson.apply(personDto);
        Person update = personDao.update(id, apply);

        return PersonDto.personToDto.apply(update);
    }

    public void delete(Integer id) {

        personDao.delete(id);
    }

}

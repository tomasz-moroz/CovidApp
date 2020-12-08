package pl.covidapp.dao;

import pl.covidapp.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PersonDao implements Dao<Person> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person get(Integer id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getByName(String name) {
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p where p.name = :name", Person.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person update(Integer id, Person person) {

        Person personToUpdate = get(id);

        if (personToUpdate != null) {
            personToUpdate.setName(person.getName());
            personToUpdate.setLastName(person.getLastName());
            personToUpdate.setPesel(person.getPesel());
            entityManager.merge(personToUpdate);
            return personToUpdate;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Person person = get(id);
        entityManager.remove(person);
    }

    @Override
    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }
}

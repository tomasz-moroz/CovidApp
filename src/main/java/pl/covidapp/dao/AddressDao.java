package pl.covidapp.dao;

import pl.covidapp.model.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AddressDao implements AddressDaoInterface<Address> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Address get(Integer id) {
        return entityManager.find(Address.class, id);
    }

    @Override
    public Address save(Address address) {
        entityManager.persist(address);
        return address;
    }

    @Override
    public List<Address> getByState(String state) {
        TypedQuery<Address> query = entityManager.createQuery("select a from Address a where a.state=:state", Address.class);
        query.setParameter("state", state);
        return query.getResultList();
    }

    @Override
    public List<Address> getByCity(String city) {
        TypedQuery<Address> query = entityManager.createQuery("select a from Address a where a.city=:city", Address.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public List<Address> getByZip(String zip) {
        TypedQuery<Address> query = entityManager.createQuery("select a from Address a where a.zip=:zip", Address.class);
        query.setParameter("zip", zip);
        return query.getResultList();
    }

    @Override
    public Address update(Integer id, Address address) {

        Address addressToUpdate = get(id);

        if (addressToUpdate != null) {
            addressToUpdate.setApartmentNumber(address.getApartmentNumber());
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setHouseNumber(address.getHouseNumber());
            addressToUpdate.setState(address.getState());
            addressToUpdate.setStreet(address.getStreet());
            addressToUpdate.setZip(address.getZip());
            entityManager.merge(addressToUpdate);
            return addressToUpdate;
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Address address = get(id);
        entityManager.remove(address);
    }

    @Override
    public List<Address> getAll() {
        return entityManager.createQuery("select a from Address a", Address.class).getResultList();
    }
}

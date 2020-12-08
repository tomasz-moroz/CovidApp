package pl.covidapp.controller;

import pl.covidapp.dto.PersonDto;
import pl.covidapp.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonService personService;

    @POST
    public PersonDto savePerson(PersonDto personDto){
        personService.savePerson(personDto);
        return personDto;
    }

    @Path("/id")
    @GET
    public Response getPersonById(@PathParam("id") Integer id){
        return Response.ok(personService.getPersonById(id)).build();
    }

    @GET
    public List<PersonDto> getAll(){
        return personService.getAllPersons();
    }
    @Path("/{id}")
    @PUT
    //tu widać, że to jest coś co bierze sobie z requestu z przeglądarki, nie?
    //dlatego personDTO jest brane od użytkownika z JSONA.
    public PersonDto update(@PathParam("id") Integer id, PersonDto personDTO) {
        personService.update(id, personDTO);
        return personService.getPersonById(id);
    }
    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Integer id) {
        personService.delete(id);
        return Response.noContent().build();
    }
}

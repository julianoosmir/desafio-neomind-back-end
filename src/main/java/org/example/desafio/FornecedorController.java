package org.example.desafio;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.desafio.entities.Fornecedor;
import org.example.desafio.interfaces.IFornecedorService;
import java.util.List;

@Path("/fornecedor")
public class FornecedorController {

    @Inject
    private IFornecedorService fornecedorService;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Fornecedor!";
    }


    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fornecedor> getAll() {
        return this.fornecedorService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fornecedor getById(@PathParam("id") int id) {
        return this.fornecedorService.getById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id) {
       this.fornecedorService.delete(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Fornecedor fornecedor) {
        this.fornecedorService.save(fornecedor);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Fornecedor fornecedor) {
        this.fornecedorService.update(fornecedor);
    }

}
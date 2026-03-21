package repo;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepo {
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente){
        clientes.add(cliente);
    }
    public List <Cliente> listar(){
        if (clientes != null){
            System.out.println("Nao tem cliente na lista");
        }
        return clientes;
    }
    public Cliente buscaPorCodigo (int codigo){
        for (Cliente c : clientes){
            if (c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    public void remover (int codigo){
        Cliente cliente = buscaPorCodigo(codigo);
        if (cliente != null){
            clientes.remove(cliente);
        }
    }
}

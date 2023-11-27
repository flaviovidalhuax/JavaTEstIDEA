package ms.Examen.Usuario.controller;

import ms.Examen.Usuario.entity.Usuario;
import ms.Examen.Usuario.security.AuthCredentials;
import ms.Examen.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins ="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@RequestBody Usuario usuario){
         return usuarioService.agregarUsuario(usuario);
    }
    @DeleteMapping("/eliminar/{login}")
    public String eliminar(@PathVariable String login){
        return usuarioService.eliminarUsuario(login);
    }
    @PutMapping("/actualizar")
    public String actualizar(@RequestBody Usuario usuario){
        return usuarioService.modificarUsuario(usuario);
    }
    @GetMapping("/buscarByLogin/{login}")
    public Usuario buscarByLogin(@PathVariable String login){
        return usuarioService.obtenerUsuario(login);
    }
    @GetMapping("/buscarAll")
    public List<Usuario> buscarAll(){
        return usuarioService.obtenerTodosLosUsuarios();
    }
    @GetMapping("/buscarByEstatus/{status}")
    public List<Usuario> buscarByEstatus(@PathVariable String status){
        return usuarioService.buscarPorEstatus(status);
    }
    @GetMapping("/buscarByNombre/{nombre}")
    public List<Usuario> buscarByNombre(@PathVariable String nombre){
        return usuarioService.buscarPorNombre(nombre);
    }
    @GetMapping("/buscarByFechaAlta/{fechaAlta}")
    public List<Usuario> buscarByFechaAlta(@PathVariable String fechaAlta){
        return usuarioService.buscarPorFechaInicial(fechaAlta);
    }
    @GetMapping("/buscarByFechaBaja/{fechaBaja}")
    public List<Usuario> buscarByFechaBaja(@PathVariable String fechaBaja){
        return usuarioService.buscarPorFechaFinal(fechaBaja);
    }

}

package ms.Examen.Usuario.security;

import ms.Examen.Usuario.entity.Usuario;
import ms.Examen.Usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findOneByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con login " + login + " no existe."));

        if (usuario.getFechaVigencia() != null) {
            String stringDate=usuario.getFechaBaja();
            String dateFormatPattern = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

            Date fechaVigencia = null;
            try {
                fechaVigencia = dateFormat.parse(stringDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Date fechaActual = new Date();
            if (fechaVigencia.before(fechaActual)) {
                throw new UsernameNotFoundException("La vigencia del usuario con login " + login + " ha expirado.");
            }
        }

        return new UserDeatailsImpl(usuario);
    }
}

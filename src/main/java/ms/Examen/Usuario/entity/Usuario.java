package ms.Examen.Usuario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CLIENTE")
    private Float cliente;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FECHAALTA")
    private String fechaAlta;

    @Column(name = "FECHABAJA")
    private String fechaBaja;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "INTENTOS")
    private Float intentos;

    @Column(name = "FECHAREVOCADO")
    private Date fechaRevocado;

    @Column(name = "FECHA_VIGENCIA")
    private Date fechaVigencia;

    @Column(name = "NO_ACCESO")
    private Integer noAcceso;

    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "AREA")
    private Integer area;

    @Column(name = "FECHAMODIFICACION")
    private Date fechaModificacion;

}
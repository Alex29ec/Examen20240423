package principal.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipocontrato")
public class TipoContrato {
@Id
int id;
String descripcion;
}

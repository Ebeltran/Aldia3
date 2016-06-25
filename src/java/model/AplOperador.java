package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ebeltran
 */
public class AplOperador implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2459702350212264502L;
    
    Date date = new Date();
    private int id_agencia;
    private String login;
    private String password;
    private String password_1;
    private String clave;
    private String clave_1;
    private String usuario;
    private String identi;
    private String nombre_1;
    private String nombre_2;
    private String apellido_1;
    private String apellido_2;
    private Blob firma_mecanica;
    private String correo_email;
    private Date fecha;
    private Date fecha_hoy;
    private Date fec_ini_trabajo;
    private Date fec_desde;
    private Date fec_hasta;
    private Date hora_desde;
    private Date hora_hasta;
    private Date ultimo;
    private Date cambio;
    private Date fec_ult_acceso;
    private Date fec_cambio_clave;
    private Date fecha_reporte;
    
    private String cfec_desde;
    private String chora_desde;
    private String chora_hasta;
    
    private String si_festivo;
    private String si_activo;
    private Integer id_error;
    
    private Boolean lsi_festivo;
    private Boolean lsi_activo;
    
    private String identi_con;
    private String mensaje;
    private Calendar Cal;
    private byte[] imagen_firma;
    
    public Time f_h;
    
    public AplOperador() {
        this.usuario = "";
        this.identi = "";
        this.nombre_1 = "";
        this.nombre_2 = "";
        this.apellido_1 = "";
        this.apellido_2 = "";
        this.firma_mecanica = null;
        this.correo_email = "";     
        this.clave = "";
        this.clave_1 = "";
        this.si_festivo = "No";
        this.si_activo = "Si";
        this.fec_desde = util.ConversionUtil.getTodayToTime(0,0,0);
        this.hora_desde = util.ConversionUtil.getTodayToTime(7,0,0);
        this.hora_hasta = util.ConversionUtil.getTodayToTime(18,0,0);

    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password);
    }

    public String getPassword_1() {
        return password_1;
    }

    public void setPassword_1(String password_1) {
        this.password_1 = password_1;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    public String getClave_1() {
        return clave_1;
    }

    public void setClave_1(String clave_1) {
        this.clave_1 = DigestUtils.md5Hex(clave_1);
    }

    public String getUsuario() {
        return usuario.toUpperCase();
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario.toUpperCase();
    }

    public int getId_agencia() {
        return id_agencia;
    }

    public void setId_agencia(int id_agencia) {
        this.id_agencia = id_agencia;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdenti() {
        return identi;
    }

    public void setIdenti(String identi) {
        this.identi = identi;
    }

    public String getNombre_1() {
        return nombre_1;
    }

    public void setNombre_1(String nombre_1) {
        this.nombre_1 = nombre_1;
    }

    public String getNombre_2() {
        return nombre_2;
    }

    public void setNombre_2(String nombre_2) {
        this.nombre_2 = nombre_2;
    }

    public String getApellido_1() {
        return apellido_1;
    }

    public void setApellido_1(String apellido_1) {
        this.apellido_1 = apellido_1;
    }

    public String getApellido_2() {
        return apellido_2;
    }

    public void setApellido_2(String apellido_2) {
        this.apellido_2 = apellido_2;
    }

    public Blob getFirma_mecanica() {
        return firma_mecanica;
    }

    public void setFirma_mecanica(Blob firma_mecanica) {
        this.firma_mecanica = firma_mecanica;
    }

    public String getCorreo_email() {
        return correo_email.toLowerCase();
    }

    public void setCorreo_email(String correo_email) {
        this.correo_email = correo_email.toLowerCase();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_hoy() {
        return fecha_hoy;
    }

    public void setFecha_hoy(Date fecha_hoy) {
        this.fecha_hoy = fecha_hoy;
    }

    public Date getFec_ini_trabajo() {
        return fec_ini_trabajo;
    }

    public void setFec_ini_trabajo(Date fec_ini_trabajo) {
        this.fec_ini_trabajo = fec_ini_trabajo;
    }

    public Date getFec_desde() {
        return fec_desde;
    }

    public void setFec_desde(Date fec_desde) {
        this.fec_desde = fec_desde;
    }

    public Date getFec_hasta() {
        return fec_hasta;
    }

    public void setFec_hasta(Date fec_hasta) {
        this.fec_hasta = fec_hasta;
    }

    public Date getHora_desde() {
        return hora_desde;
    }

    public void setHora_desde(Date hora_desde) {
        this.hora_desde = hora_desde;
    }

    public Date getHora_hasta() {
        return hora_hasta;
    }

    public void setHora_hasta(Date hora_hasta) {
        this.hora_hasta = hora_hasta;
    }

    public Date getUltimo() {
        return ultimo;
    }

    public void setUltimo(Date ultimo) {
        this.ultimo = ultimo;
    }

    public Date getCambio() {
        return cambio;
    }

    public void setCambio(Date cambio) {
        this.cambio = cambio;
    }

    public Date getFec_ult_acceso() {
        return fec_ult_acceso;
    }

    public void setFec_ult_acceso(Date fec_ult_acceso) {
        this.fec_ult_acceso = fec_ult_acceso;
    }

    public Date getFec_cambio_clave() {
        return fec_cambio_clave;
    }

    public void setFec_cambio_clave(Date fec_cambio_clave) {
        this.fec_cambio_clave = fec_cambio_clave;
    }

    public Date getFecha_reporte() {
        return fecha_reporte;
    }

    public void setFecha_reporte(Date fecha_reporte) {
        this.fecha_reporte = fecha_reporte;
    }

    public String getCfec_desde() {
        return cfec_desde;
    }

    public void setCfec_desde(String cfec_desde) {
        this.cfec_desde = cfec_desde;
    }

    public String getChora_desde() {
        return chora_desde;
    }

    public void setChora_desde(String chora_desde) {
        this.chora_desde = chora_desde;
    }

    public String getChora_hasta() {
        return chora_hasta;
    }

    public void setChora_hasta(String chora_hasta) {
        this.chora_hasta = chora_hasta;
    }

    public String getSi_festivo() {
        return si_festivo;
    }

    public void setSi_festivo(String si_festivo) {
        this.si_festivo = si_festivo;
    }

    public String getSi_activo() {
        return si_activo;
    }

    public void setSi_activo(String si_activo) {
        this.si_activo = si_activo;
    }

    public Integer getId_error() {
        return id_error;
    }

    public void setId_error(Integer id_error) {
        this.id_error = id_error;
    }

    public Boolean getLsi_festivo() {
        return lsi_festivo;
    }

    public void setLsi_festivo(Boolean lsi_festivo) {
        this.lsi_festivo = lsi_festivo;
    }

    public Boolean getLsi_activo() {
        return lsi_activo;
    }

    public void setLsi_activo(Boolean lsi_activo) {
        this.lsi_activo = lsi_activo;
    }

    public String getIdenti_con() {
        return identi_con;
    }

    public void setIdenti_con(String identi_con) {
        this.identi_con = identi_con;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Calendar getCal() {
        return Cal;
    }

    public void setCal(Calendar Cal) {
        this.Cal = Cal;
    }

    public byte[] getImagen_firma() {
        return imagen_firma;
    }

    public void setImagen_firma(byte[] imagen_firma) {
        this.imagen_firma = imagen_firma;
    }

    public Time getF_h() {
        return f_h;
    }

    public void setF_h(Time f_h) {
        this.f_h = f_h;
    }

}
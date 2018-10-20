package modelo;

import java.util.List;
import java.util.Properties;

import modelo.singleton.util.PropertiesUtil;

public class ZonaResidencialSingleton {
	private int estrato;
	private String direccion;
	private String nombre;
	private SAdministrador sadministrador;
	private List<Vivienda> vivienda;

	private static ZonaResidencialSingleton singleton;
	private static final String CONFIGURATION_PROP = "modelo/singleton/util/Configuration.properties";

	private static final String APP_NAME_PROP = "appName";
	private static final String APP_VERSION_PROP = "appVersion";

	private String appName;
	private String appVersion;

	private ZonaResidencialSingleton() {
		Properties prop = PropertiesUtil.loadProperty(CONFIGURATION_PROP);
		this.appName = prop.getProperty(APP_NAME_PROP);
		this.appVersion = prop.getProperty(APP_VERSION_PROP);
	}

	private static synchronized void createInstance() {
		if (singleton == null) {
			singleton = new ZonaResidencialSingleton();
		}
	}

	public static ZonaResidencialSingleton getInstance() {
		if (singleton == null) {
			createInstance();
		}
		return singleton;
	}

	public static ZonaResidencialSingleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(ZonaResidencialSingleton singleton) {
		ZonaResidencialSingleton.singleton = singleton;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public static String getConfigurationProp() {
		return CONFIGURATION_PROP;
	}

	public static String getAppNameProp() {
		return APP_NAME_PROP;
	}

	public static String getAppVersionProp() {
		return APP_VERSION_PROP;
	}

	@Override
	public String toString() {
		return "ZonaResidencialSingleton [appName=" + appName + ", appVersion=" + appVersion + "]";
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SAdministrador getSadministrador() {
		return sadministrador;
	}

	public void setSadministrador(SAdministrador sadministrador) {
		this.sadministrador = sadministrador;
	}

	public List<Vivienda> getVivienda() {
		return vivienda;
	}

	public void setVivienda(List<Vivienda> vivienda) {
		this.vivienda = vivienda;
	}

}

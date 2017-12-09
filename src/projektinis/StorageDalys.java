package projektinis;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StorageDalys
{


	public StringProperty 	modelis, serija, tipas, forma, talpa, greitis;
	public FloatProperty 	kaina;

	//--- Constructor --------------

	public StorageDalys(String modelis_, String serija_, String tipas_, String forma_, String greitis_, String talpa_, Float kaina_) {

		this.modelis = new SimpleStringProperty(modelis_);
		this.serija = new SimpleStringProperty(serija_);
		this.tipas = new SimpleStringProperty(tipas_);
		this.forma = new SimpleStringProperty(forma_);
		this.greitis = new SimpleStringProperty(greitis_);
		this.talpa = new SimpleStringProperty(talpa_);
		this.kaina =  new SimpleFloatProperty(kaina_);
	}

	//--- Properties ---------------

	public FloatProperty kainaProperty() {
		return kaina;
	}
	public StringProperty modelisProperty() {
		return modelis;
	}
	public StringProperty formaProperty() {
		return forma;
	}
	public StringProperty greitisProperty() {
		return greitis;
	}
	public StringProperty serijaProperty() {
		return serija;
	}
	public StringProperty tipasProperty() {
		return tipas;
	}
	public StringProperty talpaProperty() {
		return talpa;
	}
}
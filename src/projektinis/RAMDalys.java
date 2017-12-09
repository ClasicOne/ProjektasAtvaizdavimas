package projektinis;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RAMDalys
{


	public StringProperty 	modelis, atmintiesTech, magistrale, moduliai,  talpa;
	public FloatProperty 	kaina;

	//--- Constructor --------------

	public RAMDalys(String modelis_, String atmintiesTech_, String magistrale_, String moduliai_, String talpa_, Float kaina_) {

		this.modelis = new SimpleStringProperty(modelis_);
		this.atmintiesTech = new SimpleStringProperty(atmintiesTech_);
		this.magistrale = new SimpleStringProperty(magistrale_);
		this.moduliai = new SimpleStringProperty(moduliai_);
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
	public StringProperty atmintiesTechProperty() {
		return atmintiesTech;
	}
	public StringProperty magistraleProperty() {
		return magistrale;
	}
	public StringProperty moduliaiProperty() {
		return moduliai;
	}
	public StringProperty talpaProperty() {
		return talpa;
	}
}
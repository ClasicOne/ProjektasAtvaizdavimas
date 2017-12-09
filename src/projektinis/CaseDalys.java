package projektinis;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CaseDalys
{


	public StringProperty 	galmintojas,forma,maitininmas;
	public FloatProperty 	kaina;

	//--- Constructor --------------

	public CaseDalys(String gamintojas_, String forma_, String maitinimas_, Float kaina_) {

		this.galmintojas = new SimpleStringProperty(gamintojas_);
		this.forma = new SimpleStringProperty(forma_);
		this.maitininmas = new SimpleStringProperty(maitinimas_);
		this.kaina =  new SimpleFloatProperty(kaina_);
	}

	//--- Properties ---------------

	public FloatProperty kainaProperty() {
		return kaina;
	}

	public StringProperty formaProperty() {
		return forma;
	}

	public StringProperty galmintojasProperty() {
		return galmintojas;
	}

	public StringProperty maitininmasProperty() {
		return maitininmas;
	}
}
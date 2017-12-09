package projektinis;

import javafx.beans.property.*;

public class PowerDalys
{

	public StringProperty 	gamintojas;
	public StringProperty 	modelis;
	public StringProperty 	efektyvumas;
	public StringProperty 	forma;
	public StringProperty 	galia;
	public FloatProperty 	kaina;

	//--- Constructor --------------

	public PowerDalys(String gamintojas_, String modelis_, String efektyvumas_, String forma_, String galia_, Float kaina_) {
		this.gamintojas = new SimpleStringProperty(gamintojas_);
		this.modelis = new SimpleStringProperty(modelis_);
		this.efektyvumas = new SimpleStringProperty(efektyvumas_);
		this.forma = new SimpleStringProperty(forma_);
		this.galia = new SimpleStringProperty(galia_);
		this.kaina =  new SimpleFloatProperty(kaina_);
	}

	//--- Properties ---------------




	public FloatProperty kainaProperty() {
		return kaina;
	}

	public StringProperty gamintojasProperty() {
		return gamintojas;
	}

	public StringProperty formaProperty() {
		return forma;
	}

	public StringProperty efektyvumasProperty() {
		return efektyvumas;
	}

	public StringProperty galiaProperty() {
		return galia;
	}

	public StringProperty modelisProperty() {
		return modelis;
	}
}
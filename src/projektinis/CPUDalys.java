package projektinis;

import javafx.beans.property.*;

public class CPUDalys
{

	public StringProperty 	gamintojas;
	public StringProperty 	modelis;
	public IntegerProperty 	branduoliuSkaicius;
	public StringProperty 	daznis;
	public StringProperty 	lizdoTipas;
	public FloatProperty 	kaina;
	
	//--- Constructor --------------

	public CPUDalys(String gamintojas_, String modelis_, Integer branduoliuSkaicius_, String daznis_, String lizdoTipas_, Float kaina_) {
		this.gamintojas = new SimpleStringProperty(gamintojas_);
		this.modelis = new SimpleStringProperty(modelis_);
		this.branduoliuSkaicius = new SimpleIntegerProperty(branduoliuSkaicius_);
		this.daznis = new SimpleStringProperty(daznis_);
		this.lizdoTipas = new SimpleStringProperty(lizdoTipas_);
		this.kaina =  new SimpleFloatProperty(kaina_);

	}

	//--- Properties ---------------


	public StringProperty daznisProperty() {
		return daznis;
	}
	public StringProperty lizdoTipasProperty() {
		return lizdoTipas;
	}

	public FloatProperty kainaProperty() {
		return kaina;
	}

	public StringProperty gamintojasProperty() {
		return gamintojas;
	}

	public IntegerProperty branduoliuSkaiciusProperty() {
		return branduoliuSkaicius;
	}

	public StringProperty modelisProperty() {
		return modelis;
	}
}
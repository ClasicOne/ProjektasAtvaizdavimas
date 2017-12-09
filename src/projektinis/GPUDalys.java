package projektinis;

import javafx.beans.property.*;

public class GPUDalys
{


	public StringProperty 	modelis,atmintis,daznis;
	public FloatProperty 	kaina;

	//--- Constructor --------------

	public GPUDalys(String modelis_,String atmintis_, String daznis_, Float kaina_) {

		this.modelis = new SimpleStringProperty(modelis_);
		this.atmintis = new SimpleStringProperty(atmintis_);
		this.daznis = new SimpleStringProperty(daznis_);
		this.kaina =  new SimpleFloatProperty(kaina_);
	}

	//--- Properties ---------------
	public StringProperty daznisProperty() {
		return daznis;
	}
	public FloatProperty kainaProperty() {
		return kaina;
	}
	public StringProperty modelisProperty() {
		return modelis;
	}
	public StringProperty atmintisProperty() {
		return atmintis;
	}
}
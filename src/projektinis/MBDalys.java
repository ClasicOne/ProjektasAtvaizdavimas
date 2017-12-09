package projektinis;


import javafx.beans.property.*;


public class MBDalys {


    public StringProperty modelis,formFactor,lizdoTipas,maxRam;
    public IntegerProperty ram;
    public FloatProperty kaina;


    //--- Constructor --------------

    public MBDalys(String modelis_, String formFactor_, String lizdoTipas_, int ram_, String maxRam_, Float kaina_) {

        this.modelis = new SimpleStringProperty(modelis_);
        this.ram = new SimpleIntegerProperty(ram_);
        this.formFactor = new SimpleStringProperty(formFactor_);
        this.lizdoTipas = new SimpleStringProperty(lizdoTipas_);
        this.kaina =  new SimpleFloatProperty(kaina_);
        this.maxRam = new SimpleStringProperty(maxRam_);
    }

    //--- Properties ---------------


    public StringProperty maxRamProperty() {
        return maxRam;
    }
    public IntegerProperty ramProperty() {
        return ram;
    }
    public StringProperty lizdoTipasProperty() {
        return lizdoTipas;
    }
    public FloatProperty kainaProperty() {
        return kaina;
    }
    public StringProperty formFactor() {
        return formFactor;
    }
    public StringProperty modelisProperty() {
        return modelis;
    }
}

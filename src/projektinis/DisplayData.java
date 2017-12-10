package projektinis;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class DisplayData {
	static Button button;


	static CPUDalys selectedRowDataCPU = null,saveCPU = null;
	static GPUDalys selectedRowDataGPU = null, saveGPU = null;
	static RAMDalys selectedRowDataRAM = null, saveRAM = null;
	static MBDalys selectedRowDataMB = null, saveMB = null;
	static CaseDalys selectedRowDataCase = null, saveCase = null;
	static PowerDalys selectedRowDataPower = null, savePower = null;
	static StorageDalys selectedRowDataStorage = null, saveStorage = null;

	public static CPUDalys getSelectedRowDataCPU() {
		return selectedRowDataCPU;
	}
	public static GPUDalys getSelectedRowDataGPU() {
		return selectedRowDataGPU;
	}
	public static RAMDalys getSelectedRowDataRAM() {
		return selectedRowDataRAM;
	}
	public static MBDalys getSelectedRowDataMB() {
		return selectedRowDataMB;
	}
	public static CaseDalys getSelectedRowDataCase() {
		return selectedRowDataCase;
	}
	public static PowerDalys getSelectedRowDataPower() {
		return selectedRowDataPower;
	}
	public static StorageDalys getSelectedRowDataStorage() {
		return selectedRowDataStorage;
	}

	public static String  display(String title, String message, String table) throws IOException {
		Stage window = new Stage();
		window.setTitle(title);
		GridPane gridPane = new GridPane();
		 button = new Button("Prodėti į sarašą");
		SplitPane viewersPane = new SplitPane();
		{
			viewersPane.setOrientation(Orientation.VERTICAL);
			switch (table){
				case "cpu":
					tableCPU(viewersPane);
					break;
				case "mb":
					tableMB(viewersPane);
					break;
				case "gpu":
					tableGPU(viewersPane);
					break;
				case "ram":
					tableRAM(viewersPane);
					break;
				case "storage":
					tableStorage(viewersPane);
					break;
				case "power":
					tablePower(viewersPane);
					break;
				case "case":
					tableCase(viewersPane);
					break;
				default:
					break;

			}
			viewersPane.getItems().add(button);
		}
		button.setStyle("-fx-background-color: \n" +
				"        #090a0c,\n" +
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
				"        linear-gradient(#20262b, #191d22),\n" +
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
				"    -fx-background-radius: 5,4,3,5;\n" +
				"    -fx-background-insets: 0,1,2,0;\n" +
				"    -fx-text-fill: white;\n" +
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
				"    -fx-font-family: \"Arial Black\";\n" +
				"    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
				"    -fx-font-size: 12px;\n" +
				"    -fx-padding: 10 10 10 10;");
		button.setOnAction(event -> {
			if (	selectedRowDataStorage != null ||
					selectedRowDataRAM != null ||
					selectedRowDataPower != null ||
					selectedRowDataMB != null ||
					selectedRowDataGPU != null ||
					selectedRowDataCPU != null ||
					selectedRowDataCase != null ) {
				if (selectedRowDataCase != null){
					fillListView("Case",Main.listView);
				window.close();}
				if (selectedRowDataCPU != null)
					if (fillListView("cpu",Main.listView) != 0)
						window.close();
					else Nepasirinkta.DisplayErr("Nesuderinama");
				if (selectedRowDataGPU != null){
					fillListView("gpu",Main.listView);
					window.close();}
				if (selectedRowDataMB != null)
					if (fillListView("mb",Main.listView) != 0)
					window.close();
					else Nepasirinkta.DisplayErr("Nesuderinama");
				if (selectedRowDataPower != null)
					if (fillListView("power",Main.listView) != 0)
						window.close();
					else Nepasirinkta.DisplayErr("Nesuderinama");
				if (selectedRowDataRAM != null){
					fillListView("ram",Main.listView);
					window.close();}
				if (selectedRowDataStorage != null){
					fillListView("storage",Main.listView);
					window.close();}
			}else
				Nepasirinkta.DisplayErr("Nieko nepasirinkote");
			//window.close();

		});

		gridPane.add(viewersPane,1,1);
		Scene scene = new Scene(gridPane,Region.USE_PREF_SIZE,Region.USE_PREF_SIZE);
		window.setScene(scene);
		window.show();
		return null;
	}
	public static int fillListView(String item, ListView<String> listView){
		String list = "";
		int value = 1;
		switch (item){
			case "Case":
				list = "Korpusas:\n Gamintojas: "+selectedRowDataCase.galmintojas.get()+" | Maitinimas: "+selectedRowDataCase.maitininmas.get()+" | Formos faktorius: "+selectedRowDataCase.forma.get()+" | Kaina: "+selectedRowDataCase.kaina.get()+" Eur";
				listView.getItems().add(list);
				saveCase = selectedRowDataCase;
				selectedRowDataCase = null;
				break;
			case "cpu":
			//	String  asd = selectedRowDataCPU.lizdoTipas.get().trim();
			//	String a = saveMB.lizdoTipas.get().trim();
				if (saveMB != null)
					if(selectedRowDataCPU.lizdoTipas.get().replaceAll(" ","").equals(saveMB.lizdoTipas.get())) {
						list = "CPU:\n Gamintojas: " + selectedRowDataCPU.gamintojas.get() + " | Modelis: " + selectedRowDataCPU.modelis.get() + " | Branduolių skaičius: " + selectedRowDataCPU.branduoliuSkaicius.get() + " | Taktinis Dažnis: " + selectedRowDataCPU.daznis.get() + " | Lizdo tipas: " + selectedRowDataCPU.lizdoTipas.get() + " | Kaina: " + selectedRowDataCPU.kaina.get() + " Eur";
						selectedRowDataCPU = null;
					}else
						value = 0;
				else
					list = "CPU:\n Gamintojas: "+selectedRowDataCPU.gamintojas.get()+" | Modelis: "+selectedRowDataCPU.modelis.get()+" | Branduolių skaičius: "+selectedRowDataCPU.branduoliuSkaicius.get()+" | Taktinis Dažnis: "+selectedRowDataCPU.daznis.get()+" | Lizdo tipas: "+selectedRowDataCPU.lizdoTipas.get()+" | Kaina: "+selectedRowDataCPU.kaina.get()+" Eur";
				listView.getItems().add(list);
				saveCPU = selectedRowDataCPU;
				selectedRowDataCPU = null;
				break;
			case "gpu":
				list = "Vaizdo plokštė:\n Modelis: "+selectedRowDataGPU.modelis.get()+" | Atmintis: "+selectedRowDataGPU.atmintis.get()+" | Taktinis dažnis: "+selectedRowDataGPU.daznis.get()+" | Kaina: "+selectedRowDataGPU.kaina.get()+" Eur";
				listView.getItems().add(list);
				selectedRowDataGPU = null;
				break;
			case "mb":
//					String  asd = selectedRowDataMB.lizdoTipas.get().trim();
//					String a = saveCPU.lizdoTipas.get().trim();
				if (saveCPU != null)
					if(selectedRowDataMB.lizdoTipas.get().trim().equals(saveCPU.lizdoTipas.get().trim())) {
						list = "Pagrindinė plokštė:\n Modelis: " + selectedRowDataMB.modelis.get() + " | Formos faktorius: " + selectedRowDataMB.formFactor.get() + " | CPU lizdo tipas: " + selectedRowDataMB.lizdoTipas.get() + " | RAM modolių talpa: " + selectedRowDataMB.ram.get() + " | Maksimalus RAM kiekis: " + selectedRowDataMB.maxRam.get() + " | Kaina: " + selectedRowDataMB.kaina.get() + " Eur";
						selectedRowDataMB = null;
					}else
							value = 0;
				else
					list = "Pagrindinė plokštė:\n Modelis: "+selectedRowDataMB.modelis.get()+" | Formos faktorius: "+selectedRowDataMB.formFactor.get()+" | CPU lizdo tipas: "+selectedRowDataMB.lizdoTipas.get()+" | RAM modolių talpa: "+selectedRowDataMB.ram.get()+" | Maksimalus RAM kiekis: "+selectedRowDataMB.maxRam.get()+" | Kaina: "+selectedRowDataMB.kaina.get()+" Eur";

				listView.getItems().add(list);
				saveMB = selectedRowDataMB;
				selectedRowDataMB = null;
				break;
			case "power":

				if (saveMB != null)
					if(selectedRowDataPower.forma.get().trim().equals(saveMB.formFactor.get().trim())) {
						list = "Maitinimo blokas:\n Gamintojas: " + selectedRowDataPower.gamintojas.get() + " | Modelis: " + selectedRowDataPower.modelis.get() + " | Efektyvumas: " + selectedRowDataPower.efektyvumas.get() + " | Formos faktorius: " + selectedRowDataPower.forma.get() + " | Maitinimo galia: " + selectedRowDataPower.galia.get() + " | Kaina: " + selectedRowDataPower.kaina.get() + " Eur";
						selectedRowDataPower = null;
					}else
						value = 0;
				else
					list = "Maitinimo blokas:\n Gamintojas: "+selectedRowDataPower.gamintojas.get()+" | Modelis: "+selectedRowDataPower.modelis.get()+" | Efektyvumas: "+selectedRowDataPower.efektyvumas.get()+" | Formos faktorius: "+selectedRowDataPower.forma.get()+" | Maitinimo galia: "+selectedRowDataPower.galia.get()+" | Kaina: "+selectedRowDataPower.kaina.get()+" Eur";

				listView.getItems().add(list);
				selectedRowDataPower = null;
				break;
			case "ram":

				list = "RAM:\n Modelis: "+selectedRowDataRAM.modelis.get()+" | Atminties technologija: "+selectedRowDataRAM.atmintiesTech.get()+" | Magistralės dažnis: "+selectedRowDataRAM.magistrale.get()+" | Moduliai: "+selectedRowDataRAM.moduliai.get()+" | Talpa: "+selectedRowDataRAM.talpa.get()+" | Kaina: "+selectedRowDataRAM.kaina.get()+" Eur";
				listView.getItems().add(list);
				selectedRowDataRAM = null;
				break;
			case "storage":
				list = "Vidinis duomenų kaupiklis:\n Modelis: "+selectedRowDataStorage.modelis.get()+" | Serija: "+selectedRowDataStorage.serija.get()+" | Kaupiklio tipas: "+selectedRowDataStorage.tipas.get()+" | Kaupiklio tipas: "+selectedRowDataStorage.tipas.get()+" | Kaupiklio forma: "+selectedRowDataStorage.forma.get()+" | Talpa: "+selectedRowDataStorage.talpa.get()+" | Greitis: "+selectedRowDataStorage.greitis.get()+" Eur";
				listView.getItems().add(list);
				selectedRowDataStorage = null;
				break;
			default:
				 value = 1;
				break;
		}
		return value;
	}

	private static void tableMB(SplitPane viewersPane) throws IOException {
		TableView<MBDalys> tableView = new TableView<>();
		tableView.setMinWidth(710);
		fillTableViewMB(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tableCPU(SplitPane viewersPane) throws IOException {
		TableView<CPUDalys> tableView = new TableView<CPUDalys>();
		tableView.setMinWidth(520);
		fillTableView(tableView);

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);
		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tableGPU(SplitPane viewersPane) throws IOException {
		TableView<GPUDalys> tableView = new TableView<>();
		tableView.setMinWidth(450);
		fillTableViewGPU(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tableCase(SplitPane viewersPane) throws IOException {
		TableView<CaseDalys> tableView = new TableView<>();
		tableView.setMinWidth(410);
		fillTableViewCase(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tableRAM(SplitPane viewersPane) throws IOException {
		TableView<RAMDalys> tableView = new TableView<>();
		tableView.setMinWidth(565);
		fillTableViewRAM(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tablePower(SplitPane viewersPane) throws IOException {
		TableView<PowerDalys> tableView = new TableView<>();
		tableView.setMinWidth(553);
		fillTableViewPower(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	private static void tableStorage(SplitPane viewersPane) throws IOException {
		TableView<StorageDalys> tableView = new TableView<>();
		tableView.setMinWidth(630);
		fillTableViewStorage(tableView);


		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableView.setEditable(true);


		//--------------
		viewersPane.setDividerPositions(0.3);
		viewersPane.getItems().addAll( tableView);
	}
	public static void fillTableView(TableView<CPUDalys> table_view) throws IOException {
		TableColumn<CPUDalys, String> col_gamintojas = new  TableColumn<>("Gamintojas");
		col_gamintojas.setCellValueFactory(new PropertyValueFactory<>("gamintojas"));
		col_gamintojas.setMinWidth(100);

		TableColumn<CPUDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(50);

		TableColumn<CPUDalys, String> col_daznis = new  TableColumn<>("Daznis Hz");
		col_daznis.setCellValueFactory(new PropertyValueFactory<>("daznis"));
		col_daznis.setMinWidth(50);

		TableColumn<CPUDalys, Integer> col_branduoliuSkaicius = new TableColumn<>("Branduoliu Skaicius");
		col_branduoliuSkaicius.setCellValueFactory(new PropertyValueFactory<>("branduoliuSkaicius"));
		col_branduoliuSkaicius.setMinWidth(50);

		TableColumn<CPUDalys, String> col_lizdoTipas = new  TableColumn<>("Lizdo Tipas");
		col_lizdoTipas.setCellValueFactory(new PropertyValueFactory<>("lizdoTipas"));
		col_lizdoTipas.setMinWidth(50);

		TableColumn<CPUDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_gamintojas, col_modelis, col_branduoliuSkaicius, col_daznis, col_lizdoTipas, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("CPU.txt"));
		CPUDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			/*for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);*/
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new CPUDalys(
					fields[0],
					fields[1],
					Integer.parseInt(fields[2]),
					fields[3],
					fields[4],
					Float.parseFloat(fields[5]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataCPU = newValue;
		});

	}
	public static void fillTableViewMB(TableView<MBDalys> table_view) throws IOException {

		TableColumn<MBDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(Region.USE_PREF_SIZE);

		TableColumn<MBDalys, String> col_formFactor = new  TableColumn<>("Formos faktorius");
		col_formFactor.setCellValueFactory(new PropertyValueFactory<>("formFactor"));
		col_formFactor.setMinWidth(Region.USE_PREF_SIZE);

		TableColumn<MBDalys, String > col_lizdoTipas = new TableColumn<>("CPU lizdo tipas");
		col_lizdoTipas.setCellValueFactory(new PropertyValueFactory<>("lizdoTipas"));
		col_lizdoTipas.setMinWidth(Region.USE_PREF_SIZE);

		TableColumn<MBDalys, Integer> col_ram = new  TableColumn<>("RAM modolių talpa");
		col_ram.setCellValueFactory(new PropertyValueFactory<>("ram"));
		col_ram.setMinWidth(Region.USE_PREF_SIZE);

		TableColumn<MBDalys, String> col_maxRam = new  TableColumn<>("Maksimalus RAM kiekis");
		col_maxRam.setCellValueFactory(new PropertyValueFactory<>("maxRam"));
		col_maxRam.setMinWidth(Region.USE_PREF_SIZE);

		TableColumn<MBDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<>("kaina"));
		col_kaina.setMinWidth(Region.USE_PREF_SIZE);

		table_view.getColumns().addAll(col_modelis,  col_lizdoTipas,col_formFactor, col_ram, col_maxRam, col_kaina);

		Scanner scanner = new Scanner(new FileReader("mb.txt"));
		MBDalys record = null;
		while (scanner.hasNext()){
			String[] fields = scanner.nextLine().trim().split("; ");
			for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);
			record = new MBDalys(
					fields[0],
					fields[1],
					fields[2],
					Integer.parseInt(fields[3]),
					fields[4],
					Float.parseFloat(fields[5]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataMB = newValue;
		});
	}
	public static void fillTableViewGPU(TableView<GPUDalys> table_view) throws IOException {

		TableColumn<GPUDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(50);

		TableColumn<GPUDalys, String> col_daznis = new  TableColumn<>("Taktinis dažnis");
		col_daznis.setCellValueFactory(new PropertyValueFactory<>("daznis"));
		col_daznis.setMinWidth(50);

		TableColumn<GPUDalys, String> col_atmintis = new  TableColumn<>("Atmintis");
		col_atmintis.setCellValueFactory(new PropertyValueFactory<>("atmintis"));
		col_atmintis.setMinWidth(50);

		TableColumn<GPUDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<GPUDalys, Float>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_modelis, col_atmintis, col_daznis, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("gpu.txt"));
		GPUDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new GPUDalys(
					fields[0],
					fields[1],
					fields[2],
					Float.parseFloat(fields[3]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataGPU = newValue;
		});
	}
	public static void fillTableViewRAM(TableView<RAMDalys> table_view) throws IOException {

		TableColumn<RAMDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(50);

		TableColumn<RAMDalys, String> col_atmintiesTech = new  TableColumn<>("Atminties technologija");
		col_atmintiesTech.setCellValueFactory(new PropertyValueFactory<>("atmintiesTech"));
		col_atmintiesTech.setMinWidth(50);

		TableColumn<RAMDalys, String> col_magistrale = new  TableColumn<>("Magistralės dažnis");
		col_magistrale.setCellValueFactory(new PropertyValueFactory<>("magistrale"));
		col_magistrale.setMinWidth(50);

		TableColumn<RAMDalys, String> col_moduliai = new  TableColumn<>("Moduliai");
		col_moduliai.setCellValueFactory(new PropertyValueFactory<>("moduliai"));
		col_moduliai.setMinWidth(50);

		TableColumn<RAMDalys, String> col_talpa = new  TableColumn<>("Talpa");
		col_talpa.setCellValueFactory(new PropertyValueFactory<>("talpa"));
		col_talpa.setMinWidth(50);

		TableColumn<RAMDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<RAMDalys, Float>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_modelis,col_atmintiesTech, col_magistrale, col_moduliai, col_talpa, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("RAM.txt"));
		RAMDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new RAMDalys(
					fields[0],
					fields[1],
					fields[2],
					fields[3],
					fields[4],
					Float.parseFloat(fields[5]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataRAM = newValue;
		});
	}
	public static void fillTableViewStorage(TableView<StorageDalys> table_view) throws IOException {

		TableColumn<StorageDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(50);

		TableColumn<StorageDalys, String> col_serija = new  TableColumn<>("Serija");
		col_serija.setCellValueFactory(new PropertyValueFactory<>("serija"));
		col_serija.setMinWidth(50);

		TableColumn<StorageDalys, String> col_tipas = new  TableColumn<>("Kaupiklio tipas");
		col_tipas.setCellValueFactory(new PropertyValueFactory<>("tipas"));
		col_tipas.setMinWidth(50);

		TableColumn<StorageDalys, String> col_forma = new  TableColumn<>("Kaupiklio forma");
		col_forma.setCellValueFactory(new PropertyValueFactory<>("forma"));
		col_forma.setMinWidth(50);

		TableColumn<StorageDalys, String> col_talpa = new  TableColumn<>("Talpa");
		col_talpa.setCellValueFactory(new PropertyValueFactory<>("talpa"));
		col_talpa.setMinWidth(50);

		TableColumn<StorageDalys, String> col_greitis = new  TableColumn<>("Greitis");
		col_greitis.setCellValueFactory(new PropertyValueFactory<>("greitis"));
		col_greitis.setMinWidth(50);


		TableColumn<StorageDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<StorageDalys, Float>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_modelis, col_serija, col_tipas, col_forma, col_talpa, col_greitis, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("storage.txt"));
		StorageDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new StorageDalys(
					fields[0],
					fields[1],
					fields[2],
					fields[3],
					fields[5],
					fields[4],
					Float.parseFloat(fields[6]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataStorage = newValue;
		});
	}
	public static void fillTableViewPower(TableView<PowerDalys> table_view) throws IOException {
		TableColumn<PowerDalys, String> col_gamintojas = new  TableColumn<>("Gamintojas");
		col_gamintojas.setCellValueFactory(new PropertyValueFactory<>("gamintojas"));
		col_gamintojas.setMinWidth(100);

		TableColumn<PowerDalys, String> col_modelis = new  TableColumn<>("Modelis");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("modelis"));
		col_modelis.setMinWidth(50);

		TableColumn<PowerDalys, String> col_efektyvumas = new  TableColumn<>("Efektyvumas");
		col_efektyvumas.setCellValueFactory(new PropertyValueFactory<>("efektyvumas"));
		col_efektyvumas.setMinWidth(50);

		TableColumn<PowerDalys, String > col_forma = new TableColumn<>("Formos faktorius");
		col_forma.setCellValueFactory(new PropertyValueFactory<>("forma"));
		col_forma.setMinWidth(50);

		TableColumn<PowerDalys, String> col_galia = new  TableColumn<>("Maitinimo galia");
		col_galia.setCellValueFactory(new PropertyValueFactory<>("galia"));
		col_galia.setMinWidth(50);

		TableColumn<PowerDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_gamintojas, col_modelis, col_efektyvumas, col_forma, col_galia, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("power.txt"));
		PowerDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new PowerDalys(
					fields[0],
					fields[1],
					fields[2],
					fields[3],
					fields[4],
					Float.parseFloat(fields[5]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataPower = newValue;
		});
	}
	public static void fillTableViewCase(TableView<CaseDalys> table_view) throws IOException {

		TableColumn<CaseDalys, String> col_modelis = new  TableColumn<>("Gamintojas");
		col_modelis.setCellValueFactory(new PropertyValueFactory<>("galmintojas"));
		col_modelis.setMinWidth(50);

		TableColumn<CaseDalys, String> col_daznis = new  TableColumn<>("Formos faktorius");
		col_daznis.setCellValueFactory(new PropertyValueFactory<>("forma"));
		col_daznis.setMinWidth(50);

		TableColumn<CaseDalys, String> col_atmintis = new  TableColumn<>("Maitinimas");
		col_atmintis.setCellValueFactory(new PropertyValueFactory<>("maitininmas"));
		col_atmintis.setMinWidth(50);

		TableColumn<CaseDalys, Float> col_kaina = new TableColumn<>("Kaina");
		col_kaina.setCellValueFactory(new PropertyValueFactory<>("kaina"));
		col_kaina.setMinWidth(50);

		table_view.getColumns().addAll(col_modelis, col_atmintis, col_daznis, col_kaina);

		//-----------------
		//TextFileReader tfr = new TextFileReader("CPU.txt", ';', true);
		Scanner scanner = new Scanner(new FileReader("case.txt"));
		CaseDalys record = null;
		//tring[] fields = null;
		while (scanner.hasNext()){
			String[] fields= scanner.nextLine().trim().split("; ");
			/*for (int i=0;i<fields.length;i++)
				System.out.println(""+ fields[i]+"   "+i);*/
			//if (fields!= null)
			//System.out.println(fields.length);
			record = new CaseDalys(
					fields[0],
					fields[1],
					fields[2],
					Float.parseFloat(fields[3]));
			table_view.getItems().add(record);
		}
		scanner.close();
		table_view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedRowDataCase = newValue;
		});
	}
}
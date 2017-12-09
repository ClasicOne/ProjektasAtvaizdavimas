package projektinis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

//import java.nio.file.Path;

public class TextFileReader 
{
	//--- Constants ----------------
	public static final int FILE_IS_READY	= 0;
	public static final int FILE_NOT_EXIST	= 1;
	public static final int IS_NOT_FILE		= 2;
	public static final int CAN_NOT_READ	= 3;
	
	public static final char    DEF_DELIMITER = ',';		// For a standard CSV text file
	public static final boolean DEF_TRIMMING  = true;
	
	//--- The class attributes -----
	private String  the_filename;
	private String	the_delimiter;
	private boolean the_trim_all;
	
	private boolean is_ready;
	
	private FileReader 		file_rdr;
	private BufferedReader 	buff_rdr;

	//--- Constructors -------------
	public TextFileReader(String file_name, char delimiter, boolean trim_all)
	{
		this.the_filename	= file_name;
		this.the_delimiter	= Character.toString(delimiter);
		this.the_trim_all	= trim_all;
		this.is_ready		= false;
	}
	
	public TextFileReader(String file_name, char delimiter)
	{
		this(file_name, delimiter, DEF_TRIMMING);
	}
	
	public TextFileReader(String file_name)
	{
		this(file_name, DEF_DELIMITER, DEF_TRIMMING);
	}
	
	//--- Open a file for reading ------------
	public int open() throws IOException
	{
		File the_file = new File(the_filename);
		{
			if (the_file.exists())
			{
				if (the_file.isFile())
				{
					if (the_file.canRead())
					{
						file_rdr = new FileReader(the_filename);
						buff_rdr = new BufferedReader(file_rdr);
					}
					else return CAN_NOT_READ; 
				}
				else return IS_NOT_FILE;
			}
			else return FILE_NOT_EXIST;
		}
		this.is_ready = true;
		return FILE_IS_READY;
	}
	
	//--- Close the file processing handlers -------------
	public void close() throws IOException
	{
	    buff_rdr.close();	
	    file_rdr.close();
	}
	
	//--- Read a file line into the String ---
	public String readLine() throws IOException
	{
		if (this.isReady())
			return buff_rdr.readLine();
		
		return null;
	}
	
	//--- Read a file line fields into the String array ------
	public String[] readFields() throws IOException
	{
		if (this.isReady())
		{
			String text_line = null;
		    if ( (text_line = buff_rdr.readLine()) != null) 
		    {
		        String [] string_array = text_line.split(the_delimiter);
		        if (the_trim_all)
		        {
		        	for (int i = 0; i < string_array.length; i++) 
		        		string_array[i] = string_array[i].trim();
		        }
		        return string_array;
		    }
	    }
		return null;
	}
	
	//--- The setters/getters/is... methods ------- 
	public void setDelimiter(char delimiter)
	{
		this.the_delimiter = Character.toString(delimiter);
	}
	
	public String getDelimiter()
	{
		return this.the_delimiter;
	}
	
	public void setTrimming(boolean trim_all)
	{
		this.the_trim_all = trim_all;
	}
	
	public boolean getTrimming()
	{
		return this.the_trim_all;
	}
	
	public String getFileName()
	{
		return this.the_filename;
	}
	
	public boolean isReady()
	{
		return this.is_ready;
	}
	
	public static String getCurrentPath()
	{
		return Paths.get(".").toAbsolutePath().normalize().toString();
	}
	
	//--- System Output ----------
	public void print(String filler) throws IOException
	{
		if (isReady())
		{
			String[] fields = null;
			while ( (fields = readFields()) != null)
			{
				for (String value : fields)
				{
					System.out.print(value + filler + getDelimiter());
				}
				System.out.println();
			}
		}
	}
	
	public void print() throws IOException
	{
		print("/t");
	}
}

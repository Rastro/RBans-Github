package net.zxq.rastrosgonegriefing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlockPlacedListStore
{
	private File storageFile;
	private ArrayList<String> values;
	
	public BlockPlacedListStore(File f)
	{
		this.storageFile = f;
		this.values = new ArrayList<String>();
		
		if(this.storageFile.exists() == false)
		{
			try {
				this.storageFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadFile()
	{
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.storageFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line;
			
			while((line = reader.readLine()) != null)
			{
				if(this.values.contains(line) == false)
				{
					this.values.add(line);
				}
			}
			
			reader.close();
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void saveFile()
	{
		try {
			FileWriter stream = new FileWriter(this.storageFile);
			BufferedWriter out = new BufferedWriter(stream);
			
			for(String value : this.values)
			{
				out.write(value);
				out.newLine();
			}
			
			out.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean contains(String value)
	{
		return this.values.contains(value);
	}
	
	public void add(String value)
	{
		if(this.contains(value) == false)
		{
			this.values.add(value);
		}
	}
	
	public void remove(String value)
	{
		this.values.remove(value);
	}
	
	public ArrayList<String> getValues()
	{
		return this.values;
	}
}
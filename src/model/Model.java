package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Observable;

import com.javahelps.jpa.GameRecord;
import com.javahelps.jpa.GameRecordDataBaseManager;

import model_Data.DisplayLevel;
import model_Data.IDisplay;
import model_Data.Level;
import model_Data.LevelLoader;
import model_Data.LevelSaver;
import model_Data.LoadFactory;
import model_Data.Movement;
import model_Data.SaveFactory;
import view.Game;


public class Model extends Observable implements IModel {


		
	@Override
	public void move(String direction) throws FileNotFoundException, ClassNotFoundException, IOException
	{		
		Movement mv= new Movement();
		mv.mackMove(direction);

	}
		
    public void save1(String sa, String fi) throws IOException
    {
    	SaveFactory saveFactory = new SaveFactory();
		LevelSaver saver = saveFactory.createSaver(sa);
		OutputStream file = new FileOutputStream(fi);
		saver.save(Game.getInstance().getLevel(), file);
    } 
    public void load1(String lo) throws ClassNotFoundException, IOException {

			LoadFactory loadFactory = new LoadFactory();
			LevelLoader loader = loadFactory.createLoader(lo);
			InputStream file = new FileInputStream(lo);
			Level level = loader.load(file);
			
			
			Game game = Game.getInstance();
			game.setLevel(level);
			
		}
	
    

	@Override
	public void exit() {
		
	}

	public void display1() {
		 IDisplay disp=new DisplayLevel();
		 disp.display(Game.getInstance().getLevel());
		
	}
	
	public void submitToDataBase(String recordToSubmit)
	{
		GameRecordDataBaseManager.create("sapir", "Lrvel_1", 3, 69.09);
		GameRecordDataBaseManager.create("yaniv", "Lrvel_2", 3, 49.09);
		GameRecordDataBaseManager.create("sigi", "Lrvel_3", 3, 68.09);
	
	}
	
	public List<GameRecord> pullFromDataBase()
	{
		/*List<GameRecord> tmpList = GameRecordDataBaseManager.readAll();
		return tmpList;*/
		return null;
	}
 
}

package be.thomasmore.myfonoapp;
import android.app.Application;

import java.io.File;



public class GlobalState extends Application{

    public File sd = null;
    boolean refresh = true;


    public File getFilePath(){
        return sd;
    }

    public void setFilePath(File sd){
        this.sd = sd;
    }


    public void setRefresh(boolean refresh){
        this.refresh = refresh;
    }

    public boolean getRefresh(){
        return refresh;
    }

}

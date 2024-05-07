/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import movie.tabeldatamovie;
import movie.datamovie;
import java.util.List;
import DAOmoviefilm.datamovieDAO;
import mainView.MainView;
import DAOImplement.datamovieimplement;
/**
 *
 * @author afriz
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatafilm;
    List<datamovie> d;
    
    public datamoviecontroller(MainView frame){
        this.frame = frame;
        impldatafilm = new datamovieDAO();
        d = impldatafilm.getALL();
        
    }
    
    public void isiTabel(){
        d = impldatafilm.getALL();
        tabeldatamovie t = new tabeldatamovie(d);
        frame.getTabelData().setModel(t);
    }
    
    public void insert(){
        datamovie d = new datamovie();
        d.setJudul(frame.getJTxJudul().getText());
        d.setAlur(Double.parseDouble(frame.getJTxAlur().getText()));
        d.setPenokohan(Double.parseDouble(frame.getJTxPenokohan().getText()));
        d.setAkting(Double.parseDouble(frame.getJTxAkting().getText()));
        
        impldatafilm.insert(d);
    }
    
    public void update(){
        datamovie d = new datamovie();
        
        d.setJudul(frame.getJTxJudul().getText());
        d.setAlur(Double.parseDouble(frame.getJTxAlur().getText()));
        d.setPenokohan(Double.parseDouble(frame.getJTxPenokohan().getText()));
        d.setAkting(Double.parseDouble(frame.getJTxAkting().getText()));
        
        impldatafilm.update(d);
    }
    
    public void delete(){
        String judul = frame.getJTxJudul().getText();
        impldatafilm.delete(judul);
    }
    
}

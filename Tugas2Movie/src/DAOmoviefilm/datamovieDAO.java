/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOmoviefilm;
import movie.datamovie;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplement.datamovieimplement;
/**
 *
 * @author afriz
 */
public class datamovieDAO implements datamovieimplement{
    Connection connection;
    
    final String select = "SELECT * FROM `movie`;";
    final String insert = "INSERT INTO `movie` (judul, alur, penokohan, akting, nilai) VALUES (?, ?, ?, ?, ?);";
    final String update = "update movie set judul=?, alur=?, penokohan=?, akting=?, nilai=? where judul=?";
    final String delete = "delete from movie where judul =?";
    
    public datamovieDAO(){
        connection = connector.connection();
    }
    

    @Override
    public void insert(datamovie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            
            double rating = (m.getAlur()+m.getPenokohan()+m.getAkting())/3;
            statement.setDouble(5, rating);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
            while(rs.next()){
                m.setJudul(rs.getString(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datamovie m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            
            double rating = (m.getAlur()+m.getPenokohan()+m.getAkting())/3;
            statement.setDouble(5, rating);
            String dump = m.getJudul();
            statement.setString(6, dump);
            
            statement.executeUpdate();            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String m) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setString(1, m);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datamovie> getALL() {
        List<datamovie> d = null;
        try{
            d = new ArrayList<datamovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datamovie film = new datamovie();
                film.setJudul(rs.getString("Judul"));
                film.setAlur(rs.getDouble("Alur"));
                film.setPenokohan(rs.getDouble("Penokohan"));
                film.setAkting(rs.getDouble("Akting"));
                film.setNilai(rs.getDouble("Nilai"));
                d.add(film);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(datamovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d;
        
    }
}

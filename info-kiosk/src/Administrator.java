import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Administrator implements ActionListener {
	public void adminTurnOn() {
		
	}
	public void adminTurnOff() {
		System.exit(0);
	}
	public ResultSet adminBrowse(int id, int aithousa) throws Exception {
		ResultSet info;
		MySystem sys=new MySystem();
		info=sys.systemShowEkthema(id,aithousa);
		return info;
	}
	public boolean adminDelete(int id) throws Exception {
		boolean bool=false;
		MySystem sys=new MySystem();
		bool=sys.systemDeleteEkthema(id);
		return bool;
	}
	public boolean adminInsert(int id, String onoma, int aithousa , String plirofories , String image) throws Exception {   
		boolean bool=false;
		MySystem sys=new MySystem();
		bool=sys.systemSaveEkthema(id,onoma, aithousa, plirofories, image);
		return bool;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
